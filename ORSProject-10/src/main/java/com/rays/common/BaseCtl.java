package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.rays.dto.UserDTO;

/**
 * @author Akbar Mansuri
 * BaseCtl is a generic base controller class providing common CRUD
 * operations for all entities.
 * @param <F> Form type extending BaseForm
 * @param <T> DTO type extending BaseDTO
 * @param <S> Service type extending BaseServiceInt<T>
 */
public class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

    @Autowired
    protected S baseService;

    @Value("${page.size}")
    private int pageSize = 0;

    protected UserContext userContext = null;

    /**
     * Sets the UserContext from the session. If no userContext is found, a
     * default user is created.
     * 
     * @param session HttpSession object
     */
    
    @ModelAttribute
    public void setUserContext(HttpSession session) {
        userContext = (UserContext) session.getAttribute("userContext");
        if (userContext == null) {
            UserDTO dto = new UserDTO();
            dto.setLoginId("akbar@gmail.com");
            userContext = new UserContext(dto);
        }
    }

    /**
     * Validates the form data using BindingResult.
     * 
     * @param bindingResult Result of form validation
     * @return ORSResponse containing success status and input errors if any
     */
    public ORSResponse validate(BindingResult bindingResult) {

        ORSResponse res = new ORSResponse(true);

        if (bindingResult.hasErrors()) {

            res.setSuccess(false);

            Map<String, String> errors = new HashMap<String, String>();

            List<FieldError> list = bindingResult.getFieldErrors();
            list.forEach(e -> {
                errors.put(e.getField(), e.getDefaultMessage());
            });
            res.addInputMessage(errors);
        }
        return res;
    }

    /**
     * Saves or updates an entity based on the ID.
     * 
     * @param form           Form object containing entity data
     * @param bindingResult  Result of form validation
     * @return ORSResponse containing success/failure message and entity ID
     */
    @PostMapping("/save")
    public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (res.isSuccess() == false) {
            return res;
        }
        T dto = (T) form.getDto();

        if (dto.getId() != null && dto.getId() > 0) {
            T existDto1 = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
            if (existDto1 != null && dto.getId() != existDto1.getId()) {
                res.setSuccess(false);
                res.addMessage(dto.getLabel() + " already exist");
                return res;
            }
            baseService.update(dto, userContext);
            res.addData(dto.getId());
            res.addMessage(dto.getTableName() + " updated successfully..!!");
        } else {
            if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {
                T existDto = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(),userContext);
                if (existDto != null) {
                    res.setSuccess(false);
                    res.addMessage(dto.getLabel() + " already exist");
                    return res;
                }
            }
            baseService.add(dto, userContext);
            res.addData(dto.getId());
            res.addMessage(dto.getTableName() + " added successfully..!!");
        }

        return res;
    }

    /**
     * Retrieves an entity by its ID.
     * 
     * @param id ID of the entity to retrieve
     * @return ORSResponse containing the entity data or error message
     */
    @GetMapping("get/{id}")
    public ORSResponse get(@PathVariable long id) {
    	
        ORSResponse res = new ORSResponse(true);
        
        T dto = baseService.findById(id, userContext);
        
        if (dto != null) {
            res.addData(dto);
        } else {
            res.setSuccess(false);
            res.addMessage("Record not found");
        }
        return res;
    }

    /**
     * Deletes multiple entities based on the provided IDs.
     * 
     * @param ids     Array of entity IDs to delete
     * @param pageNo  Current page number
     * @param form    Form object containing additional data
     * @return ORSResponse containing updated list and deletion message
     */
    @PostMapping("deleteMany/{ids}")
    public ORSResponse deleteMany(@PathVariable String[] ids, @RequestParam("pageNo") String pageNo,
            @RequestBody F form) {

        ORSResponse res = new ORSResponse(true);

        for (String id : ids) {
            baseService.delete(Long.parseLong(id), userContext);
        }

        T dto = (T) form.getDto();

        List<T> list = baseService.search(dto, Integer.parseInt(pageNo), pageSize, userContext);

        List<T> nextList = baseService.search(dto, Integer.parseInt(pageNo + 1), pageSize, userContext);

        if (list.size() == 0) {
            res.setSuccess(false);
            res.addMessage("Record not found..!!");
        } else {
            res.setSuccess(true);
            res.addMessage("Records Deleted Successfully");
            res.addData(list);
            res.addResult("nextListSize", nextList.size());
        }

        return res;
    }

    /**
     * Searches for entities with pagination.
     * 
     * @param form   Form object containing search criteria
     * @param pageNo Page number for pagination
     * @return ORSResponse containing search results and next page size
     */
    @RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
    public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {

        pageNo = (pageNo < 0) ? 0 : pageNo;

        T dto = (T) form.getDto();

        ORSResponse res = new ORSResponse(true);

        List<T> list = baseService.search(dto, pageNo, pageSize, userContext);

        List<T> nextList = baseService.search(dto, pageNo + 1, pageSize, userContext);

        if (list.size() == 0) {
            res.setSuccess(false);
            res.addMessage("Record not found..!!");
        } else {
            res.setSuccess(true);
            res.addData(list);
            res.addResult("nextListSize", nextList.size());
        }
        return res;
    }

}
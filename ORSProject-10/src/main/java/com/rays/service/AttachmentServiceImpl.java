package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AttachmentDAOImpl;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentServiceImpl is the implementation class of AttachmentServiceInt.
 * 
 * It provides business logic operations for AttachmentDTO by extending
 * BaseServiceImpl, which already contains common CRUD functionality.
 * 
 * This class is annotated with @Service, making it a Spring service component
 * and allowing it to be automatically detected and managed by Spring container.
 * 
 * It uses AttachmentDAOImpl for database interaction.
 * 
 * @author Akbar Mansuri
 */
@Service
public class AttachmentServiceImpl 
        extends BaseServiceImpl<AttachmentDTO, AttachmentDAOImpl> 
        implements AttachmentServiceInt {

}
package com.rays.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * JasperCtl is responsible for generating PDF reports using JasperReports.
 * Current implementation generates a "Project-10" marksheet report.
 */
@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Generate and display Jasper report as PDF in the browser.
     * 
     * @param request HTTP request object
     * @param response HTTP response object
     * @throws JRException if Jasper report compilation or filling fails
     * @throws SQLException if database connection fails
     * @throws IOException if writing PDF to response fails
     */
    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public void display(HttpServletRequest request, HttpServletResponse response)
            throws JRException, SQLException, IOException {

        // Load the Jasper report template
        try (java.io.InputStream jrxmlStream = getClass().getClassLoader()
                .getResourceAsStream("report/Project-10.jrxml")) {

            if (jrxmlStream == null) {
                throw new IOException("Jasper report template not found");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlStream);

            // Prepare empty parameters map (can be populated later if needed)
            Map<String, Object> parameters = new HashMap<>();

            // Get Hibernate connection from EntityManager
            Session session = entityManager.unwrap(Session.class);
            Connection con = ((SessionImpl) session).connection();

            // Fill report with data from DB
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);

            // Export report to PDF bytes
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            // Set response content type and write PDF
            response.setContentType("application/pdf");
            response.getOutputStream().write(pdfBytes);
            response.getOutputStream().flush();

        } // jrxmlStream automatically closed here
    }
}
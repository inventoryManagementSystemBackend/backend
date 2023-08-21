package com.keral.inventoryManagementSystem.controller;


import com.keral.inventoryManagementSystem.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generateReport(HttpServletResponse response) {
        try {
            byte[] reportBytes = reportService.generateReport();

            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            response.setHeader("Content-Disposition", "inline; filename=report.pdf");
            response.getOutputStream().write(reportBytes);
        } catch (IOException | JRException | SQLException e) {

            e.printStackTrace();
        }
    }

    @GetMapping(value = "/generate-sales", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generateSalesReport(HttpServletResponse response) {
        try {
            byte[] reportBytes = reportService.generateReportSale();

            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            response.setHeader("Content-Disposition", "inline; filename=sales_report.pdf");
            response.getOutputStream().write(reportBytes);
        } catch (IOException | JRException | SQLException e) {
            e.printStackTrace();
        }
    }
}

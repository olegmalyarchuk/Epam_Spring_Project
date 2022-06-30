package com.epam.spring.web.mvc.conferences.service;

import com.epam.spring.web.mvc.conferences.dto.ReportsDTO;

public interface ReportService {
    ReportsDTO getReport(int id);

    ReportsDTO createReport(ReportsDTO reportsDTO);

    ReportsDTO updateReport(int id, ReportsDTO reportsDTO);

    void deleteReport(int id);
}

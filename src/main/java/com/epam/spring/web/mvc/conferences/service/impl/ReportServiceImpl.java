package com.epam.spring.web.mvc.conferences.service.impl;

import com.epam.spring.web.mvc.conferences.dto.ReportsDTO;
import com.epam.spring.web.mvc.conferences.dto.UserDto;
import com.epam.spring.web.mvc.conferences.persistence.dao.ReportRepository;
import com.epam.spring.web.mvc.conferences.persistence.model.Reports;
import com.epam.spring.web.mvc.conferences.persistence.model.User;
import com.epam.spring.web.mvc.conferences.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public ReportsDTO getReport(int id) {
        log.info("ReportService: get report by id {}", id);
        return mapReportToReportDTO(reportRepository.getReport(id));
    }

    @Override
    public ReportsDTO createReport(ReportsDTO reportsDTO) {
        Reports reports = mapReportDtoToReport(reportsDTO);
        reports = reportRepository.createReport(reports);
        log.info("ReportService: create report {}", reportsDTO);
        return mapReportToReportDTO(reports);
    }

    @Override
    public ReportsDTO updateReport(int id, ReportsDTO reportsDTO) {
        Reports reports = mapReportDtoToReport(reportsDTO);
        reports = reportRepository.updateReport(id, reports);
        log.info("ReportService: update report with id {}", id);
        return mapReportToReportDTO(reports);
    }

    @Override
    public void deleteReport(int id) {
        reportRepository.deleteReport(id);
        log.info("ReportService: delete report with id {}", id);
    }

    @Override
    public int calculateReportsNumber() {
        log.info("ReportService: reports count{}", reportRepository.calculateReportsNumber());
        return reportRepository.calculateReportsNumber();
    }

    @Override
    public List<ReportsDTO> getReportByEventId(int event_id) {
        log.info("Got Reports by event_id: " + event_id);
        List<Reports> reportsList = reportRepository.getReportByEventId(event_id);
        List<ReportsDTO> reportsDTOList = reportsList.stream().map(u -> mapReportToReportDTO(u)).collect(Collectors.toList());
        return reportsDTOList;
    }

    private Reports mapReportDtoToReport(ReportsDTO reportsDTO) {
        return Reports.builder().report_id(reportsDTO.getReport_id())
                .event_id(reportsDTO.getEvent_id())
                .report_name_ua(reportsDTO.getReport_name_ua())
                .report_name_en(reportsDTO.getReport_name_en())
                .build();
    }

    private ReportsDTO mapReportToReportDTO(Reports reports) {
        return ReportsDTO.builder().report_id(reports.getReport_id())
                .event_id(reports.getEvent_id())
                .report_name_ua(reports.getReport_name_ua())
                .report_name_en(reports.getReport_name_en())
                .build();
    }

}

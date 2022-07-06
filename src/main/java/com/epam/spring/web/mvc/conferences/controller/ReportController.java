package com.epam.spring.web.mvc.conferences.controller;

import com.epam.spring.web.mvc.conferences.dto.ReportsDTO;
import com.epam.spring.web.mvc.conferences.dto.UserDto;
import com.epam.spring.web.mvc.conferences.service.ReportService;
import com.epam.spring.web.mvc.conferences.validation.AdvancedInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ReportsDTO getReport(@PathVariable int id) {
        log.info("Getting Report with id{}", id);
        return reportService.getReport(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReportsDTO createReport(@Validated(AdvancedInfo.class) @RequestBody ReportsDTO reportsDTO) {
        log.info("creating report{}", reportsDTO);
        return reportService.createReport(reportsDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public ReportsDTO updateReport(@PathVariable int id, @RequestBody ReportsDTO reportsDTO) {
        log.info("Updating report with id{}", id);
        return reportService.updateReport(id, reportsDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable int id) {
        log.info("Deleting report with id{}", id);
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/count")
    public int calculateReportsNumber() {
        log.info("Calculating reports number{}", reportService.calculateReportsNumber());
        return reportService.calculateReportsNumber();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getByEventId/{event_id}")
    public List<ReportsDTO> getReportByEventId(@PathVariable int event_id) {
        log.info("Getting reports by event_id {}", event_id);
        return reportService.getReportByEventId(event_id);
    }
}

package com.primeauto.controller;

import com.primeauto.entity.ServiceRecord;
import com.primeauto.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "*")
public class ServiceRecordController {

    @Autowired
    private ServiceRecordService recordService;

    @PostMapping
    public ServiceRecord schedule(@RequestBody ServiceRecord record) {
        return recordService.scheduleService(record);
    }

    @GetMapping
    public List<ServiceRecord> allRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public ServiceRecord getById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }

    @GetMapping("/status/{status}")
    public List<ServiceRecord> getByStatus(@PathVariable String status) {
        return recordService.getByStatus(status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }
}

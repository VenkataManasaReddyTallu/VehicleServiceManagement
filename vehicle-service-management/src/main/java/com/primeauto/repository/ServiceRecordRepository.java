package com.primeauto.repository;

import com.primeauto.entity.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
    List<ServiceRecord> findByStatus(String status);
    List<ServiceRecord> findByServiceDateBetween(LocalDate start, LocalDate end);
}

package com.primeauto.repository;

import com.primeauto.entity.BillOfMaterial;
import com.primeauto.entity.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillOfMaterialRepository extends JpaRepository<BillOfMaterial, Long> {
    List<BillOfMaterial> findByServiceRecord(ServiceRecord serviceRecord);
}

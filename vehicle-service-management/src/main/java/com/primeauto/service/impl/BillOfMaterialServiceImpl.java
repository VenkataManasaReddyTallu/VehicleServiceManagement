package com.primeauto.service.impl;

import com.primeauto.entity.BillOfMaterial;
import com.primeauto.entity.ServiceRecord;
import com.primeauto.repository.BillOfMaterialRepository;
import com.primeauto.repository.ServiceRecordRepository;
import com.primeauto.service.BillOfMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillOfMaterialServiceImpl implements BillOfMaterialService {

    @Autowired
    private BillOfMaterialRepository bomRepository;

    @Autowired
    private ServiceRecordRepository serviceRecordRepository;

    @Override
    public BillOfMaterial addItem(BillOfMaterial bom) {
        Long recordId = bom.getServiceRecord().getId();
        ServiceRecord fullRecord = serviceRecordRepository.findById(recordId)
            .orElseThrow(() -> new RuntimeException("ServiceRecord not found with ID: " + recordId));
        
        bom.setServiceRecord(fullRecord);
        return bomRepository.save(bom);
    }

    @Override
    public List<BillOfMaterial> getAllItems() {
        return bomRepository.findAll();
    }

    @Override
    public List<BillOfMaterial> getItemsByServiceRecordId(Long serviceRecordId) {
        ServiceRecord record = serviceRecordRepository.findById(serviceRecordId).orElse(null);
        return bomRepository.findByServiceRecord(record);
    }

    @Override
    public void deleteItem(Long id) {
        bomRepository.deleteById(id);
    }
}

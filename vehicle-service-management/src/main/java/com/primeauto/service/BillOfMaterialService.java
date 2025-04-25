package com.primeauto.service;

import com.primeauto.entity.BillOfMaterial;

import java.util.List;

public interface BillOfMaterialService {
    BillOfMaterial addItem(BillOfMaterial bom);
    List<BillOfMaterial> getAllItems();
    List<BillOfMaterial> getItemsByServiceRecordId(Long serviceRecordId);
    void deleteItem(Long id);
}

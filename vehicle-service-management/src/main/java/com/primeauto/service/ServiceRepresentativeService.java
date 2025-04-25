package com.primeauto.service;

import com.primeauto.entity.ServiceRepresentative;

import java.util.List;

public interface ServiceRepresentativeService {
    ServiceRepresentative saveRep(ServiceRepresentative rep);
    List<ServiceRepresentative> getAllReps();
    ServiceRepresentative getRepById(Long id);
    void deleteRep(Long id);
}

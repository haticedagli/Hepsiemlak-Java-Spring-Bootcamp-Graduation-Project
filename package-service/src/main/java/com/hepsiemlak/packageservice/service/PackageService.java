package com.hepsiemlak.packageservice.service;

import com.hepsiemlak.packageservice.exception.BadRequestException;
import com.hepsiemlak.packageservice.exception.NotFoundException;
import com.hepsiemlak.packageservice.model.domain.Package;
import com.hepsiemlak.packageservice.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService {

    private final PackageRepository packageRepository;

    public void save(Package packageRequest) {
        if(packageRequest.getId() != null) throw new BadRequestException("Package id must be null");
        packageRepository.save(packageRequest);
    }

    public Package findById(String id) {
        return packageRepository.findById(id).orElseThrow(() -> new NotFoundException("Package not found"));
    }

    public void deleteById(String id) {
        packageRepository.deleteById(id);
    }

    public void update(Package packageRequest) {
        packageRepository.findById(packageRequest.getId()).orElseThrow(() -> new NotFoundException("Package not found"));
        packageRepository.save(packageRequest);
    }

    public List<Package> findAll() {
        return packageRepository.findAll();
    }
}

package com.hepsiemlak.packageservice.controller;

import com.hepsiemlak.packageservice.model.domain.Package;
import com.hepsiemlak.packageservice.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/package")
public class PackageController {

    private final PackageService packageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPackage(@RequestBody Package packageRequest) {
        packageService.save(packageRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Package>> getAllPackages() {
        return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Package> getPackageById(@PathVariable("id") String id) {
        return new ResponseEntity<>(packageService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePackageById(@PathVariable("id") String id) {
        packageService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePackageById(
            @PathVariable("id") String id,
            @RequestBody Package packageRequest
    ) {
        packageRequest.setId(id);
        packageService.update(packageRequest);
    }

}

package com.hepsiemlak.packageservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hepsiemlak.packageservice.model.domain.Package;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends MongoRepository<Package, String> {

}

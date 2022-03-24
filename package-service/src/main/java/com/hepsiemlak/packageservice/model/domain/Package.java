package com.hepsiemlak.packageservice.model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Package {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer advertCount;
    private Integer availableMountCount;
}

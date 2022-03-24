package com.hepsiemlak.lookupservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private String id;
    private String name;
    private List<EstateType> availableEstateTypes;
    private String parentId;
}

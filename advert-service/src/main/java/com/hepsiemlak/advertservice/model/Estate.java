package com.hepsiemlak.advertservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Estate {
    private EstateType estateType;
    private List<Integer> categoryIds;
    private List<AttributePair> attributes;
    private Address address;
    private List<String> images;
}

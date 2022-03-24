package com.hepsiemlak.advertservice.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String province;
    private String district;
    private String neighborhood;
    private String address;
}

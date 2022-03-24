package com.hepsiemlak.advertservice.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Integer value;
    private Currency currency;
}

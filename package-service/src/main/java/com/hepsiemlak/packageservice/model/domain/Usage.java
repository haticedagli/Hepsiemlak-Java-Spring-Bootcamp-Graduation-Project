package com.hepsiemlak.packageservice.model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Usage {
    @Id
    private String id;
    private Long userId;
    private String packageId;
    private Integer count;
}

package com.hepsiemlak.favoriteservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Favorite {
    @Id
    private String id;
    private Long userId;
    private String advertId;
}

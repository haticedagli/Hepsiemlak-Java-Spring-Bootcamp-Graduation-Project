package com.hepsiemlak.advertservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Advert {
    private String id;
    private String title;
    private String description;
    private Status status;
    private Estate estate;
    private Price price;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}

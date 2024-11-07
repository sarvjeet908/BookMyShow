package com.example.bms.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;
    private String language;

}

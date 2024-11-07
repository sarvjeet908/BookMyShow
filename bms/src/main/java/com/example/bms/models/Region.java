package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Region extends BaseModel{
    private String name;
         /*region theatre
           1       m
           1       1
         */
    @OneToMany
    private List<Theatre> theatres;
}

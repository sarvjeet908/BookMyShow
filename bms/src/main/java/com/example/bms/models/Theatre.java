package com.example.bms.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel  {
    private String name;
    private List<Screen> screens;
}

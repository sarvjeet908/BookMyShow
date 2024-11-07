package com.example.bms.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel  {
    private String name;
  /*  theatre  screen
            1      m
            1      1
    */
    @OneToMany
    private List<Screen> screens;
}

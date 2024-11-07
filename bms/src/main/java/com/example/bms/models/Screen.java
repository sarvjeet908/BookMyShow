package com.example.bms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Entity
@Getter
@Setter
public class Screen extends BaseModel {
    private String name;
    /*screen seat
            1       m
            1        1*/
    @OneToMany
    private List<Seat> seats;
    /*
    enum ke case me
    scrn   feature
    1       m
    m        1
    */
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection   //many to many for enum
    private List<Feature> Features;
}

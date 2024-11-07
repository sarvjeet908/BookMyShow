package com.example.bms.models;

import jakarta.persistence.ManyToMany;

public class ShowSeatType extends BaseModel{
    /*
      1 | gold | 150
      1 | diamond | 260

      showseatype show
      1            m
      m            1
      */

    @ManyToMany
    private Show show;
    private String seatType;
    private int price;
}

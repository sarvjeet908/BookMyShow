package com.example.bms.models;

import jakarta.persistence.OneToMany;

import java.util.List;

public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String email;
    @OneToMany
    private List<Booking> bookings;

}

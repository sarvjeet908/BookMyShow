package com.example.bms.models;

import java.util.List;

public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String email;
    private List<Booking> bookings;

}

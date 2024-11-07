package com.example.bms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{
    private BookingStatus status;
    private List<ShowSeat> showSeatList;
    private int amount;
    private List<Payment> payments;

}

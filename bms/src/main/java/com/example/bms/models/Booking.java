package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    //to handle cancellation m:m because if someone cancelled then other user can book it.
    @OneToMany
    private List<ShowSeat> showSeatList;
    private int amount;
    @OneToMany
    private List<Payment> payments;

}

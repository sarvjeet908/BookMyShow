package com.example.bms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    @ManyToOne
    private User user;
    //to handle cancellation m:m because if someone cancelled then other user can book it.
    @OneToMany
    private List<ShowSeat> showSeatList;
    private int amount;
    @OneToMany
    private List<Payment> payments;

}

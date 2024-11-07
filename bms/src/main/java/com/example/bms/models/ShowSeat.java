package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{

    private Show show;
    private Seat seat;
    private SeatStatus seatStatus;
}

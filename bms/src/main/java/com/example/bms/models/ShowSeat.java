package com.example.bms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
    /*
    showseat     show
    1              1        ek seat   Gadar ek prem katha
    m              1

    1 | A1 | booked
    1 | A2 | booked
    2 | A1 |Booked
    */
    @ManyToOne
    private Show show;
    /*
      showseat   seat
      1            1
      m            1
    */
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}

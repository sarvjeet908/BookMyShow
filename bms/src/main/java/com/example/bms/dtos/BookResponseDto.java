package com.example.bms.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor  //added later
public class BookResponseDto {
    private Long bookingId;
    private int amount;
    private BookingResponseStatus bookingResponseStatus;
    private String failureReason;

}

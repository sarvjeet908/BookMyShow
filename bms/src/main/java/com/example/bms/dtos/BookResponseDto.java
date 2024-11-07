package com.example.bms.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
    private long bookingId;
    private int amount;
    private BookingResponseStatus bookingResponseStatus;
}
enum BookingResponseStatus{
    SUCCESS,FAILURE
}

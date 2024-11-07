package com.example.bms.controller;

import com.example.bms.dtos.BookRequestDto;
import com.example.bms.dtos.BookResponseDto;
import com.example.bms.dtos.BookingResponseStatus;
import com.example.bms.exceptions.UserNotFoundException;
import com.example.bms.models.BookingStatus;
import com.example.bms.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/*import org.example.bms.dtos.BookResponseDto.*;*/

@RestController
public class BookingController {

    private BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    public BookResponseDto bookshow(BookRequestDto bookRequestDto) {
        try {
            return bookingService.bookshow(bookRequestDto);
        } catch (UserNotFoundException e) {
            throw new BookResponseDto(null,0, BookingResponseStatus.FAILURE,);
        }
    }
}

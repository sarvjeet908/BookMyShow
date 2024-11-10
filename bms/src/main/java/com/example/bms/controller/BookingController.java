package com.example.bms.controller;

import com.example.bms.dtos.BookRequestDto;
import com.example.bms.dtos.BookResponseDto;
import com.example.bms.dtos.BookingResponseStatus;
import com.example.bms.exceptions.SeatNotAvailable;
import com.example.bms.exceptions.ShowNotAvailableException;
import com.example.bms.exceptions.UserNotFoundException;
import com.example.bms.models.Booking;
import com.example.bms.models.BookingStatus;
import com.example.bms.services.BookingService;
import com.zaxxer.hikari.util.IsolationLevel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/*import org.example.bms.dtos.BookResponseDto.*;*/

@RestController
public class BookingController {

    private BookingService bookingService;
    private static final String USER_INVALID_MSG="User is not valid ";
    private static final String SHOW_INVALID_MSG="Show is not valid ";
    private static final String SEAT_INVALID_MSG="Seat is not valid ";
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    public BookResponseDto bookShow(BookRequestDto request) {

        try {
            Booking booking= bookingService.bookShow(request);
            return new BookResponseDto(booking.getId(),booking.getAmount(),BookingResponseStatus.SUCCESS,"SUCCESS");
        } catch (UserNotFoundException e) {
            return new BookResponseDto(null,0,BookingResponseStatus.FAILURE,USER_INVALID_MSG);
        } catch (ShowNotAvailableException e) {
            return new BookResponseDto(null,0,BookingResponseStatus.FAILURE,SHOW_INVALID_MSG);
        } catch (SeatNotAvailable e) {
            return new BookResponseDto(null,0,BookingResponseStatus.FAILURE,SEAT_INVALID_MSG);
        }


    }
}

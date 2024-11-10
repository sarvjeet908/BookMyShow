package com.example.bms.services;

import com.example.bms.dtos.BookRequestDto;
import com.example.bms.exceptions.SeatNotAvailable;
import com.example.bms.exceptions.ShowNotAvailableException;
import com.example.bms.exceptions.UserNotFoundException;
import com.example.bms.models.*;
import com.example.bms.repositories.ShowRepositories;
import com.example.bms.repositories.ShowSeatRepository;
import com.example.bms.repositories.UserRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepositories userRepositories;
    private ShowRepositories showRepositories;
    private ShowSeatRepository showSeatRepository;

    public Booking bookShow(BookRequestDto request) throws UserNotFoundException, ShowNotAvailableException, SeatNotAvailable {

        Optional<User> optionalUser = userRepositories.findById(request.getUserId());
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException();
        }

        Optional<Show> optionalShow = showRepositories.findById(request.getShowId());
        if (!optionalShow.isPresent()) {
            throw new ShowNotAvailableException();
        }
        List<ShowSeat> reserveShowSeats= reserveShowSeats(request.getShowseatIds());

        return new Booking();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> reserveShowSeats(List<Long> showSeatIds) throws SeatNotAvailable {

        // get list<showSeat> for showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // checking if any of the showSeats are already reserved -> Throw an error
        for (ShowSeat showSeat : showSeats) {
            seatNotAvaliableForBooking(showSeat);
        }
        /* here we do locking, only if
                1. all the seats are available OR
                2. if all the seats are locked and lockedDuration > 10
         */
        List<ShowSeat> reservedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            reservedShowSeats.add(showSeatRepository.save(showSeat));
        }
        return reservedShowSeats;
    }

    private void seatNotAvaliableForBooking(ShowSeat showSeat) {

    }
}

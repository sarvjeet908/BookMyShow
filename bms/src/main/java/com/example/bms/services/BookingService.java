package com.example.bms.services;

import com.example.bms.dtos.BookRequestDto;
import com.example.bms.exceptions.UserNotFoundException;
import com.example.bms.models.Booking;
import com.example.bms.models.User;
import com.example.bms.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    private UserRepositories userRepositories;
    public Booking bookshow(BookRequestDto bookRequestDto) throws UserNotFoundException {
        Optional<User> optionalUser = userRepositories.findById(bookRequestDto.getUserId());

        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException();
        }
        return new Booking();
    }
}

package com.example.bms.services;

import com.example.bms.dtos.SignUpResponseDTO;
import com.example.bms.dtos.SignupRequestDTO;
import com.example.bms.exceptions.EmailAlreadyExistWithUsException;
import com.example.bms.models.User;
import com.example.bms.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepositories userRepositories;
    public UserService(UserRepositories userRepositories){
        this.userRepositories=userRepositories;
    }
    public User signUp(SignupRequestDTO request) throws EmailAlreadyExistWithUsException {
        //check if already user exist or not
        Optional<User> optionalUser = userRepositories.findByEmail(request.getEmail());

        //else create newUser
        User newUser =new User();
        newUser.setEmail(request.getEmail());
        newUser.setName(request.getName());
        newUser.setPhoneNumber(request.getPhoneNumber());
        newUser.setPassWord(request.getPassWord());
        userRepositories.save(newUser);
        return newUser;
    }
}

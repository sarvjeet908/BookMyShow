package com.example.bms.controller;

import com.example.bms.dtos.ResponseStatus;
import com.example.bms.dtos.SignUpResponseDTO;
import com.example.bms.dtos.SignupRequestDTO;
import com.example.bms.exceptions.EmailAlreadyExistWithUsException;
import com.example.bms.exceptions.EmailNotRegisteredWithUsException;
import com.example.bms.models.User;
import com.example.bms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    public SignUpResponseDTO signUp(SignupRequestDTO signupRequestDTO) throws EmailAlreadyExistWithUsException {
        User user= userService.signUp(signupRequestDTO);
        return new SignUpResponseDTO(user.getId(), ResponseStatus.SUCCESS);
    }
    public boolean login(String email,String passWord) throws EmailNotRegisteredWithUsException {
        return  userService.login(email, passWord);

    }

}

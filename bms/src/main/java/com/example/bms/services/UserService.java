package com.example.bms.services;

import com.example.bms.dtos.SignUpResponseDTO;
import com.example.bms.dtos.SignupRequestDTO;
import com.example.bms.exceptions.EmailAlreadyExistWithUsException;
import com.example.bms.models.User;
import com.example.bms.repositories.UserRepositories;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepositories userRepositories;
    public UserService(UserRepositories userRepositories){
        this.userRepositories=userRepositories;
    }
    public User signUp(SignupRequestDTO signupRequestDTO) throws EmailAlreadyExistWithUsException {
        //check if already user exist or not
        String emailId = signupRequestDTO.getEmail();
        String name = signupRequestDTO.getName();
        String passWord = signupRequestDTO.getPassWord();
        //validate emailid
        if(!emailId.equals(userRepositories.findByEmail(emailId))){
            throw new EmailAlreadyExistWithUsException();
        }
        return new User();
    }
}

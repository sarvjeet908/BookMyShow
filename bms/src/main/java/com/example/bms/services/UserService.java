package com.example.bms.services;

import com.example.bms.dtos.SignUpResponseDTO;
import com.example.bms.dtos.SignupRequestDTO;
import com.example.bms.exceptions.EmailAlreadyExistWithUsException;
import com.example.bms.exceptions.EmailNotRegisteredWithUsException;
import com.example.bms.models.User;
import com.example.bms.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private  UserRepositories userRepositories;
    public UserService(UserRepositories userRepositories){
        this.userRepositories=userRepositories;
    }



    public User signUp(SignupRequestDTO request) throws EmailAlreadyExistWithUsException {
        //check if already user exist or not
        Optional<User> user = userRepositories.findByEmail(request.getEmail());
        if (user.isPresent()) throw new EmailAlreadyExistWithUsException();
        //else create newUser
        User newUser =new User();
        newUser.setEmail(request.getEmail());
        newUser.setName(request.getName());
        newUser.setPhoneNumber(request.getPhoneNumber());
        String passWord= request.getPassWord();
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        newUser.setPassWord(encoder.encode(passWord));
        userRepositories.save(newUser);
        return newUser;
    }
    public  boolean login(String email, String passWord) throws EmailNotRegisteredWithUsException {
         Optional<User> user=userRepositories.findByEmail(email);
         if(!user.isPresent()){
           throw new EmailNotRegisteredWithUsException();
        }
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        boolean matches = encoder.matches(passWord, user.get().getPassWord());
        return matches;
    }
}

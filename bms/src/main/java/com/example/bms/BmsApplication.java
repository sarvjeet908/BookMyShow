package com.example.bms;

import com.example.bms.controller.UserController;
import com.example.bms.dtos.SignupRequestDTO;
import com.example.bms.models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmsApplication implements CommandLineRunner {
	private final UserController userController;
	public BmsApplication(UserController userController) {
		this.userController=userController;
	}



	public static void main(String[] args)   {
		SpringApplication.run(BmsApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		SignupRequestDTO request=new SignupRequestDTO();

		request.setEmail("sarvjeet908@gmail.com");
		request.setName("Streetcar");
		request.setPhoneNumber("7619390236");
		request.setPassWord("streetcar908");

		userController.signUp(request);

	}
}

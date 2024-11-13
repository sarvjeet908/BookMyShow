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

		request.setEmail("user@gmail.com");
		request.setName("Govind809");
		request.setPhoneNumber("7619390236");
		request.setPassWord("password");

		//userController.signUp(request);

		userController.login("user@gmail.com","password");

	}
}

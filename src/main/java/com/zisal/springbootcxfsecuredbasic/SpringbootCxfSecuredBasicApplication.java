package com.zisal.springbootcxfsecuredbasic;

import com.zisal.springbootcxfsecuredbasic.entity.User;
import com.zisal.springbootcxfsecuredbasic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SpringbootCxfSecuredBasicApplication {

	@Autowired
	private IUserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCxfSecuredBasicApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			List<User> users = userService.findAll();
			for (User user : users) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				userService.update(user);
			}
		};
	}
}

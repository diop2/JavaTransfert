package com.devweb.rh;

import com.devweb.rh.model.Compte;
import com.devweb.rh.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class RhApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RhApplication.class, args);
	}
	@Autowired
	PasswordEncoder encoder;
	CompteRepository compteRepository;
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(encoder.encode("passer"));

	}


}

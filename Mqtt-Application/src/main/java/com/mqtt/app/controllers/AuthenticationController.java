package com.mqtt.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mqtt.app.dtos.LoginUserDto;
import com.mqtt.app.dtos.RegisterUserDto;
import com.mqtt.app.dtos.RequestOtpDto;
import com.mqtt.app.entities.User;
import com.mqtt.app.services.AuthenticationService;
import com.mqtt.app.services.JwtService;
import com.mqtt.app.services.OtpService;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	private final JwtService jwtService;
	private final AuthenticationService authenticationService;
	private final OtpService otpService;

	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService,
			OtpService otpService) {
		super();
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
		this.otpService = otpService;

	}

	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);

		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<User> authenticate(@RequestBody LoginUserDto loginUserDto) throws MessagingException {

		User authenticatedUser = authenticationService.authenticate(loginUserDto);

		if (authenticatedUser != null) {

			return ResponseEntity.ok(otpService.generateOtp(authenticatedUser));

		}

		throw new BadCredentialsException("Bad credentials");

	}

//	@GetMapping("/verifyOtp")
//	public ResponseEntity<String> verifyOtp(@RequestParam("email") String email, @RequestParam("otp") String otp)
//			throws MessagingException {
//
//		String response = otpService.isOTPRequired(email, otp);
//
//		return ResponseEntity.ok(response);
//
//	}

	@PostMapping("/verifyOtp")
	public ResponseEntity<String> verifyOtp(@RequestBody RequestOtpDto requestOtpDto) throws MessagingException {

		ResponseEntity<String> response = otpService.isOTPRequired(requestOtpDto.getEmail(), requestOtpDto.getOtp());

		return response;

	}

}
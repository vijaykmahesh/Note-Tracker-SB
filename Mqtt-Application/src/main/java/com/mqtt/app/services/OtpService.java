package com.mqtt.app.services;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mqtt.app.entities.OtpRequests;
import com.mqtt.app.entities.User;
import com.mqtt.app.exceptions.OTPExpiredException;
import com.mqtt.app.repositories.OtpRequestsRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class OtpService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private OtpRequestsRepository otpRequestsRepository;

	@Autowired
	private JavaMailSender javaMailSenderImpl;


	public User generateOtp(User authenticatedUser) throws MessagingException {

		Iterable<OtpRequests> findAll = otpRequestsRepository.findAll();

		int size = (int) StreamSupport.stream(findAll.spliterator(), false).count();
		System.out.println("Size: " + size);

		if (size == 1) {

			otpRequestsRepository.deleteAll();

		}

		String OTP = String.valueOf(new Random().nextInt(9999) + 1000);// Generates a random 4 digit code

		OtpRequests otpRequests = new OtpRequests();

		otpRequests.setUser(authenticatedUser);
		otpRequests.setOtp(OTP);
		otpRequests.setExpiresAt(LocalDateTime.now().plusMinutes(2));

		otpRequestsRepository.save(otpRequests);

		sendOTPEmail(authenticatedUser, OTP);

		return otpRequests.getUser();

	}

	public ResponseEntity<String> isOTPRequired(String email, String otp) throws MessagingException {

		OtpRequests otpRequest = otpRequestsRepository.findByUser(email, otp);

		if (otpRequest == null || !otpRequest.getOtp().equals(otp)) {
			
			 return ResponseEntity
		                .status(HttpStatus.BAD_REQUEST) // or any other status
		                .body("Entered Wrong Otp");

		}

		User userDetails = otpRequest.getUser();

		if (otpRequest.getExpiresAt().isBefore(LocalDateTime.now())) {

			otpRequestsRepository.delete(otpRequest);

			throw new OTPExpiredException("Otp is expired");
			
		}

		else {

			otpRequestsRepository.delete(otpRequest);

//			RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getFullName(),
//					userDetails.getEmail());

			String generateToken = jwtService.generateToken(userDetails);

			return new ResponseEntity<String>(generateToken, HttpStatus.OK);

		}

	}

	public void sendOTPEmail(User user, String otp) throws MessagingException {

		MimeMessage message = javaMailSenderImpl.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(user.getEmail());
		helper.setSubject("Here's your One Time Password (OTP) - Expire in 2 minutes!");

		String content = "<p>Hello " + user.getUsername() + "</p>"
				+ "<p>For security reasons, you're required to use the following " + "One Time Password to login:</p>"
				+ "<p><b>" + otp + "</b></p>" + "<br>" + "<p>Note: this OTP is set to expire in 2 minutes.</p>";

		helper.setText(content, true); // true indicates HTML content

		javaMailSenderImpl.send(message);

	}

}

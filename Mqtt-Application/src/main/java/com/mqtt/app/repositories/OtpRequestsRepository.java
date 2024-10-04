package com.mqtt.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mqtt.app.entities.OtpRequests;

public interface OtpRequestsRepository extends CrudRepository<OtpRequests, Integer> {

	@Query(value = "SELECT op FROM OtpRequests op inner join User u on op.user.id = u.id WHERE u.email = :email and op.otp = :otp")
	OtpRequests findByUser(String email, String otp);
	


}

package com.mqtt.app;

import java.io.UnsupportedEncodingException;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqttApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, MqttException {
		SpringApplication.run(MqttApplication.class, args);

	}

}

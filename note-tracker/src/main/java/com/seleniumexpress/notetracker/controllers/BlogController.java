package com.seleniumexpress.notetracker.controllers;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogController {

	public static final String BROKER_ADDRESS = "tcp://broker.emqx.io:1883";

	@GetMapping("/dashboard")
	public String getUserDetails(Model model) throws MqttException, InterruptedException {

		MqttClient mqttClient = new MqttClient(BROKER_ADDRESS, MqttClient.generateClientId());

		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(false);

		mqttClient.connect(options);

		mqttClient.subscribe("my/dynamic/topics/ecr", 0);

		mqttClient.setCallback(new MqttCallback() {

			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub

				model.addAttribute("message", message);

				System.out.println("received TID" + topic + "message is " + message);

			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken token) {
				// TODO Auto-generated method stub

			}

			@Override
			public void connectionLost(Throwable cause) {
				// TODO Auto-generated method stub

			}
		});

		return "blog-view";
	}

}

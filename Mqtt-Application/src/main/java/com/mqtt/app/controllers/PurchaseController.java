package com.mqtt.app.controllers;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mqtt.app.dtos.TerminalRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PurchaseController {

	public static final String BROKER_ADDRESS = "tcp://broker.emqx.io:1883";

	@CrossOrigin("*")
	@PostMapping("/purchase")
	public ResponseEntity<String> pushTransaction(@RequestBody TerminalRequest request)
			throws MqttException, UnsupportedEncodingException {

		MqttClient mqttClient = new MqttClient(BROKER_ADDRESS, MqttClient.generateClientId());

		// Connect to the broker
		MqttConnectOptions options = new MqttConnectOptions();

		options.setUserName("test");
		options.setPassword("test".toCharArray());

		mqttClient.connect(options);

		// Define base topic for dynamic topics
		String baseTopic = "integration/";

		// Create and send message to topic1
		String topicName = baseTopic + request.getTerminalId();

		System.out.println("topic is " + topicName);

		System.out.println("amount is " + request.getAmount());

		LocalDateTime now = LocalDateTime.now();

		// Convert to milliseconds since the epoch
		long milliseconds = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

		// Milliseconds is already a long, but you can explicitly cast it if needed
		long timeStamp = milliseconds;

		System.out.println("Long value: " + timeStamp);

		JSONObject jsonData = new JSONObject();

		jsonData.put("type", "Purchase");
		jsonData.put("messagetype", "req");
		jsonData.put("amount", request.getAmount());
		jsonData.put("timeStamp", timeStamp);
		jsonData.put("messageId", UUID.randomUUID().toString());
		jsonData.put("timeout", 30);

		// Convert JSON to byte array
		String jsonString = jsonData.toString();

		System.out.println("json data " + jsonString);

		byte[] payload = jsonString.getBytes("UTF-8");

		// Create and configure MQTT message
		MqttMessage message = new MqttMessage(payload);
		message.setQos(2); // Set QoS level (optional)

		mqttClient.publish(topicName, message);

		System.out.println("Published message to ecr: " + topicName);

		final String[] response = new String[1];

		String wildcardTopic = baseTopic + "#";
		mqttClient.subscribe(wildcardTopic, 0);

		mqttClient.setCallback(new MqttCallback() {
			@Override
			public void connectionLost(Throwable cause) {
				System.out.println("Connection lost: " + cause.getMessage());
			}

			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {

				System.out.println("Received message on topic: " + topic);
				System.out.println("Message payload: " + new String(message.getPayload()));

				response[0] = new String(message.getPayload());

				System.out.println(response[0]);

			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken token) {
				// Optional: Handle message delivery completion (if needed)
			}
		});

		while (response[0] == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		mqttClient.disconnect();

		return new ResponseEntity<String>(response[0], HttpStatus.OK);

	}

}

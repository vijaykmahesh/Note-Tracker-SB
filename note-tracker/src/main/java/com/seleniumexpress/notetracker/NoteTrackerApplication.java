package com.seleniumexpress.notetracker;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seleniumexpress.notetracker.model.CustomCallBack;


@SpringBootApplication
public class NoteTrackerApplication {

	public static final String BROKER_ADDRESS = "tcp://broker.emqx.io:1883";

	public static MqttClient mqttClient;

	public static void main(String[] args) throws MqttPersistenceException, MqttException {

		SpringApplication.run(NoteTrackerApplication.class, args);

		mqttClient = new MqttClient(BROKER_ADDRESS, MqttClient.generateClientId());

		// Connect to the broker
		mqttClient.connect();

		// Define base topic for dynamic topics
		String baseTopic = "my/dynamic/topics/";

		// Define data to send
		String message = "Hello from topics";

		// Create and send message to topic1
		String topic1 = baseTopic + "ecr";
		mqttClient.publish(topic1, message.getBytes(), 0, true);
		System.out.println("Published message to ecr: " + topic1);

		// Create and send message to topic2
		String topic2 = baseTopic + "pos";
		mqttClient.publish(topic2, message.getBytes(), 0, true);
		System.out.println("Published message to pos: " + topic2);

		String wildcardTopic = baseTopic + "#";
		mqttClient.subscribe(wildcardTopic, 0);

		mqttClient.setCallback(new CustomCallBack());

	}

}

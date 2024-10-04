package com.seleniumexpress.notetracker.model;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.seleniumexpress.notetracker.NoteTrackerApplication;

public class CustomCallBack implements MqttCallback {

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
		System.out.println("connection lost for server");

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("inside server");

		System.out.println("topic is " + topic + "message is " + message);

		NoteTrackerApplication.mqttClient.publish("my/dynamic/topics/ecr", message.toString().getBytes(), 0, true);

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}

}

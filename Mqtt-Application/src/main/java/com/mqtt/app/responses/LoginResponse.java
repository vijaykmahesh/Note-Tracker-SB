package com.mqtt.app.responses;

public class LoginResponse {
	
    private String token;

    private long expiresIn;
    
    private String otpExpired;

    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getOtpExpired() {
		return otpExpired;
	}

	public void setOtpExpired(String otpExpired) {
		this.otpExpired = otpExpired;
	}

	@Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
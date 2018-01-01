package com.cultuzz.de;


public class TokenData {
	
	private String cardData;
	private String token;
	
	public String getCardData() {
		return cardData;
	}
	public void setCardData(String cardData) {
		this.cardData = cardData;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "TokenData [cardData=" + cardData + ", token=" + token + "]";
	}
	
	
	
}

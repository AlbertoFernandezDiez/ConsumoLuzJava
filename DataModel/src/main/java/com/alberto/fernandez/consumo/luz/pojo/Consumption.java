package com.alberto.fernandez.consumo.luz.pojo;

import java.sql.Date;
import java.util.Calendar;

public class Consumption {

	private int userId;
	private int consumptionId;
	private float quantity;
	private float price;
	private java.sql.Date endingDate;
	private int year;
	
	@SuppressWarnings("deprecation")
	public Consumption() {
		super();
		this.userId = -1;
		this.consumptionId = -1;
		this.price = 0f;
		this.endingDate = new Date(System.currentTimeMillis());
		this.year = this.endingDate.getYear();
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getConsumptionId() {
		return this.consumptionId;
	}

	public void setConsumptionId(int consumption) {
		this.consumptionId = consumption;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public java.sql.Date getEndingDate() {
		return this.endingDate;
	}

	public void setEndingDate(java.sql.Date endingData) {
		this.endingDate = endingData;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(endingData.getTime());
		this.setYear(cal.get(Calendar.YEAR));
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Consumption [userId=" + userId + ", consumption=" + consumptionId + ", price=" + price + ", endingData="
				+ endingDate + ", year=" + year + "]";
	}
	
	
	
}

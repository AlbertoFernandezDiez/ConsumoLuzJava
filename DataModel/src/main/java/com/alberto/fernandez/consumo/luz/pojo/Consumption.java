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
		this.year = Calendar.getInstance().get(Calendar.YEAR);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consumptionId;
		result = prime * result
				+ ((endingDate == null) ? 0 : endingDate.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + Float.floatToIntBits(quantity);
		result = prime * result + userId;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumption other = (Consumption) obj;
		if (consumptionId != other.consumptionId)
			return false;
		if (endingDate == null) {
			if (other.endingDate != null)
				return false;
		} else if (!endingDate.equals(other.endingDate))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (Float.floatToIntBits(quantity) != Float
				.floatToIntBits(other.quantity))
			return false;
		if (userId != other.userId)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Consumption [userId=" + userId + ", consumptionId="
				+ consumptionId + ", quantity=" + quantity + ", price=" + price
				+ ", endingDate=" + endingDate + ", year=" + year + "]";
	}

	
	
	
	
}

package com.infosys.dto;

import com.infosys.entity.PassengerDetails;

public class PassengerDetailsDTO 
{
	private int passengerId;
	private String passengerName;
	private int passengerAge;
	private String passengerGender;
	private String pnr;
	
	public PassengerDetailsDTO()
	{}

	public PassengerDetailsDTO(int passengerId, String passengerName, int passengerAge, String passengerGender,
			String pnr) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.pnr = pnr;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	@Override
	public String toString() {
		return "PassengerDetailsDTO [passengerId=" + passengerId + ", passengerName=" + passengerName
				+ ", passengerAge=" + passengerAge + ", passengerGender=" + passengerGender + ", pnr=" + pnr + "]";
	}

	public PassengerDetails preparePassengerEntity() 
	{
		PassengerDetails passenger = new PassengerDetails();
		passenger.setPassengerId(this.getPassengerId());
		passenger.setPassengerName(this.getPassengerName());
		passenger.setPassengerAge(this.getPassengerAge());
		passenger.setPassengerGender(this.getPassengerGender());
		passenger.setPnr(this.getPnr());
		return passenger;
	}
}

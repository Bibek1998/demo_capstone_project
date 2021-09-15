package com.infosys.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infosys.dto.PassengerDetailsDTO;

@Entity
@Table(name = "passenger_details")
public class PassengerDetails 
{
	@Id
	private Integer passengerId;
	private String passengerName;
	private Integer passengerAge;
	private String passengerGender;
	private String pnr;
	
	public PassengerDetails()
	{}

	public PassengerDetails(int passengerId, String passengerName, int passengerAge, String passengerGender,
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
		return "PassengerDetails [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerGender=" + passengerGender + ", pnr=" + pnr + "]";
	}

	public PassengerDetailsDTO preparePassengerDTO() 
	{
		PassengerDetailsDTO passenger = new PassengerDetailsDTO();
		passenger.setPassengerId(this.getPassengerId());
		passenger.setPassengerName(this.getPassengerName());
		passenger.setPassengerAge(this.getPassengerAge());
		passenger.setPassengerGender(this.getPassengerGender());
		passenger.setPnr(this.getPnr());
		return passenger;
	}
	
}

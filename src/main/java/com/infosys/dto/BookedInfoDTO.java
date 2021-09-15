package com.infosys.dto;

import java.util.ArrayList;
import java.util.List;

public class BookedInfoDTO 
{
	private String pnr;
	private Double totalFare;
	private List<BookedPassengerInfoDTO> passengerList;
	
	public BookedInfoDTO() 
	{
		this.passengerList = new ArrayList<>();
	}

	public BookedInfoDTO(String pnr, Double totalFare, List<BookedPassengerInfoDTO> passengerList) {
		super();
		this.pnr = pnr;
		this.totalFare = totalFare;
		this.passengerList = passengerList;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public List<BookedPassengerInfoDTO> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<BookedPassengerInfoDTO> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "BookedInfoDTO [pnr=" + pnr + ", totalFare=" + totalFare + ", passengerList=" + passengerList + "]";
	}
}

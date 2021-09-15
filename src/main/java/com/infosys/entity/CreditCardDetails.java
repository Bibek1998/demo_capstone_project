package com.infosys.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard_details")
public class CreditCardDetails 
{
	@Id
	private String cardNumber;
	private String cardHolderName;
	private String cvv;
	private String securepin;
	private String expiryMonth;
	private String expiryYear;
	private String totalBill;
	public CreditCardDetails()
	{}
	public CreditCardDetails(String cardNumber, String cardHolderName, String cvv, String securepin, String expiryMonth,
			String expiryYear, String totalBill) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.securepin = securepin;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBill = totalBill;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getSecurepin() {
		return securepin;
	}
	public void setSecurepin(String securepin) {
		this.securepin = securepin;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "CreditCardDetails [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cvv=" + cvv
				+ ", securepin=" + securepin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", totalBill=" + totalBill + "]";
	}	
}

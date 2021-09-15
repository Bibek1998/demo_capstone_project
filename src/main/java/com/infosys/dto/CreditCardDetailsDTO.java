package com.infosys.dto;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

public class CreditCardDetailsDTO 
{
	@Id
	@Pattern(regexp = "[0-9]{16}", message = "{message.credit.card.id.property}")
	private String cardNumber;
	private String cardHolderName;
	@Pattern(regexp = "[0-9]{3}", message = "{message.credit.card.cvv.property}")
	private String cvv;
	@Pattern(regexp = "[0-9]{6}", message = "{message.credit.card.id.property}")
	private String securepin;
	@Pattern(regexp = "[\\w]{3}", message = "{message.credit.card.month.property}")
	private String expiryMonth;
	@Pattern(regexp = "[1-2][0-9]{3}", message = "{message.credit.card.year.property}")
	private String expiryYear;
	private String billAmount;
	
	public CreditCardDetailsDTO() {}
	public CreditCardDetailsDTO(String cardNumber, String cardHolderName, String cvv, String securepin,
			String expiryMonth, String expiryYear, String billAmount) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.securepin = securepin;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.billAmount = billAmount;
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
	public String getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "CreditCardDetailsDTO [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cvv=" + cvv
				+ ", securepin=" + securepin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", billAmount=" + billAmount + "]";
	}
}

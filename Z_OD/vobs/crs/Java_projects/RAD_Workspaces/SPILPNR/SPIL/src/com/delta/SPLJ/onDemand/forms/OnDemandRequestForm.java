package com.delta.SPLJ.onDemand.forms;




import org.apache.struts.validator.ValidatorForm;



public class OnDemandRequestForm extends ValidatorForm {

	private String email;

	private String flightNumber;

	private String localDepartureDate;

	private String legOrigApCode;
	
	private String SOAResponse = null;


	public String getLocalDepartureDate() {
		return localDepartureDate;
	}

	public void setLocalDepartureDate(String localDepartureDate) {
		this.localDepartureDate = localDepartureDate;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLegOrigApCode() {
		return legOrigApCode;
	}

	public void setLegOrigApCode(String legOrigApCode) {
		this.legOrigApCode = legOrigApCode;
	}

	public String getSOAResponse() {
		return SOAResponse;
	}

	public void setSOAResponse(String sOAResponse) {
		SOAResponse = sOAResponse;
	}

	
	
}


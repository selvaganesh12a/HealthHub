package com.healthhubapi.api.model;

import javax.validation.constraints.NotBlank;

public class CCPLoginRequest {
    @NotBlank
    private String prnNumber;

    public String getPrnNumber() {
		return prnNumber;
	}

	public void setPrnNumber(String prnNumber) {
		this.prnNumber = prnNumber;
	}

	@NotBlank
    private String mobileNumber;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

 
}

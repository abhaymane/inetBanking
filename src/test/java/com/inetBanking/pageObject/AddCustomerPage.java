package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddNewCustomer;
	@FindBy(name="name")
	WebElement custName;
	
	@FindBy(name="rad1")
	WebElement rdGender;
	@FindBy(name="dob")
	WebElement dateOfBirth;
	@FindBy(name="addr")
	WebElement address;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="pinno")
	WebElement pinNum;
	@FindBy(name="telephoneno")
	WebElement telePhone;
	@FindBy(name="emailid")
	WebElement email;
	@FindBy(name="password")
	WebElement pass;
	@FindBy(name="sub")
	WebElement submit;
	public void addNewCust() {
		linkAddNewCustomer.click();
	}
	public void custName(String cname) {
		custName.sendKeys(cname);
	}
	public void rdGender(String cgender) {
		rdGender.click();
	}
	public void dateOfBirth(String mm,String dd,String yy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
	}
	public void address(String caddress) {
		address.sendKeys(caddress);
	}
	public void city(String ccity) {
		city.sendKeys(ccity);
	}
	public void state(String cstate) {
		state.sendKeys(cstate);
	}
	public void pinNum(String cpin) {
	pinNum.sendKeys(String.valueOf(cpin));
	}
	public void telePhoneNum(String ctelephoneno) {
		telePhone.sendKeys(ctelephoneno);
	}
	public void emailId(String cemailid) {
		email.sendKeys(cemailid);
	}
	public void password(String cpassword) {
		pass.sendKeys(cpassword);
	}
	public void submitBtn() {
		submit.click();
	}

}

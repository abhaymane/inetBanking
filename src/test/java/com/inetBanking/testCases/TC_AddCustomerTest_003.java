package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddCustomerPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name is Provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addCust=new AddCustomerPage(driver);
		addCust.addNewCust();
		logger.info("Providing customer details");
		addCust.custName("Abhay");
		addCust.rdGender("Male");
		addCust.dateOfBirth("11","10", "1990");
		addCust.address("Mhaswad");
		addCust.city("Satara");
		addCust.state("Maharashtra");
		
		addCust.pinNum("415509");
		addCust.telePhoneNum("9403323461");
		String email=randomestring()+"@gmail.com";
		addCust.emailId(email);;
		addCust.password("abhay@123");
		addCust.submitBtn();
		Thread.sleep(3000);
		logger.info("validation started..");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			logger.info("testcases is passed...");
			Assert.assertTrue(true);
		}
		else {
			logger.info("testcases is failed...");
			capturescreenShot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	

}

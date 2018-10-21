package com.xero.automation;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class XeroTestCases extends ReusableMethods {

	public static void TC01A() throws Exception {
		logger = extent.createTest("TC01A");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC01A");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement title = driver.findElement(getLocator("organizationName", objPro));
		String expected = recdata[1][2];
		verifyText(title, "org-Name", expected);
		logger.log(Status.PASS,
				MarkupHelper.createLabel("User has logged in the Xero application successfully", ExtentColor.GREEN));
		closeBrowser();
	}

	public static void TC01B() throws Exception {

		logger = extent.createTest("TC01B");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC01B");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement error = driver.findElement(getLocator("login.invalidpassword.error", objPro));
		String expected = recdata[1][2];
		
		verifyText(error, "error-message", expected);
		logger.log(Status.PASS, MarkupHelper.createLabel("Error messgae is displayed", ExtentColor.GREEN));
		closeBrowser();
	}

	public static void TC01C() throws Exception {
		logger = extent.createTest("TC01C");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC01C");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement error = driver.findElement(getLocator("login.invalidemail.error", objPro));
		String expected = recdata[1][2];

		verifyText(error, "error-message", expected);
		logger.log(Status.PASS, MarkupHelper.createLabel("Error messgae is displayed", ExtentColor.GREEN));
		closeBrowser();
	}

	public static void TC01D() throws Exception {
		logger = extent.createTest("TC01D");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC01D");
		String email = recdata[1][0];
		WebElement forgotPassword = driver.findElement(getLocator("login.forgotpassword", objPro));
		click(forgotPassword, "Forgot Password Link");
		WebElement usernameemail = driver.findElement(getLocator("forgotpassword.email", objPro));
		usernameemail.clear();
		String useremail = recdata[1][0];
		Text(usernameemail, useremail, "email");
		WebElement sendlink = driver.findElement(getLocator("forgotpassword.sendlink", objPro));
		click(sendlink, "Send Link");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement message = driver.findElement(getLocator("forgotpassword.sendlink.confirmation", objPro));
		String expected = recdata[1][2];
		System.out.println(expected);
		verifyText(message, "confirmation-message", expected);
		logger.log(Status.PASS, MarkupHelper.createLabel("Email is sent to reset the password", ExtentColor.GREEN));
		closeBrowser();
	}

	public static void TC02A() throws Exception {
		logger = extent.createTest("TC02A");
		IntializeDriver("firefox");
		OpenMainBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC02A");
		driver.get("https://www.xero.com/us/");
		WebElement freeTrial = driver.findElement(getLocator("Freetrial.Button", objPro));
		click(freeTrial, "Free Trial Button");
		String fn = recdata[1][0];
		WebElement fName = driver.findElement(getLocator("Freetrial.firstName", objPro));
		Text(fName, fn, "First Name");
		String ln = recdata[1][1];
		WebElement lName = driver.findElement(getLocator("Freetrial.lastName", objPro));
		Text(lName, ln, "Last Name");
		String Email = recdata[1][2];
		WebElement email = driver.findElement(getLocator("Freetrial.Emailaddress", objPro));
		Text(email, Email, "Email address");
		String ph = recdata[1][3];
		WebElement phone = driver.findElement(getLocator("Freetrial.PhoneNumber", objPro));
		Text(phone, ph, "Phone Number");
		WebElement country = driver.findElement(getLocator("Freetrial.Country", objPro));
		dropdownSelection(country, "US", "United States");
		WebElement checkbox = driver.findElement(getLocator("Freetrial.checkbox", objPro));
		click(checkbox, "Checkbox");
		WebElement getStarted = driver.findElement(getLocator("Freetrial.GetStarted", objPro));
		click(getStarted, "Get Started Button");
		WebElement GoToInbox = driver.findElement(getLocator("Freetrial.gotoInbox", objPro));
		click(GoToInbox, "Go To Inbox Page");
		logger.log(Status.PASS, MarkupHelper.createLabel("Email is sent from xero", ExtentColor.GREEN));
		closeBrowser();
	}

	public static void TC02B() throws Exception {
		logger = extent.createTest("TC02B");
		IntializeDriver("firefox");
		OpenMainBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC02B");
		driver.get("https://www.xero.com/us/");
		WebElement freeTrial = driver.findElement(getLocator("Freetrial.Button", objPro));
		click(freeTrial, "Free Trial Button");
		WebElement getStarted = driver.findElement(getLocator("Freetrial.GetStarted", objPro));
		click(getStarted, "Get Started Button");
		WebElement message1 = driver.findElement(getLocator("Freetrial.firstname.error", objPro));
		String expected = recdata[1][0];
		System.out.println(expected);
		verifyText(message1, "message1", expected);
		WebElement message2 = driver.findElement(getLocator("Freetrial.lastname.error", objPro));
		String expected2 = recdata[1][1];
		System.out.println(expected2);
		verifyText(message2, "message2", expected2);
		WebElement message3 = driver.findElement(getLocator("Freetrial.Emailname.error", objPro));
		String expected3 = recdata[1][2];
		System.out.println(expected3);
		verifyText(message3, "message2", expected3);
		WebElement message4 = driver.findElement(getLocator("Freetrial.phone.error", objPro));
		String expected4 = recdata[1][3];
		System.out.println(expected4);
		verifyText(message4, "message2", expected4);
		logger.log(Status.PASS, MarkupHelper.createLabel(
				"Error messages are displayed properly when the mandatory fields are not entered", ExtentColor.GREEN));
		closeBrowser();

	}

	public static void TC02C() throws Exception {
		logger = extent.createTest("TC02C");
		IntializeDriver("firefox");
		OpenMainBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC02C");
		driver.get("https://www.xero.com/us/");
		WebElement freeTrial = driver.findElement(getLocator("Freetrial.Button", objPro));
		click(freeTrial, "Free Trial Button");
		WebElement terms = driver.findElement(getLocator("Freetrial.termsOfUse", objPro));
		click(terms, "TermsOfUse Link");
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				WebDriverWait wait1 = new WebDriverWait(driver, 60);
				WebElement termsofUse = driver.findElement(getLocator("TermsofUse", objPro));
				String expected = recdata[1][0];
				verifyText(termsofUse, "Terms Of Use title", expected);
				logger.log(Status.PASS,
						MarkupHelper.createLabel("Terms of use page is displayed in a new window", ExtentColor.GREEN));
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		Thread.sleep(6000);
		WebElement privacypolicy = driver.findElement(getLocator("Freetrial.privacyNotice", objPro));
		click(privacypolicy, "privacy policy link");
		Thread.sleep(4000);
		String parentWindow1 = driver.getWindowHandle();
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(parentWindow1)) {
				driver.switchTo().window(windowHandle);
				WebDriverWait wait1 = new WebDriverWait(driver, 30);
				WebElement privacyNotice = driver.findElement(getLocator("PrivacyNotice", objPro));
				String expected1 = recdata[1][1];
				verifyText(privacyNotice, "Privacy notice page", expected1);
				logger.log(Status.PASS, MarkupHelper.createLabel("Privacy notice page is displayed in a new window",
						ExtentColor.GREEN));
				driver.close();
				driver.switchTo().window(parentWindow);

			}

		}
		closeBrowser();
	}

	public static void TC02D() throws Exception {
		logger = extent.createTest("TC02D");
		IntializeDriver("firefox");
		OpenMainBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC02D");
		driver.get("https://www.xero.com/us/");
		WebElement freeTrial = driver.findElement(getLocator("Freetrial.Button", objPro));
		click(freeTrial, "Free Trial Button");
		WebElement offerDetails = driver.findElement(getLocator("offerDetails.Link", objPro));
		click(offerDetails, "Offer Details Link");
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				WebDriverWait wait1 = new WebDriverWait(driver, 60);
				WebElement offerDetailsTitle = driver.findElement(getLocator("offerDetails.title", objPro));
				String expected = recdata[1][0];
				verifyText(offerDetailsTitle, "Offer Details title", expected);
				logger.log(Status.PASS,
						MarkupHelper.createLabel("Offer Details page is displayed in a new window", ExtentColor.GREEN));
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
	}

	public static void TC02E() throws Exception {
		logger = extent.createTest("TC02E");
		IntializeDriver("firefox");
		OpenMainBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC02E");
		driver.get("https://www.xero.com/us/");
		WebElement freeTrial = driver.findElement(getLocator("Freetrial.Button", objPro));
		click(freeTrial, "Free Trial Button");
		WebElement accbook = driver.findElement(getLocator("accountant.bookkeeper.link", objPro));
		click(accbook, "Accountant & Bookkeeper Link");
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		WebElement AccBookTitle = driver.findElement(getLocator("accountant.bookkeeper.title", objPro));
		String expected = recdata[1][0];
		verifyText(AccBookTitle, "Lets get started title", expected);
		logger.log(Status.PASS, MarkupHelper.createLabel(
				"Sign Up Page is displayed after clicking on Accountant and BookKeeper link", ExtentColor.GREEN));

		closeBrowser();
	}

	public static void TC03A() throws Exception {
		logger = extent.createTest("TC03A");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC03A");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		WebElement trialAccountTitle = driver
				.findElement(getLocator("xero.login.HomePage.TrialaccountTitle", objPro));
		String expected1 = recdata[1][2];
		verifyText(trialAccountTitle, "You are currently using a trial account - ", expected1);
		boolean ispresent = driver.findElement(getLocator("xero.login.editdashboard", objPro)).isDisplayed();
		if (ispresent) {
			logger.log(Status.PASS, MarkupHelper.createLabel("dashborad page is displayed", ExtentColor.GREEN));
		} else {
			logger.log(Status.FAIL, MarkupHelper.createLabel("dashborad page is NOT displayed", ExtentColor.RED));
		}

		WebElement accounts = driver.findElement(getLocator("xero.login.accounts", objPro));
		click(accounts, "Accounts Tab");

		boolean ispresent1 = driver.findElement(getLocator("xero.login.accounts.BankAccounts", objPro)).isDisplayed();
		boolean ispresent2 = driver.findElement(getLocator("xero.login.accounts.Sales", objPro)).isDisplayed();
		boolean ispresent3 = driver.findElement(getLocator("xero.login.accounts.Purchases", objPro)).isDisplayed();
		boolean ispresent4 = driver.findElement(getLocator("xero.login.accounts.Checks", objPro)).isDisplayed();
		boolean ispresent5 = driver.findElement(getLocator("xero.login.accounts.Inventory", objPro)).isDisplayed();
		boolean ispresent6 = driver.findElement(getLocator("xero.login.accounts.ExpenseClaims", objPro)).isDisplayed();
		boolean ispresent7 = driver.findElement(getLocator("xero.login.accounts.FixedAssets", objPro)).isDisplayed();

		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		if (ispresent1 && ispresent2 && ispresent3 && ispresent4 && ispresent5 && ispresent6 && ispresent7) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel("All the dropdown options in Accounts tab are displayed as expected", ExtentColor.GREEN));
		} else {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel("Dropdown options are NOT displayed in accounts tab as expected", ExtentColor.RED));
		}
		
		
		WebElement reports = driver.findElement(getLocator("xero.login.reports", objPro));
		click(reports, "Reports Tab");
		
		boolean ispresent8 = driver.findElement(getLocator("xero.login.reports.AllReports", objPro)).isDisplayed();
		boolean ispresent9 = driver.findElement(getLocator("xero.login.reports.Budgetmanager", objPro)).isDisplayed();
		boolean ispresent10 = driver.findElement(getLocator("xero.login.reports.AgedPayables", objPro)).isDisplayed();
		boolean ispresent11 = driver.findElement(getLocator("xero.login.reports.AgesRecievables", objPro)).isDisplayed();
		boolean ispresent12 = driver.findElement(getLocator("xero.login.reports.BalanceSheet", objPro)).isDisplayed();
		boolean ispresent13 = driver.findElement(getLocator("xero.login.reports.CashSummary", objPro)).isDisplayed();
		boolean ispresent14 = driver.findElement(getLocator("xero.login.reports.IncomeStatement", objPro)).isDisplayed();
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		if (ispresent8 && ispresent9 && ispresent10 && ispresent11 && ispresent12 && ispresent13 && ispresent14) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel("All the dropdown options in Reports tab are displayed as expected", ExtentColor.GREEN));
		} else {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel("Dropdown options are NOT displayed in reports tab as expected", ExtentColor.RED));
		}
		
		
		WebElement contacts = driver.findElement(getLocator("xero.login.contacts", objPro));
		click(contacts, "Contacts Tab");	
		
		boolean ispresent15 = driver.findElement(getLocator("xero.login.contacts.Allcontacts", objPro)).isDisplayed();
		boolean ispresent16 = driver.findElement(getLocator("xero.login.contacts.customers", objPro)).isDisplayed();
		boolean ispresent17 = driver.findElement(getLocator("xero.login.contacts.suppliers", objPro)).isDisplayed();
		
		WebDriverWait wait4 = new WebDriverWait(driver, 60);
		if (ispresent15 && ispresent16 && ispresent17) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel("All the dropdown options in Contacts tab are displayed as expected", ExtentColor.GREEN));
		} else {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel("Dropdown options are NOT displayed in contacts tab as expected", ExtentColor.RED));
		}
		
		WebElement settings = driver.findElement(getLocator("xero.login.settings", objPro));
		click(settings, "Settings Tab");
		
		boolean ispresent18 = driver.findElement(getLocator("xero.login.settings.GeneralSettings", objPro)).isDisplayed();
		boolean ispresent19 = driver.findElement(getLocator("xero.login.settings.Subscription", objPro)).isDisplayed();
		boolean ispresent20 = driver.findElement(getLocator("xero.login.settings.ChartofAccounts", objPro)).isDisplayed();
		boolean ispresent21 = driver.findElement(getLocator("xero.login.settings.PayrollSettings", objPro)).isDisplayed();
		WebDriverWait wait5 = new WebDriverWait(driver, 60);
		if (ispresent18 && ispresent19 && ispresent20 && ispresent21) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel("All the dropdown options in settings tab are displayed as expected", ExtentColor.GREEN));
		} else {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel("Dropdown options are NOT displayed in settings tab as expected", ExtentColor.RED));
		}
		
		WebElement New = driver.findElement(getLocator("xero.login.new", objPro));
		click(New, "New Tab");
		WebDriverWait wait6 = new WebDriverWait(driver, 60);
		boolean ispresent22 = driver.findElement(getLocator("xero.login.new.invoice", objPro)).isDisplayed();
		boolean ispresent23 = driver.findElement(getLocator("xero.login.new.bill", objPro)).isDisplayed();
		boolean ispresent24 = driver.findElement(getLocator("xero.login.new.contacts", objPro)).isDisplayed();
		boolean ispresent25 = driver.findElement(getLocator("xero.login.new.quote", objPro)).isDisplayed();
		boolean ispresent26 = driver.findElement(getLocator("xero.login.new.purchase", objPro)).isDisplayed();
		boolean ispresent27 = driver.findElement(getLocator("xero.login.new.money", objPro)).isDisplayed();
		boolean ispresent28 = driver.findElement(getLocator("xero.login.new.recieveMoney", objPro)).isDisplayed();
		boolean ispresent29 = driver.findElement(getLocator("xero.login.new.transMoney", objPro)).isDisplayed();
		
		if (ispresent22 && ispresent23 && ispresent24 && ispresent25 && ispresent26 && ispresent27 && ispresent28 && ispresent29) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel("All the dropdown options in settings tab are displayed as expected", ExtentColor.GREEN));
		} else {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel("Dropdown options are NOT displayed in settings tab as expected", ExtentColor.RED));
		}
		WebDriverWait wait7 = new WebDriverWait(driver, 60);
		WebElement Files = driver.findElement(getLocator("xero.login.files", objPro));
		click(Files, "Files Tab");
		WebElement FilesTitle = driver.findElement(getLocator("xero.login.filesTitle", objPro));
		String expected = recdata[1][4];
		verifyText(FilesTitle, "File Page title", expected);
		
		WebDriverWait wait8 = new WebDriverWait(driver, 60);
		WebElement notification = driver.findElement(getLocator("xero.login.notification", objPro));
		click(notification, "Notification Tab");
		driver.switchTo().frame(driver.findElement(getLocator("xero.login.notification.frame", objPro)));
		logger.log(Status.PASS,
				MarkupHelper.createLabel("Notifications tab is opened", ExtentColor.GREEN));
		
		driver.switchTo().defaultContent();
		
		WebElement search = driver.findElement(getLocator("xero.login.search", objPro));
		click(search, "search Icon");
		driver.switchTo().frame(driver.findElement(getLocator("xero.login.search.frame", objPro)));
		logger.log(Status.PASS,
				MarkupHelper.createLabel("Search tab is opened", ExtentColor.GREEN));
		
		driver.switchTo().defaultContent();
		
		WebElement help = driver.findElement(getLocator("xero.login.help", objPro));
		click(help, "Help Icon");
		WebElement helpTitle = driver.findElement(getLocator("xero.help.title", objPro));
		String expected5 = recdata[1][5];
		verifyText(helpTitle, "Help Title", expected5);
		logger.log(Status.PASS,
				MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
		
		closeBrowser();
	}

	public static void TC04A() throws Exception {
		logger = extent.createTest("TC04A");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC04A");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement username = driver.findElement(getLocator("xero.login.username", objPro));
		click(username, "User Name dropdown");
		WebElement logout = driver.findElement(getLocator("xero.logout", objPro));
		click(logout, "Logout Button");
		WebElement WecomeMessage = driver.findElement(getLocator("xero.login.WelcomeMessage", objPro));
		String expected = recdata[1][2];
		verifyText(WecomeMessage, "Welcome to Xero Message", expected);
		logger.log(Status.PASS,
				MarkupHelper.createLabel("Login Page is displayed after clicking on Logout button", ExtentColor.GREEN));
		closeBrowser();
	}

	public static void TC06A() throws Exception {
		logger = extent.createTest("TC06A");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC06A");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement username = driver.findElement(getLocator("xero.login.username", objPro));
		click(username, "User Name dropdown");
		WebElement profile = driver.findElement(getLocator("xero.login.username.profile", objPro));
		click(profile, "Profile Button");
		WebDriverWait wait7 = new WebDriverWait(driver, 60);
		WebElement uploadImage = driver.findElement(getLocator("xero.login.username.profile.uploadImage", objPro));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", uploadImage);
		logger.log(Status.PASS, MarkupHelper.createLabel("Upload Image button is clicked", ExtentColor.GREEN));
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		WebElement popup = driver.findElement(getLocator("profile.uploadImage.popUp", objPro));
		WebElement browsebutton1 = driver.findElement(getLocator("uploadimage.browseButton", objPro));
		browsebutton1.sendKeys("C:\\Vino\\ITU\\eNexus Global\\profile image.JPG");
		logger.log(Status.PASS, MarkupHelper.createLabel("Image is browsed and Added", ExtentColor.GREEN));
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		WebElement uploadButton = driver.findElement(getLocator("uploadimage.uploadButton", objPro));
		click(uploadButton, "Upload Button");
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		logger.log(Status.PASS, MarkupHelper.createLabel("Image is uploaded succesfully", ExtentColor.GREEN));
		closeBrowser();

	}

	public static void TC10() throws Exception {
		logger = extent.createTest("TC10");
		IntializeDriver("firefox");
		OpenBrowser();
		String objectRepositoryPath = "src/test/resources/ObjectRepository.properties";
		Properties objPro = accessPropertyFile(objectRepositoryPath);
		String testDataPath = "src/test/resources/TestdataExceutionScripts.xls";
		String[][] recdata = ReusableMethods.readSheet(testDataPath, "TC10");
		String email = recdata[1][0];
		WebElement emailAdd = driver.findElement(getLocator("login.email", objPro));
		Text(emailAdd, email, "EmailAddress");
		String password = recdata[1][1];
		WebElement pwd = driver.findElement(getLocator("login.password", objPro));
		Text(pwd, password, "Password");
		WebElement login = driver.findElement(getLocator("login", objPro));
		click(login, "Login Button");
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		WebElement accounts = driver.findElement(getLocator("xero.login.accounts", objPro));
		click(accounts, "Accounts Tab");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement purchases = driver.findElement(getLocator("xero.login.accounts.Purchases", objPro));
		click(purchases, "Purchases dropdown");

	}
}

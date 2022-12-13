package com.tutorial.demo.pages;

import com.tutorial.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccount extends Utility {

   @FindBy(xpath="//span[contains(text(),'My Account')]")
   WebElement myAccount;
    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    @FindBy(xpath="//h1[contains(text(),'Register Account')]")
    WebElement verifyRegister;

    public String getVerifyRegister() {
        return getTextFromElement(verifyRegister);

    }

    @FindBy(xpath="//h2[contains(text(),'Returning Customer')]")
    WebElement verifyReturning;

    public String getVerifyReturning() {
        return getTextFromElement(verifyReturning);

    }

    @FindBy(id="input-firstname")
    WebElement firstName;

    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    @FindBy(id="input-lastname")
    WebElement lastName;

    public void enterLastName(String lastname) {
        sendTextToElement(lastName, lastname);
    }

    @FindBy(id="input-email")
    WebElement enterEmail;

    public void enterEmailAdd(String email) {
        sendTextToElement(enterEmail, email);
    }

    @FindBy(id="input-telephone")
    WebElement enterPhone;
    public void enterPhone(String phone) {
        sendTextToElement(enterPhone, phone);
    }

    @FindBy(id="input-password")
    WebElement enterPass;

    public void enterPassword(String phone) {
        sendTextToElement(enterPass, phone);
    }

    @FindBy(id="input-confirm")
    WebElement confirmPass;
    public void enterConfirmPass(String phone) {
        sendTextToElement(confirmPass, phone);
    }

    @FindBy(xpath="//input[@name='newsletter']")
    WebElement newsLetter;
    public void clickYesonNewsLetter() {
        clickOnElement(newsLetter);
    }

    @FindBy(xpath="//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;
    public void clickOnPrivacy() {
        clickOnElement(privacyPolicy);
    }

    @FindBy(xpath="//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickOnContinue;


    public void clickFinalContinue() {
        clickOnElement(clickOnContinue);
    }

    @FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement verifyMessage;

    public String getVerifyMessage() {
        return getTextFromElement(verifyMessage);

    }

    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement continueButton;

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    @FindBy(xpath="//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
    }

    @FindBy(xpath="//h1[contains(text(),'Account Logout')]")
    WebElement verifyLogout;
    public String getVerifyLogout() {
        return getTextFromElement(verifyLogout);

    }

    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement continueButtonTab;

    public void clickOnContinueTab() {
        clickOnElement(continueButton);
    }

    @FindBy(xpath="//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;

    public void clickOnLogin() {
        clickOnElement(loginButton);

    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

}

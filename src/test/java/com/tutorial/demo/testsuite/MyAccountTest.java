package com.tutorial.demo.testsuite;

import com.tutorial.demo.pages.MyAccount;
import com.tutorial.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    MyAccount myAccount;



    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        myAccount=new MyAccount();


    }




    //MyAccount
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test(groups = {"regression", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");

        myAccount.enterFirstName("Tushar");
        myAccount.enterLastName("Vibhakar");
        myAccount.enterEmailAdd("tv@gmail.com");
        myAccount.enterPhone("Indra112");
        myAccount.enterPassword("012345678");
        myAccount.enterConfirmPass("012345678");

        myAccount.clickYesonNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();

        Assert.assertEquals(myAccount.getVerifyMessage(), "Your Account Has Been Created!", "Error Message not displayed");
        myAccount.clickOnContinueButton();

        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }

     @Test(groups = {"regression", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Login");

        myAccount.enterEmailAdd("tv@gmail.com");
        myAccount.enterPassword("Indra112");


        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        //Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }


}

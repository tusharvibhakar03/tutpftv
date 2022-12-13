package com.tutorial.demo.testsuite;

import com.tutorial.demo.pages.Desktops;
import com.tutorial.demo.pages.HomePage;
import com.tutorial.demo.pages.LaptopsAndNotebooks;
import com.tutorial.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {
    HomePage homePage;
    Desktops desktops;
    LaptopsAndNotebooks laptopsAndNotebooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

   homePage = new HomePage();
   desktops = new Desktops();
    laptopsAndNotebooks = new LaptopsAndNotebooks();


           }

    //****************************************DesktopTest******************************************************
    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.verifyZtoAFromDropDroDown();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully () throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();
        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.SortByNameZtoAFromDropdown();
        desktops.clickOnHPlp3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktops.getVerifyTextHp(), expectedMessage, "Error Message not displayed");
        desktops.selectDeliveryDate();
        //desktops.changeQuantity("1");
        desktops.clickOnAdToCart();
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(desktops.getVerifyShoppingCart(), expectedMessage, "Error Message not displayed");
        desktops.clickOnShoppingCart();
        Thread.sleep(3000);
        //Assert.assertEquals(desktops.getVerifyShoppingCart(), "Shopping Cart", "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyProductName(), "HP LP3065", "Error Message not displayed");
        //  String expectedMessage4 = "2022-11-30";
        // Assert.assertEquals(desktops.getVerifyDeliveryDate(), expectedMessage, "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyModel(), "Product Code: Product 21", "Error Message not displayed");
        Thread.sleep(2000);
        //Assert.assertEquals(desktops.getVerifyTotal(), "£74.73", "Error Message not displayed");

    }



}

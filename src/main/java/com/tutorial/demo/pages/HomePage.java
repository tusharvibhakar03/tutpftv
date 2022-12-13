package com.tutorial.demo.pages;

import com.tutorial.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @FindBy(linkText="Desktops")
    WebElement desktopLink;
    @FindBy(xpath="//h2[contains(text(),'Desktops')]")
    WebElement verifyText;
    @FindBy(linkText="Laptops & Notebooks")
    WebElement laptopNotebookLink;

    @FindBy(xpath="//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement verifyText1;
    @FindBy(linkText="Components")
    WebElement componentsLink;

   @FindBy(xpath="//h2[contains(text(),'Components')]")
    WebElement verifyText2;

    public void clickOnDesktopLink() {clickOnElement(desktopLink);
    }

    public String getVerifyText() {
        return getTextFromElement(verifyText);
    }

    public void clickOnLaptopNotebooksLink() {
        clickOnElement(laptopNotebookLink);
    }

    public String getVerifyText1() {
        return getTextFromElement(verifyText1);
    }

    public void clickOnComponentsLink() {
        clickOnElement(componentsLink);
    }

    public String getVerifyText2() {
        return getTextFromElement(verifyText2);
    }
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

}

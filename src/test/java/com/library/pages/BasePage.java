package com.library.pages;


import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboard;
    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersModule;
    @FindBy(xpath = "//span[.='Books']")
    public WebElement booksModule;

    public String getTitle() {
        return Driver.getDriver().getTitle();
    }

    public String getURL() {
        return Driver.getDriver().getCurrentUrl();
    }


}

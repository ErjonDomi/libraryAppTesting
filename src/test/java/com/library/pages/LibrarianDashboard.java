package com.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LibrarianDashboard extends BasePage {


    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(xpath = "//ul[@id='menu_item']//a")
    public List<WebElement> modules;

    public LibrarianUsersPage clickUserModule() {
        usersModule.click();
        return new LibrarianUsersPage();
    }
    public LibrarianBooksPage clickBooksModule() {
        usersModule.click();
        return new LibrarianBooksPage();
    }


}

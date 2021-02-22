package com.library.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "inputEmail")
    public WebElement username;
    @FindBy(id = "inputPassword")
    public WebElement password;
    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    public LibrarianDashboard doLoginAsLibrarian(String un, String pwd) {

        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
        return new LibrarianDashboard();
    }
    public StudentDashboard doLoginAsStudent(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
        return new StudentDashboard();
    }


}

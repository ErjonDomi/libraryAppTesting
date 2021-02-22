package com.library.step_definitions;

import com.library.pages.LibrarianDashboard;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinition {

    LoginPage loginPage=new LoginPage();
    LibrarianDashboard librarianDashboard=new LibrarianDashboard();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("Page title should be {string}")
    public void page_title_should_be(String expected) {
       Assert.assertEquals(expected,loginPage.getTitle(),"Login Title is not matching!");
    }

    @When("I enter username {string}")
    public void i_enter_username(String string) {
       loginPage.username.sendKeys(string);
    }

    @When("I enter password {string}")
    public void i_enter_password(String string) {
     loginPage.password.sendKeys(string);
    }

    @When("I click sign in button")
    public void i_click_sign_in_button() {
      loginPage.loginButton.click();
    }

    @When("there should be {int} user")
    public void there_should_be_user(Integer int1) {
        String expected = String.valueOf(int1);
        String actual =  librarianDashboard.userCount.getText();
        Assert.assertEquals(actual,expected);
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected = "dashboard";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = librarianDashboard.getURL();
        Assert.assertTrue(actual.contains(expected));
    }

    @Then("books should be displayed")
    public void books_should_be_displayed() {
        String expected = "books";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = librarianDashboard.getURL();
        Assert.assertTrue(actual.contains(expected));
    }

    @When("I enter username {string} and {string}")
    public void i_enter_username_and(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }
}

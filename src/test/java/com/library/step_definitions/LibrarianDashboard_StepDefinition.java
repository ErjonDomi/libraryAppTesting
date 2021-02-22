package com.library.step_definitions;

import com.library.pages.LibrarianDashboard;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Map;

public class LibrarianDashboard_StepDefinition {

    LoginPage loginPage = new LoginPage();
    LibrarianDashboard librarianDashboard;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application() {
        String username = ConfigurationReader.getProperty("lib16");
        String password = ConfigurationReader.getProperty("lib16pass");
        librarianDashboard = loginPage.doLoginAsLibrarian(username, password);


    }

    @Given("user is on Dashboard page")
    public void user_is_on_dashboard_page() {
        BrowserUtils.wait(5);
        String expectedTitle = "Library";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue( librarianDashboard.getTitle().contains(expectedTitle));

    }

    @When("user gets the URL of the page")
    public void user_gets_the_url_of_the_page() {
        System.out.println("URL of the page is : "+librarianDashboard.getURL());
    }

    @Then("page URL should should be {string}")
    public void page_url_should_should_be(String expectedUrl) {

        Assert.assertEquals(expectedUrl, librarianDashboard.getURL());
    }


    @Then("the user should see following modules")
    public void the_user_should_see_following_modules(List<String> list) {
        Assert.assertEquals(BrowserUtils.getElementsText(librarianDashboard.modules), list);
    }


}

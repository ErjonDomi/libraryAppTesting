package com.library.step_definitions;

import com.library.pages.LibrarianDashboard;
import com.library.pages.LibrarianUsersPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LibrarianUsersModule_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    LibrarianDashboard librarianDashboard = new LibrarianDashboard();
    LibrarianUsersPage librarianUsersPage =new LibrarianUsersPage();


    @Given("the librarian is on the home page")
    public void the_librarian_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.doLoginAsLibrarian(ConfigurationReader.getProperty("lib16"), ConfigurationReader.getProperty("lib16pass"));


    }



    @Given("the librarian is on the users page")
    public void theLibrarianIsOnTheUsersPage() {
        librarianDashboard.clickUserModule();
        Assert.assertEquals(librarianUsersPage.getTitle(), "Library");

    }

    @Then("page URL should be {string}")
    public void page_url_should_be(String expectedURL) {
        Assert.assertEquals(expectedURL, librarianUsersPage.getURL());
    }

    @When("user  click add user")
    public void user_click_add_user() {
        librarianUsersPage.addUser.click();
    }

    @When("user enter Full Name {string}")
    public void user_enter_full_name(String fullName) {
        librarianUsersPage.fullName.sendKeys(fullName);
    }

    @When("user enter password {string}")
    public void user_enter_password(String password) {
        librarianUsersPage.password.sendKeys(password);
    }

    @When("user enter User Group {string}")
    public void user_enter_user_group(String userGroup) {
        Select userGroups = new Select(librarianUsersPage.userGroup);
        userGroups.selectByVisibleText(userGroup);
    }

    @When("user enter Start Date {string}")
    public void user_enter_start_date(String startDate) {
        librarianUsersPage.startDate.sendKeys(startDate);
    }

    @When("user enter Email {string}")
    public void user_enter_email(String email) {
        librarianUsersPage.email.sendKeys(email);
    }

    @When("user enter Status {string}")
    public void user_enter_status(String status) {
        Select select = new Select(librarianUsersPage.status);
        select.selectByVisibleText(status);
    }

    @When("user enter End Date {string}")
    public void user_enter_end_date(String endDate) {
        librarianUsersPage.endDate.sendKeys(endDate);
    }

    @Then("user click save changes")
    public void user_click_save_changes() {
        librarianUsersPage.saveChanges.click();
    }

    @When("user enter Full Name {string} and password {string} and User Group {string} and Start Date {string} and  Email {string} and Status {string} and End Date {string}")
    public void user_enter_full_name_and_password_and_user_group_and_start_date_and_email_and_status_and_end_date(String fullName, String password, String userGroup, String startDate, String email, String status, String endDate) {
        librarianUsersPage.fullName.sendKeys(fullName);
        librarianUsersPage.password.sendKeys(password);
        Select userGroups = new Select(librarianUsersPage.userGroup);
        userGroups.selectByVisibleText(userGroup);
        librarianUsersPage.startDate.sendKeys(startDate+ Keys.ENTER);
        librarianUsersPage.email.sendKeys(email);
        Select select = new Select(librarianUsersPage.status);
        select.selectByVisibleText(status);
        librarianUsersPage.endDate.sendKeys(endDate+ Keys.ENTER);
        BrowserUtils.wait(2);
    }

    @Then("user click close")
    public void user_click_close() {
        librarianUsersPage.closeButton.click();
    }

    @When("librarian click edit user")
    public void librarian_click_edit_user() {
        librarianUsersPage.editUserClick("3244");
    }

    @When("librarian changes the  Full Name {string} and password {string} and User Group {string} and Start Date {string} and  Email {string} and Status {string} and End Date {string}")
    public void librarian_changes_the_full_name_and_password_and_user_group_and_start_date_and_email_and_status_and_end_date(String fullName, String password, String userGroup, String startDate, String email, String status, String endDate) {
        librarianUsersPage.fullName.clear();
        librarianUsersPage.fullName.sendKeys(fullName);

        librarianUsersPage.password.clear();
        librarianUsersPage.password.sendKeys(password);

        Select userGroups = new Select(librarianUsersPage.userGroup);
        userGroups.selectByVisibleText(userGroup);

        librarianUsersPage.startDate.sendKeys(startDate);
        librarianUsersPage.email.sendKeys(email);
        Select select = new Select(librarianUsersPage.status);
        select.selectByVisibleText(status);
        librarianUsersPage.endDate.sendKeys(endDate);
    }

    @Then("librarian saves the changes")
    public void librarian_saves_the_changes() {
        librarianUsersPage.saveChanges.click();
    }

    @When("librarian goes to  shows record")
    public void librarian_goes_to_shows_record() {
        librarianUsersPage.showRecords.click();

    }

    @Then("librarian check the default record is {string}")
    public void librarian_check_the_default_record_is(String expected) {
        Select select = new Select(librarianUsersPage.showRecords);
        Assert.assertEquals(expected, select.getFirstSelectedOption());
    }

    @Then("librarian check the selected options are {string}")
    public void librarian_check_the_selected_options_are(List<String> list) {
        Select select = new Select(librarianUsersPage.showRecords);
        List<WebElement> selectedOption = select.getOptions();

        Assert.assertEquals(BrowserUtils.getElementsText(selectedOption), list);

    }


}

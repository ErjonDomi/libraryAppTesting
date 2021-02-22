package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibrarianUsersPage extends BasePage{

    @FindBy(className = "btn btn-lg btn-outline btn-primary btn-sm")
    public WebElement addUser;
    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullName;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(id = "user_group_id")
    public WebElement userGroup;
    @FindBy(xpath = "//input[@name='start_date']")
    public WebElement startDate;
    @FindBy(id = "address")
    public WebElement address;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(id = "status")
    public WebElement status;
    @FindBy(xpath = "//input[@name='end_date']")
    public WebElement endDate;
    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement closeButton;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChanges;
    @FindBy (name = "tbl_users_length")
    public WebElement showRecords;

    public void editUserClick(String userID){
        Driver.getDriver().findElement(By.xpath("//tbody//a[@onclick='Users.edit_user("+userID+")']"));
    }

}

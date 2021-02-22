package com.library.step_definitions;

import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AppHooks {

@Before
public void setupMethod(){
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
}

    @After
    public void tearDown(Scenario scenario){
        //if my scenario failed
        // go and take screen shot

        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }


        Driver.closeDriver();

    }
}

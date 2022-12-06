package com.krafttech.stept_definitions;

import com.krafttech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before // before u seçerken cucumber.java dan gelmesine dikkat edelim! // // her testten önce çalışır
    public void setUP(){
        System.out.println("\tThis is coming from Before Method");
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After  // after i seçerken cucumber.java dan gelmesine dikkat edelim! // // her testten sonra çalışır
    public void tearDown(Scenario scenario){ // ekran görüntüsü almak için
        System.out.println("\tThis is coming from After Method");


        if(scenario.isFailed()){  // bu if methodu screenShot için.
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }


        Driver.closeDriver();
    }



    @Before("@db")  // yandaki tag la buna sahip tag ı olanlarda çalış dedik
    public void setUpDb(){
        System.out.println("\t Connecting DB");
    }

    @After("@db") // yandaki tag la buna sahip tag ı olanlarda çalış dedik
    public void tearDownDB(){
        System.out.println("\t Disconnecting DB");
    }


}

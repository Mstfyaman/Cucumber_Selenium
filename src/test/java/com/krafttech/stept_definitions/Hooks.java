package com.krafttech.stept_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before // before u seçerken cucumber.java dan gelmesine dikkat edelim!
    public void setUP(){
        System.out.println("\tThis is coming from Before Method");
    }

    @After  // after i seçerken cucumber.java dan gelmesine dikkat edelim!
    public void tearDown(){
        System.out.println("\tThis is coming from After Method");
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

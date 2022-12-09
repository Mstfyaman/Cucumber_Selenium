package com.krafttech.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/failed-html-reports.html" // html raporu oluşturması için
        },

        features = "@target/rerun.txt",   // targetin altındaki rerundan verileri alacağımız için böyle yaptık
        glue = "com/krafttech/stept_definitions"
                )
public class FailedTestRunner {
}

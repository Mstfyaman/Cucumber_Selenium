package com.krafttech.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(             // runner class ı ve features arasındaki bağlantıyı kurar

        plugin = {"json:target/cucumber.json", // burası rapor almamızı sağlamak için
        "html:target/default-html-reports.html", // bu satır html raporu verir. ancak bende version probleminden dolayı çalışmadı. asıl kullanılan üstteki rapor yöntemi
                "rerun:target/rerun.txt"}, // bu satır failed olan bir testi bize target altında rerun.txt oluşturarak bildirir.

        features = "src/test/resources/features",    // features packagesinin path ini aldık.
        glue = "com/krafttech/stept_definitions", // runner class ile step_definitions arasındaki bağlantığı kuruyoruz
                 // step_definitions package sinin path ini aldık
        dryRun = false,
                 // tanımlanmamış step i görmek istediğimizde testi çalıştırmaz sadece tanımsız step i verir.
                 // kullanılacağı zaman true alma gerekir, tanımlanmamış step yoksa testi çalıştırmaz
        tags = "@parallel"
                // feature de oluşturduğumuz senaryoya tag oluşturup burda o tag çağırabiliyoruz ve sadece o çalışır.
                // biz aynı tag ı bir kaç senaryonun üzerine koyarsak burda o tag ı çağırır ve hepsini çalıştırırız
                // "@Mike and @smoke" dersek her ikiside olanı, "@Mike or @smoke" desek senaryoda hangisini bulursa onu çalıştırır
                //  "@Mike and not @SDET" haric tutmak istersekde not kullanırız
                )

public class CukesRunner {
}

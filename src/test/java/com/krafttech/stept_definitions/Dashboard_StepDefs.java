package com.krafttech.stept_definitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Dashboard_StepDefs {

    LoginPages loginPages = new LoginPages();
    DashboardPage dashboardPage = new DashboardPage();

    @Then("The user name should be {string}")
    public void the_user_name_should_be(String expected) {
        String actualName = dashboardPage.getUserName();
        System.out.println("actualName = " + actualName);
        System.out.println("expected = " + expected);
        Assert.assertEquals("Verify that name is match",expected,actualName);
    }


    @When("The user navigates to {string} menu")
    public void the_user_navigates_to_menu( String tabName) {
        dashboardPage.naviagateToTab2(tabName);  // bunu basepage den çektik

    }

    @Then("The user should be able to see home name as {string}")
    public void the_user_should_be_able_to_see_home_name_as(String exceptedHomeName) {
        String actualHomeName = dashboardPage.getHomeName(exceptedHomeName);
        Assert.assertEquals("Verify that home name is displayed", exceptedHomeName,actualHomeName);
    }

}



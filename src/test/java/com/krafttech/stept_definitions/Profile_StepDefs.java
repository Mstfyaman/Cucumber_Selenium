package com.krafttech.stept_definitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPages;
import com.krafttech.pages.ProfilePage;
import com.krafttech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.est.LimitedSource;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Profile_StepDefs {


    DashboardPage dashboardPage = new DashboardPage();
    ProfilePage profilePage = new ProfilePage();


    @When("User should go to My profile")
    public void user_should_go_to_my_profile() {
       profilePage.myProfile.click();
    }

    @When("User should navigate to {string}")
    public void user_should_navigate_to(String tabName) {
        profilePage.profileTabs(tabName);
    }

    @When("User should input the information boxes")
    public void user_should_input_the_information_boxes() {

       // profilePage.fullName.sendKeys("Mustafa");
        profilePage.about.sendKeys("This is great work");
      //  profilePage.company.sendKeys("Kraft Technologie");

        BrowserUtils.waitForVisibility(profilePage.slider,5);
        BrowserUtils.dragAndDropBy(profilePage.slider,150,0);  // yatay eksen

      //  Select select = new Select(profilePage.job);
      //  select.selectByVisibleText("QA Engineer");

        profilePage.website.sendKeys("krafttechnologie.com");
        profilePage.location.sendKeys("Ankara");
       // profilePage.skills.sendKeys("Selenium, TestNG, Java, Cucumber");

        BrowserUtils.clickWithJS(profilePage.save);

    }

    @Then("User should verify the profile updated message")
    public void user_should_verify_the_profile_updated_message() {

        String actualMessage = profilePage.profileUpdate.getText();
        String exceptedMessage = "Profile Updated";
        Assert.assertEquals(exceptedMessage,actualMessage);
    }



    @Then("User should see he profile options")
    public void user_should_see_he_profile_options(List<String> Options) {

        List<String> actualOptions = BrowserUtils.getElementsText(profilePage.profileOptions);
        System.out.println("actualOptions.size() = " + actualOptions.size());
        // bunu bizim profile.feature ye belirlediğim listlerden alıyor. = 4

        System.out.println("actualOptions = " + actualOptions);
        System.out.println("profileOptions = " + Options);
        Assert.assertEquals(Options,actualOptions);

    }




}

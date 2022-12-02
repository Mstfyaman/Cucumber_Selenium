package com.krafttech.stept_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuStepDefs {

    @When("At first get the text of dashboard")
    public void at_first_get_the_text_of_dashboard() {


    }
    @Then(" go to Developers menu and get the text of Developer")
    public void then_go_to_developers_menu_and_get_the_text_of_developer() {
        System.out.println("");
    }

        @When("Get the text of dashboard")
        public void get_the_text_of_dashboard() {
            System.out.println("");
        }

        @Then("go to Edit Profile menu and get the text of Edit User Profile")
        public void then_go_to_edit_profile_menu_and_get_the_text_of_edit_user_profile() {
            System.out.println("of dashboard");
        }


        @Then("go to My Profile menu and get the text of User Profile")
        public void then_go_to_my_profile_menu_and_get_the_text_of_user_profile() {
            System.out.println("my profile");
        }


    @Then("go to Developers menu and get the text of Developer")
    public void goToDevelopersMenuAndGetTheTextOfDeveloper() {
    }
}

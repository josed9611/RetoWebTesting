package com.exito.automation.stepdefinitions;



import com.exito.automation.exceptions.ExceptionError;
import com.exito.automation.questions.Prices;
import com.exito.automation.questions.Products;
import com.exito.automation.questions.Quantities;
import com.exito.automation.tasks.SelectCategory;
import com.exito.automation.utils.ReadFiles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class BuyProductsStepDefinitions {
    @Given("user buys {int} products of {string}")
    public void userBuys(int quantity, String category) {
        theActorInTheSpotlight().attemptsTo(SelectCategory.inExito(ReadFiles.readProduct(category), quantity));
    }

    @When("sees the cart")
    public void seesTheCart() {
        theActorInTheSpotlight().should(seeThat(Products.SelectinTheCart()).orComplainWith(ExceptionError.class));
    }

    @Then("should see the price of the products")
    public void shouldSeeThePriceOfTheProducts() {
        theActorInTheSpotlight().should(seeThat(Prices.SelectinTheCart()).orComplainWith(ExceptionError.class));
    }

    @And("should see the quantities of the products")
    public void shouldSeeTheQuantities() {
        theActorInTheSpotlight().should(seeThat(Quantities.SelectInTheCart()).orComplainWith(ExceptionError.class));
    }


}

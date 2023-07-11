package com.exito.automation.tasks;

import com.exito.automation.interactions.RandomQuantities;
import com.exito.automation.interactions.Wait;
import com.exito.automation.models.DataInjection;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;
import java.util.List;

import static com.exito.automation.userinterfaces.HomePageUI.*;

@AllArgsConstructor
public class BuyProducts implements Task {
    private static final List<String> productsPrices = new ArrayList<>();
    private static final List<String> productsList = new ArrayList<>();
    private static final List<Integer> productsQuantities = new ArrayList<>();

    public static BuyProducts onExito() {
        return Tasks.instrumented(BuyProducts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.seconds(1),
                Click.on(BTN_ADD_TO_CART));

        productsPrices.add(LBL_PRODUCT_PRICE.resolveFor(actor).getText());
        productsList.add(LBL_PRODUCT_NAME.resolveFor(actor).getText());
        actor.attemptsTo(
                RandomQuantities.ofProduct());

        productsQuantities.add(actor.recall("QUANTITIES"));
        actor.remember("PRODUCTS_LIST", productsList);
        actor.remember("PRODUCTS_PRICES", productsPrices);
        actor.remember("PRODUCTS_QUANTITIES", productsQuantities);
    }
}

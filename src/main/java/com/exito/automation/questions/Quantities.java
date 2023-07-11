package com.exito.automation.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.exito.automation.userinterfaces.ShoppingCartUI.LBL_SHOPPINGCART_QUANTITY;

public class Quantities implements Question<Boolean> {
    public static Quantities SelectInTheCart() {
        return new Quantities();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Integer> productsQuantities = actor.recall("PRODUCTS_QUANTITIES");
        List<WebElementFacade> productsQuantitiesInCart = LBL_SHOPPINGCART_QUANTITY.resolveAllFor(actor);
        //int totalQuantity = 0;
        for (int i = 0; i < productsQuantities.size(); i++) {
            // totalQuantity+=productsQuantities.get(i);
            // System.out.println(totalQuantity);
            actor.attemptsTo(
                    Ensure.that(productsQuantities.get(i)).isEqualTo(Integer.parseInt(productsQuantitiesInCart.get(i).getText()))
            );
        }
        return true;
    }
}

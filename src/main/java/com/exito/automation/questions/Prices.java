package com.exito.automation.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.ArrayList;
import java.util.List;

import static com.exito.automation.userinterfaces.ShoppingCartUI.LBL_SHOPPINGCART_PRODUCT_PRICE;

@AllArgsConstructor
public class Prices implements Question<Boolean> {

    public static Prices SelectinTheCart() {
        return new Prices();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Integer> productsQuantities = actor.recall("PRODUCTS_QUANTITIES");
        List<String> productsPricesList = actor.recall("PRODUCTS_PRICES");
        List<Integer> partes = new ArrayList<>();
        int counter = 0;
        List<WebElementFacade> productsPricesListInCart = LBL_SHOPPINGCART_PRODUCT_PRICE .resolveAllFor(actor);

        for (int i = 1; i < productsPricesListInCart.size() - 1; i = i + 2) {
            actor.attemptsTo(
                    Ensure.that(Integer.parseInt(productsPricesList.get(counter).replace("$", "")
                                    .replace(" ", "").replace(".", ""))
                                    * productsQuantities.get(counter))
                                    .
                            isEqualTo(Integer.valueOf(
                                    productsPricesListInCart.get(i).getText().replace("$", "")
                                            .replace(" ", "").replace(".", ""))));

            counter++;
        }

        return true;
    }


}

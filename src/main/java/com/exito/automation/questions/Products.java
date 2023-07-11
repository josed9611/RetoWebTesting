package com.exito.automation.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.exito.automation.userinterfaces.ShoppingCartUI.LBL_SHOPPINGCART_PRODUCT_NAME;

@AllArgsConstructor
public class Products implements Question<Boolean> {
    public static Products SelectinTheCart() {
        return new Products();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> productsList = actor.recall("PRODUCTS_LIST");
        List<WebElementFacade> productsListInCart = LBL_SHOPPINGCART_PRODUCT_NAME.resolveAllFor(actor);
        for (int i = 0; i < productsList.size(); i++) {
            actor.attemptsTo(
                    Ensure.that(productsList.get(i)).isEqualTo(productsListInCart.get(i).getText())
            );
        }

        return true;
    }


}

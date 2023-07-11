package com.exito.automation.tasks;

import com.exito.automation.models.DataInjection;
import com.exito.automation.models.Model;
import com.exito.automation.userinterfaces.HomePageUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.exito.automation.userinterfaces.HomePageUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


@AllArgsConstructor
public class SelectCategory implements Task {

    private Model model;
    private int quantity;

    public static SelectCategory inExito(Model model, int quantity) {
        return Tasks.instrumented(SelectCategory.class, model, quantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= quantity; i++) {
            actor.attemptsTo(Click.on(BTN_SIDE_MENU),
                    Click.on(BTN_CATEGORY.of(model.getCategory())),
                    WaitUntil.the(BTN_SUBCATEGORY.of(model.getSubcategory()), isVisible()).forNoMoreThan(3).seconds(),
                    Click.on(BTN_SUBCATEGORY.of(model.getSubcategory())),
                    Click.on(LST_PRODUCTS.of(Integer.toString(i))));
            actor.attemptsTo(
                    BuyProducts.onExito());
        }
        actor.attemptsTo(Click.on(BTN_CART));
        actor.remember("PRODUCTS_ADDED", quantity);
        actor.attemptsTo(Click.on(TXT_EMAIL));
        actor.attemptsTo(Enter.keyValues(DataInjection.getEmail()).into(TXT_EMAIL));
        actor.attemptsTo(Click.on(BTN_CONFIRMATION));
    }
}

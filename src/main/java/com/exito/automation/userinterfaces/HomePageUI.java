package com.exito.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUI {

    public static final Target BTN_SIDE_MENU = Target.the("Side menu button")
            .located(By.xpath("//div[@class='exito-category-menu-3-x-button']/button"));

    public static final Target BTN_CATEGORY = Target.the("Category selection button")
            .locatedBy("//p[contains(text(), '{0}')]");

    public static final Target BTN_SUBCATEGORY = Target.the("subcategory selection button")
            .locatedBy("//p[contains(text(),'{0}')]");

    public static final Target LST_PRODUCTS = Target.the("products list")
            .locatedBy("(//div[@class='vtex-search-result-3-x-galleryItem vtex-search-result-3-x-galleryItem--normal vtex-search-result-3-x-galleryItem--default pa4'])[{0}]");

    public static final Target LBL_PRODUCT_NAME = Target.the("Label product name")
            .located(By.xpath("//span[@class='vtex-store-components-3-x-productBrand ']"));

    public static final Target LBL_PRODUCT_PRICE = Target.the("Label product price")
            .located(By.xpath("//div[@class='exito-vtex-components-4-x-PricePDP']/span[@class='exito-vtex-components-4-x-currencyContainer']"));

    public static final Target BTN_ADD_TO_CART = Target.the("Add to cart button")
            .located(By.xpath("//span[contains(text(),'Agregar')]"));

    public static final Target BTN_ADD_QUANTITY = Target.the("Products quantity button")
            .located(By.xpath("//span[@class='product-details-exito-vtex-components-buy-button-manager-more']"));

    public static final Target LBL_QUANTITY = Target.the("Label quantity in product")
            .located(By.xpath("//div[@class='exito-vtex-components-4-x-stepperContainerQty']"));
    public static final Target BTN_CART = Target.the("Go to cart button")
            .located(By.xpath("//div[@class='exito-header-3-x-minicartContainer ']"));

    public static final Target TXT_EMAIL = Target.the("Input email")
            .located(By.xpath("//div[@class='exito-checkout-io-0-x-preLoginInputText']"));

    public static final Target BTN_CONFIRMATION = Target.the("Button Confirmation")
            .located(By.xpath("//button[@class='exito-checkout-io-0-x-preLoginBlockButton']"));


}

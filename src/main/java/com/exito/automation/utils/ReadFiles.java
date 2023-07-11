package com.exito.automation.utils;

import com.exito.automation.models.Model;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFiles {

    public static final String EDGE = "Edge";
    public static final String CHROME = "Chrome";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFiles.class);
    private static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();
    public static final String DEFAULT_BROWSER = CONF.getProperty("config.browser.default");
    private static final String CONFIG_PRODUCTS = "categories.";

    public static Model readProduct(String category) {

        LOGGER.info("Se crea el objeto MODELO");

        return new Model(
                CONF.getProperty(CONFIG_PRODUCTS + category + ".productCategory"),
                CONF.getProperty(CONFIG_PRODUCTS + category + ".productSubcategory")
        );

    }
}

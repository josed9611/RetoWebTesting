package com.exito.automation.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {

    Faker faker = new Faker(new Locale("en_US"));
    private static String email;

    public static String getEmail() {
        return email;
    }

    public DataInjection(String email) {
        DataInjection.email = faker.internet().emailAddress();
    }
}

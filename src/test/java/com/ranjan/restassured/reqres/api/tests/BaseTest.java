package com.ranjan.restassured.reqres.api.tests;

import io.restassured.*;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        // Relax SSL validation only when required in some network
        if (Boolean.parseBoolean(System.getProperty("relax.ssl", "true"))) {
            RestAssured.useRelaxedHTTPSValidation();
        }

        RestAssured.baseURI = "https://reqres.in";
    }

}
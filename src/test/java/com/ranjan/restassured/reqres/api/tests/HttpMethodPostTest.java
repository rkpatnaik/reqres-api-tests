package com.ranjan.restassured.reqres.api.tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HttpMethodPostTest extends BaseTest {

    @Test
    public void createUser_shouldReturn201() {
        String requestBody = "{\"name\":\"morpheus\", \"job\":\"dream king\"}";

        given().
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
            contentType("application/json").
            body(requestBody).
        when().
            post("https://reqres.in/api/users").
        then().
            statusCode(201).
            body("name", equalTo("morpheus")).
            body("job", equalTo("dream king")).
            body("id", notNullValue()).
            body("createdAt", notNullValue());
    }

    @Test
    public void createUser_withValidPayload_shouldReturn201AndGenerateId() {
        String requestBody = "{\"name\":\"neo\", \"job\":\"the one\"}";

        given().
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
            contentType("application/json").
            body(requestBody).
        when().
            post("/api/users").
        then().
            statusCode(201).
            body("name", equalTo("neo")).
            body("job", equalTo("the one")).
            body("id", notNullValue());
    }
}

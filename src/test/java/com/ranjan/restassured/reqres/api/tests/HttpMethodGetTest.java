package com.ranjan.restassured.reqres.api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HttpMethodGetTest extends BaseTest {
    @Test
    public void getAllUsers_shouldReturn200() {
        given().
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
        when().
            get("https://reqres.in/api/users").
        then().
            statusCode(200);
    }

    @Test
    public void getSingleUser_shouldReturn200() {
        given().
            baseUri("https://reqres.in").
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
        when().
            get("/api/users/2").
        then().
            statusCode(200).
            body("data.id", equalTo(2)).
            body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void getPerPageUser_shouldReturnArraySize6() {
        given().
            baseUri("https://reqres.in").
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
        when().
            get("/api/users?page=2").
        then().
            statusCode(200).
            body("page", equalTo(2)).
            body("per_page", equalTo(6)).
            body("data", hasSize(6));
    }
}
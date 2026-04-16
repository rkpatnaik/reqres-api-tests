package com.ranjan.restassured.reqres.api.tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class HttpMethodPostTest extends BaseTest {

    @Test
    public void createUser_expectHttpStatus201() {
        HashMap<String, String> requestBody = new HashMap<String, String>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "dream king");

        given().
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
            contentType("application/json").
            body(requestBody).
        when().
            post("https://reqres.in/api/users").
        then().
            statusCode(201);
    }

}

package com.ranjan.restassured.reqres.api.tests;

/* REST Assured supports four main ways to send request bodies:
 * Raw JSON String
 * Map / HashMap
 * POJO (Serialization) Recommended
 * External JSON file
 */

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequestBodyExamplesTest extends BaseTest {
    @Test
    public void createUser_usingRawJsonString() {

        String requestBody = "{\"name\":\"morpheus\", \"job\":\"dream king\"}";
        given().
            header("x-api-key", "reqres_4c443c2fe563455e98d87adecc280679").
            contentType("application/json").
            body(requestBody).
        when().
            post("/api/users").
        then().
            statusCode(201);
    }

    @Test
    public void createUser_usingMap() {
    }
}

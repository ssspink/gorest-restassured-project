package com.gorest.testbase;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;


public class TestBase {
    static ValidatableResponse response;
 //   @BeforeClass
//
//    public static void inIt() {
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 3030;
//      //  RestAssured.basePath = "/stores";
//    }
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2/";
        // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/users" )
                .then().statusCode(200);
    }
    }


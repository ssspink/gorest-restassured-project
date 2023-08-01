package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2/";
        // RestAssured.port = 3030;
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);
    }
    //1. Extract the title
    @Test
    public void extractTitle(){
      List<String> titleList = response.extract().path("title");
        System.out.println("Extract title :" + titleList);
    }
    //2. Extract the total number of record
    @Test
    public void extractTotalNumberOfRecord(){
        List<String> totalRecord = response.extract().path("");
        System.out.println("total number of records are :" + totalRecord.size());
    }
    //3. Extract the body of 15th record
    @Test
    public void extractBodyOf15ThRecord(){
        String bodyOf15ThRecord = response.extract().path("[14].body");
        System.out.println("Body of 15th record is :" + bodyOf15ThRecord);
    }
    //4. Extract the user_id of all the records
    @Test
    public void userIdOfAll(){
        List<String> idsOfAll = response.extract().path("id");
        System.out.println("List of all ids are : " + idsOfAll);
    }
    //5. Extract the title of all the records
    @Test
    public void extractTitleOfAllRecord(){
        List<String> titleOfAllRecord = response.extract().path("title");
        System.out.println("Title of all records are :" + titleOfAllRecord );
    }
    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void titleOfRecordForId56978(){
        List<String> titleOfRecordForId = response.extract().path("findAll{it.userid=='56978'}.title");
        System.out.println("title for record id : " + titleOfRecordForId);
    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void extractTheBodyOfRecordForId(){
        List<String> extractTheBodyOfRecord = response.extract().path("findAll{it.id == '56973'}.body");
        System.out.println("extract the body of record for Id 56973 : " + extractTheBodyOfRecord);
    }
}

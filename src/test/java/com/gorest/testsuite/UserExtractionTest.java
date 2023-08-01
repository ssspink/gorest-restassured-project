package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
//        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test01() {
        List<Integer> allIds = response.extract().path("id");
        System.out.println(allIds);
    }

    //2. Extract the all Names
    @Test
    public void test02() {
        List<String> allNames = response.extract().path("name");
        System.out.println(allNames);
    }

    @Test
    //3. Extract the name of 5th object
    public void extractNameOfFifth() {
        String fifthName = response.extract().path("[4].name");
        System.out.println("Name of fifth object: " + fifthName);
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void nameOfAllObjectWithStatusInactive() {
        List<String> listInactiveStatus = response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("inactive status names are :" + listInactiveStatus);
    }
    @Test
    //5. Extract the gender of all the object whose status = active
    public void genderOfAllObjectWithStatusInactive() {
        List<String> genderListActiveStatus = response.extract().path("findAll{it.status == 'active'}.gender");
        System.out.println("gender list for active status are :" + genderListActiveStatus);
    }
    //6. Print the names of the object whose gender = female
    @Test
    public void nameOfAllObjectGenderFemale() {
        List<String> nameOfGenderFemale = response.extract().path("findAll{it.gender == 'female'}.name");
        System.out.println("Female gender names are :" + nameOfGenderFemale);
    }
    @Test
    //7. Get all the emails of the object where status = inactive
    public void emailsOfAllObjectStatusInactive() {
        List<String> emailOfStatusInactive = response.extract().path("findAll{it.status == 'inactive'}.email");
        System.out.println("emails of inactive status are :" + emailOfStatusInactive);
    }
    @Test
    //8. Get the ids of the object where gender = male
    public void idsOfTheObjectGenderFemale(){
        List<String> idsOfGenderFemale = response.extract().path("findAll{it.gender == 'female'}.id");
        System.out.println("ids of female gender are :" + idsOfGenderFemale);
    }
    @Test
    //9. Get all the status
    public void getAllStatus(){
        List<String> allStatusList = response.extract().path("status");
        System.out.println("All Status List :" + allStatusList);
    }
    @Test
    //10. Get email of the object where name = Deepesh Varrier
    public void emailOfKarthik(){
        List<String> email = response.extract().path("findAll{it.name == 'Deepesh Varrier'}.email");
        System.out.println("email for Deepesh Varrier is :" + email);
    }
    @Test
    //11. Get gender of id = 4040709}
    public void getGenderOfId(){
        List<HashMap<String,?>> genderOfId4040709 = response.extract().path("findAll{it.id == '4040709'}.gender");
        System.out.println("gender of id 4040709 : " + genderOfId4040709);
    }

}






    //11. Get gender of id = 5471}

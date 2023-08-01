package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2/";
       // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/users?page=1&per_page=20" )
                .then().statusCode(200);
    }
    //Verify the if the total record is 20
    @Test
    public void verifyTotalIs20(){
        response.body("total.size()",equalTo(20));
    }
    @Test
    //2. Verify the if the name of id = 4040719 is equal to ”Keerti Embranthiri”
            public void verifyName(){
      //  response.body("findAll{it.id == '4040719'}.name",equalTo("Keerti Embranthiri"));
    }
    @Test
    //3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    //response.body("name",hasItem("Sanya Kaur"));
    public void checkSingleName(){
        response.body("name",hasItem("Kamalesh Naik"));
    }
    //response.body("name",hasItems("Sanya Kaur","Anish Reddy Sr.","Sarala Menon"));
    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. BodhanGuha, Karthik Dubashi IV)
    @Test
    public void checkMultipleName(){
        response.body("name",hasItems("Sen. Gemine Singh","Kanti Iyengar","Bhoopat Somayaji"));
    }
    //5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void verifyEmail(){
        response.body("findAll{it.id == '4104748'}.email",hasItem("gemine_singh_sen@pouros-klocko.example"));
    }
    @Test
    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    public void verifyStatus(){
        response.body("findAll{it.name == 'Bhadra Asan'}.status",equalTo("active"));
    }
    @Test
    //7. Verify the Gender = male of user name is “Niro Prajapa
    public void verifyGender(){
        response.body("findAll{it.name == 'Shresth Tagore'}.gender",equalTo("female"));
    }
}











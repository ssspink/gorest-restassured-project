package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2/";
        // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/posts?page=1&per_page=25" )
                .then().statusCode(200);
    }
    //1. Verify the if the total record is 25
    @Test
    public void verifyTotalIs20(){
        response.body("total.size()",equalTo(25));
    }

    @Test
    //Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demittocentum.”
    public void verifyNameForId(){
        response.body("findAll{it.id == '56957'}.title",equalTo("Caterva colo libero talis adnuo."));
    }
    //3.Check the single user_id in the Array list (5522)
    @Test
    public void checkSingleUserId(){
        response.body("id",hasItem(56973));
    }
    //Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void checkMultipleIds(){
        response.body("id",hasItems(56969,56953,56978));
    }
    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
    //spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
    //Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
    //Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
    //antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
    //cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
    //adflicto. Assentator umquam pel."”
    @Test
    public void verifyTheBodyOfId() {
//           response.body("id",equalTo(56978))
//                   .body("user_id",equalTo(4040713))
//                   .body("title",equalTo("Rerum omnis sursum damno terror."))
//                   .body("body",equalTo("Denego aptus arma. Placeat decet subvenio. Tabernus unde officia. Abundans amplus vulnero. Aegre error anser. Quod vaco thymum. Comptus triginta agnitio. Quia versus tenus. Est cito ut. Pecus clamo venustas. Peior deficio tripudio. Textus clamo stultus. Caelestis nihil demergo."));
    }
}

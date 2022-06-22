package demo;

import demo1.BookAdd;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBook {


    @Test
    public void bookAdding(){

        RestAssured.baseURI="http://216.10.245.166";

     String response=given().header("Content-Type","application/json").body(BookAdd.addBookAPI()).when().post("/Library/Addbook.php").then().extract().response().asString();

        System.out.println(response);
    }
}

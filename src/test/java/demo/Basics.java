package demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI="https://rahulshettyacademy.com";
       String response= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();

        JsonPath jsonPath=new JsonPath(response);

        String placeID=jsonPath.getString("place_id");

        System.out.println(placeID);


        //update place

        given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeID+"\",\n" +
                        "\"address\":\"70 winter walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));


       String changedPlace= given().queryParam("key","qaclick123").queryParam("place_id",placeID).when().get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().asString();

        JsonPath jsonPath1=new JsonPath(changedPlace);
        String  actualAddress=jsonPath1.getString("address");
        System.out.println(actualAddress);






    }
}

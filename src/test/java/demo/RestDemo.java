package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RestDemo {


    public static void main(String[] args) {
        Response response= RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody());
        System.out.println(response.getContentType());
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
    }

    public void getResponse(){

        baseURI="https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).body("data[4].first_name",equalTo("George"));


    }

    public void testPost(){

        Map<String, Object> map=new HashMap<String, Object>();
        map.put("name","Raghav");
        map.put("job","Employee");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","Raghav");
        jsonObject.put("job","Employee");

        baseURI="https://reqres.in/api";
        given().body(jsonObject.toJSONString()).when().post("/users").then().statusCode(201).log().all();



    }

}


package demo;

import demo1.Basics1;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

    @Test
    public void sumValidationOfCourses(){

        int amount=0,price,copies;

        JsonPath jsonPath=new JsonPath(Basics1.coursePrice());

        int count=jsonPath.getInt("courses.size()");
        System.out.println(count);


        for(int i=0;i<count;i++){

            price=jsonPath.get("courses["+i+"].price");
            copies=jsonPath.get("courses["+i+"].copies");
            amount=amount+price*copies;
            System.out.println(amount);

        }

        int totalPrice=jsonPath.get("dashboard.purchaseAmount");
        System.out.println(totalPrice);

        Assert.assertEquals(amount,totalPrice);



    }
}

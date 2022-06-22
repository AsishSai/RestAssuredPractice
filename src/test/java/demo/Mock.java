package demo;

import demo1.Basics1;
import io.restassured.path.json.JsonPath;

public class Mock {

    public static void main(String[] args) {
        JsonPath jsonPath=new JsonPath(Basics1.coursePrice());

        System.out.println(" User B has done modifications to this code");

       int count= jsonPath.getInt("courses.size()");

        System.out.println(count);


        int purchaseAmount=jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);


        String firstCourseTitle=jsonPath.getString("courses[0].title");
        System.out.println(firstCourseTitle);

        for(int i=0;i<count;i++){
            System.out.println(jsonPath.getString("courses["+i+"].title"));
            System.out.println(jsonPath.getInt("courses["+i+"].price"));
        }
    }





}
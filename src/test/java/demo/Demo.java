package demo;

import demo1.Basics1;
import io.restassured.path.json.JsonPath;

public class Demo {



    public static void main(String[] args) {

        JsonPath jsonPath=new JsonPath(Basics1.coursePrice());

        int count=jsonPath.get("courses.size()");
        System.out.println(count);

        for(int i=0;i<count;i++){
            String courseTitle=jsonPath.get("courses["+i+"].title");
            if(courseTitle.equalsIgnoreCase("RPA")){
                int copiesCount=jsonPath.get("courses["+i+"].copies");
                System.out.println(copiesCount);
                break;
            }



        }
    }
}

package com.xorail.hrm.tests;

import com.requestbuilder.RequestBuilders;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class GetRequests extends BaseTest  {


    @Test
    public void getEmployeeDetails(){
        Response response = RequestBuilders.buildRequestforGetCall()
                        .get("/employees");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        response.prettyPrint();

        assertThat(response.getStatusCode())
                .isEqualTo(200)
                .isPositive()
                .isGreaterThan(199)
                .isEven();

        assertThat(response.getTime())
//                .isCloseTo(550, Percentage.withPercentage(25))
                .isPositive()
                .isNotNull();
    }

    @Test(dataProvider = "getData")
    public void getEmployee(int id, String fname, String lname, String email){

        Response response = RequestBuilders.buildRequestforGetCall()
                .pathParams("id", id)
                .get("/employees/{id}");

        assertThat(response.jsonPath().getString("first_name"))
                .isEqualTo(fname);

        assertThat(response.jsonPath().getString("last_name"))
                .isEqualTo(lname);

        assertThat(response.jsonPath().getString("email"))
                .isEqualTo(email);

        response.prettyPrint();
    }

   @DataProvider
    public Object[][] getData(){

       return new Object[][]{
               {1, "Sebastian", "Eschweiler", "sebastian@codingthesmartway.com"},
               {2, "Steve","Palmer", "steve@codingthesmartway.com"}
       };
   }
}

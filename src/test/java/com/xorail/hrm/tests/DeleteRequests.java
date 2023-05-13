package com.xorail.hrm.tests;

import com.requestbuilder.RequestBuilders;
import io.restassured.response.Response;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteRequests {

    @Test
    public void getEmployeeDetails(){
        Response response = RequestBuilders.buildRequestforGetCall()
               // .get("/employees");
                       .delete("/employees/123");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        response.prettyPrint();

        assertThat(response.getStatusCode())
                .isEqualTo(200);
//                .isPositive()
//                .isGreaterThan(199)
//                .isEven();
//
//        assertThat(response.getTime())
//                .isCloseTo(550, Percentage.withPercentage(25))
//                .isPositive()
//                .isNotNull();
    }
}

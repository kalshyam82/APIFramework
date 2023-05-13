package com.requestbuilder;

import com.constans.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RequestBuilders {

    /*
 given().baseUri("http://localhost:3000")
                        .log()
                        .all()


                 given().baseUri("http://localhost:3000")
                .log()
                .all()
                .contentType(ContentType.JSON)
     */

    public static RequestSpecification buildRequestforGetCall(){
        return given().baseUri(FrameworkConstants.getBaseuri()).log().all();
    }

    public static RequestSpecification buildRequestforPostCall(){
        return buildRequestforGetCall().contentType(ContentType.JSON);
    }


}

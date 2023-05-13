package com.xorail.hrm.tests;

import com.com.utils.RandomUtils;
import com.constans.FrameworkConstants;
import com.github.javafaker.Faker;
import com.pojo.Employee;
import com.requestbuilder.RequestBuilders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class PostRequests  {

    @Test
    public void createEmployeeTest(){

        Employee employee = Employee.builder()
                .setId(RandomUtils.getID())
                .setFname(RandomUtils.getFname())
                .setLname(RandomUtils.getLName())
                .setEmail(RandomUtils.getEmails())
                .build();

        Response response=RequestBuilders.buildRequestforPostCall()
                .body(employee)
                .post("/employees");

        response.prettyPrint();
        Assertions.assertThat(response.getStatusCode())
                .isPositive()
                .isEqualTo(201);
    }

    @Test
    public void createEmployeeusingExternalFile() throws IOException {


      //  byte[] bytes=Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/test.json"));
     //   System.out.println(System.getProperty("user.dir")+"/src/test/resources/jsons/request.json");
        byte[] bytes = Files.readAllBytes(Paths.get(FrameworkConstants.getRequestJsonFolderPath()+"request.json"));
        String reqBody = new String(bytes)
                .replace("1710", String.valueOf(RandomUtils.getID()));

        System.out.println(reqBody);

        Response response=RequestBuilders.buildRequestforPostCall()
                .body(reqBody)
                .post("/employees");

        response.prettyPrint();
        Assertions.assertThat(response.getStatusCode())
                .isPositive()
                .isEqualTo(201);
    }
}

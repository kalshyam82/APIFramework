package com.xorail.hrm.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    @Test
    public void test1(){

        //before suite
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

       // Test info
        extent.createTest("MyFirstTest")
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

        //after suite
        extent.flush();

    }
}

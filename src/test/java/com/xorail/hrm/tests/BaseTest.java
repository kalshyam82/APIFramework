package com.xorail.hrm.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    ExtentReports extent;
    ExtentSparkReporter spark;
    @BeforeSuite
    public void beforeSuite(){
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
    }

    @BeforeMethod
    public void beforeMethod(){
        extent.createTest("MyFirstTest")
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
    }

    @AfterMethod
    public void afterMethod(){

    }
}

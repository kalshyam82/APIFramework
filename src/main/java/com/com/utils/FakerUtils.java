package com.com.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

        static String getFirstName(){
           return new Faker().name().firstName();
       }

       static String getLastName(){
           return new Faker().name().lastName();
       }

       static String getEmail(){
           return new Faker().name().username()+"@test.com";
       }

       static int getId(int minVal, int maxVal){
           return new Faker().number().numberBetween(minVal, maxVal);
       }
}

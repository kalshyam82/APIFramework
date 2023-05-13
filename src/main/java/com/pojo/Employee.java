package com.pojo;


import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Employee {

    private String fname;
    private String lname;
    private String email;
    private int id;

}

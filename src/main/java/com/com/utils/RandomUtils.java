package com.com.utils;

import java.security.PrivateKey;

import static com.com.utils.FakerUtils.*;

public class RandomUtils {

    private RandomUtils(){}

    public static int getID(){
            return getId(1000, 2000);
    }

    public static String getFname(){
        return getFirstName();
    }

    public static String getLName(){
        return getLastName();
    }

    public static String getEmails(){
        return getEmail();
    }
}

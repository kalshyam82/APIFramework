package com.constans;

import lombok.Getter;


public class FrameworkConstants {

    //System.getProperty("user.dir") + "/src/test/resources/jsons/request.json"

    @Getter
    private static final String requestJsonFolderPath = System.getProperty("user.dir") + "/src/test/resources/jsons/";

    @Getter
    private static final String baseuri ="http://localhost:3000";

}

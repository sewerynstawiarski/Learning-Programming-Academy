package com.HighLand;

import java.util.HashMap;

public class IDandPassword {

    HashMap<String, String> idandPassword = new HashMap<String,String>();

    IDandPassword() {

        idandPassword.put("User1" , "password1");
        idandPassword.put("User2","password2");
        idandPassword.put("User3", "password3");
    }
    protected HashMap getLoginInfo() {
        return idandPassword;
    }

}

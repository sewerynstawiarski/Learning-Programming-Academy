package com.HighLand;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String password;
    public void message() {
        System.out.println("Hello! " + name + password);
    }
}

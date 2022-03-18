package com.HighLand;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 151;  // w ten sposób przypisujesz numer UID do danej wersji obiektu
    
    String name;
    String password;
    
    public void sayHello() {
        System.out.println("Hello " + name);
    }
}

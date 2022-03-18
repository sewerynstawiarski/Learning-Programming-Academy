package com.HighLand;

public class AgeException extends Exception{

    AgeException (String message) {
        super(message); // przyzywasz klasę wyższą by zajęła się tą wiadomością, któa wyskoczy, gdy napotka problem
    }
}

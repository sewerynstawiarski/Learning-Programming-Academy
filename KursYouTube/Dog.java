package com.HighLand;

public class Dog extends Animal{
    @Override // dobrą praktyką jest zaznaczyć, że jest tu nadpisanie, tak by ktoś czytający kod mógł zozumieć co się dzieje
    void speak() {
        System.out.println("Ten zwierzak jednak nie gada!");
    }
}

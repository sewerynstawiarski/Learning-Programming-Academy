package com.HighLand;

public class Human {
    String name;
    int age;
    double weight;

    Human (String name, int age, double weight) {

        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    void spożywa() {
        System.out.println(this.name + " spożywa!");
    }
    void popija() {
        System.out.println(this.name +" popija!");
    }

}

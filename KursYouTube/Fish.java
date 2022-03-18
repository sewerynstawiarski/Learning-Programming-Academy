package com.HighLand;

public class Fish implements Prey,Predator{

    @Override
    public void hunts() {
        System.out.println("This fish is hunting smaller fish!");
    }

    @Override
    public void flee() {
        System.out.println("This fish is fleeing from bigger fish!");
    }
}

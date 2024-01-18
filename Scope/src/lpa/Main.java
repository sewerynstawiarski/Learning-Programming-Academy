package lpa;

import lpa.scopeChallengeSolution.X;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String varFour = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();


        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();

//        System.out.println("varThree is not accessible here " + innerClass.varThree);


//        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
//        System.out.println(varFour);
//        scopeInstance.timesTwo();
//
//        System.out.println("-".repeat(70));
//
//        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        innerClass.timesTwo();


        X x = new X(new Scanner(System.in));
        x.x();
    }
}

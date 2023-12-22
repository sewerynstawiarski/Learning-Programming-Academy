public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello, Seweryn");
        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It is not an allien");
            System.out.println("And i am scared of Alliens");
        }

        int topScore = 80;
        if (topScore < 100) {
            System.out.println("You got the high score");
        }
        int secondTopScore =95;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("Better than the second score and less than 100");

        }
        if ((topScore > 90) || (secondTopScore <=90)) {
            System.out.println("Either or both of the conditions are true");
        }

        int newValue =50;
        if (newValue == 50) {
            System.out.println("This is an actually working");
        }

        boolean isCar = false;
        if (isCar) {
            System.out.println("This is not supposed to happen");
        }

        String makeOfCar ="Mercedes";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;
        if (isDomestic) {
            System.out.println("This car is domestic to our country");
        }
        String s = (isDomestic ) ? "This car is domestic" : "This car is not domestic";
        System.out.println(s);
    }

}
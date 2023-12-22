public class Main {
    public static void main(String[] args) {
        int testedNumber = 4;
        int finishNumber = 20;
        int totalNumberOfEven = 0;
        int totalNumberOfOdd =0;

        while (testedNumber <= finishNumber) {
            testedNumber++;
            if (isEvenNumber(testedNumber)) {
                totalNumberOfOdd++;
            if (isEvenNumber(testedNumber)) {
                System.out.print(testedNumber + "_");
                totalNumberOfEven++;
                if (totalNumberOfEven >= 5) {
                    break;
                }
            }
            }
        }
        System.out.println("Total number of even numbers in this rage is: " + totalNumberOfEven + " and total number of odd numbers in this range is: " + totalNumberOfOdd);
    }
    public static boolean isEvenNumber (int number) {
        if (number % 2 == 0) {
            return true;
        } else return false;
    }
}

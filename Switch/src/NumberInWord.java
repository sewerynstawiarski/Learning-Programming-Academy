public class NumberInWord {
    public static void main(String[] args) {
    printNumberInWord(-4);
    printNumberInWord(1);
    printNumberInWord(2);
    printNumberInWord(3);
    printNumberInWord(4);
    printNumberInWord(5);
    printNumberInWord(6);
    printNumberInWord(7);

    }

    public static void printNumberInWord (int number) {
        String numberInWord = "";
        switch (number) {
            case 0 : {
                numberInWord = "zero";
            } break;
            case 1: {
                numberInWord = "one";
            } break;
            case 2 : {
                numberInWord = "two";
            } break;
            case 3 : {
                    numberInWord = "three";
                } break;
            case 4 : {
                numberInWord = "four";
            } break;
            case 5 : {
                numberInWord = "five";
            } break;
            case 6 : {
                numberInWord = "six";
            } break;
            case 7 : {
                numberInWord = "seven";
            } break;
            case 8 : {
                numberInWord = "eight";
            } break;
            case 9 :
            {
                numberInWord = "nine";
            } break;
            default: numberInWord = "other";
            break;
        }
        System.out.println(numberInWord);
    }
}

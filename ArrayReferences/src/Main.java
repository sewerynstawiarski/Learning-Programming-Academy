import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myIntarray = new int[5];
        int[] anotherArray = myIntarray;

        System.out.println("myIntArray = " + Arrays.toString(myIntarray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherArray));

        anotherArray[0] = 1;
        modifyArray(myIntarray);

        System.out.println("myIntArray = " + Arrays.toString(myIntarray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherArray));



    }

    private static void modifyArray(int[] array) {
        array[1] =2;
    }
}

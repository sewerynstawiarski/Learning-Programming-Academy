import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {


    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Type in number: ");
            array[i] = scanner.nextInt();
        } return array;
    }
    public static void printArray(int[] array) {
       for (int i = 0; i < array.length; i++) {
           System.out.println("Element " + i + " contents " + array[i]);
       }
    }

    public static int[] sortIntegers(int[] unsortedArray) {
        int[] sortedIntegers = Arrays.copyOf(unsortedArray, unsortedArray.length);
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int i = 0; i < sortedIntegers.length-1; i++) {
                if (sortedIntegers[i] < sortedIntegers[ i + 1]) {
                    temp = sortedIntegers[i];
                    sortedIntegers[i] = sortedIntegers[i +1];
                    sortedIntegers[i +1] = temp;
                    flag = true;
                }
            }
        }
        return sortedIntegers;
    }
}

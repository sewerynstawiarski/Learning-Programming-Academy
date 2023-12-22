import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] receivedArray = readIntegers();
//        System.out.println(findMin(receivedArray));
//reverseArray(receivedArray);

        int[] reverseCopy = reverseCopy(receivedArray);
        System.out.println("Before reverse " + Arrays.toString(receivedArray));
        System.out.println("reversed copy: " + Arrays.toString(reverseCopy));
    }

    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in list of integers separated by coma: ");
        String list = scanner.next();
        String[] sArray = list.split(",");
        int[] integerArray = new int[sArray.length];

        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = Integer.parseInt(sArray[i].trim());
        }
        return integerArray;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
//       for (int i = 0; i < array.length; i++) {
//           if (array[i] < min) {
//               min = array[i];
//           }
//       }
        for (int i :
                array) {
            if (i < min) {
                min = i;
            }
        }
            return min;

    }

    private static void reverseArray(int[] array) {
//        int[] swapedArray = Arrays.copyOf(array, array.length);
//
//        for (int i = 0; i < array.length; i++) {
//            swapedArray[i] = array[(array.length-1) - i];
//        }
//        System.out.println("Before reversing " + Arrays.toString(array));
//        System.out.println("After reversing " + Arrays.toString(swapedArray));


        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
            System.out.println("-->" + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }

    private static int[] reverseCopy(int[] array) {
        int[] reversedArray = new int[array.length];
        int maxIndex = array.length - 1;

        for (int i :
                array) {
            reversedArray[maxIndex--] = i;
        }
        return reversedArray;
    }
    private static void ReverseArray(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        int maxIndex = array.length -1;
        int halfIndex = array.length / 2;
        for (int i = 0; i < halfIndex; i++) {
            int temp = array[i];
            array[i] =  array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}

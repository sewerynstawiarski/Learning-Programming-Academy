import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intArray =  new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(100);
        }

        int[] sortedArray = Arrays.copyOf(intArray, 10);

        Arrays.sort(sortedArray);
        int[] copyOfSortedArray = Arrays.copyOf(sortedArray, sortedArray.length);

        int value = 0;
        for (int i = 0; i < sortedArray.length; i++) {
           for (int j = 0; j < sortedArray.length-i; j++) {
               if (sortedArray[j] > value){
                   value = sortedArray[j];
               }
           }
          copyOfSortedArray[i] = value;
           value =0;

        }




        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(copyOfSortedArray));

    }
}

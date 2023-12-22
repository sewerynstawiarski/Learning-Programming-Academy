public class Sum3And5Chellange {
    public static void main(String[] args) {
        int sum = 0;
        int numberOfMatches = 0;
     for (int i = 1; i >= 1 && i <= 1000; i++) {
         if ( (i % 3) == 0 && (i % 5) ==0 ) {
             System.out.println(i);
             sum+=i;
             numberOfMatches++;
             if (numberOfMatches == 5) {
                 break;
             }
         }
     }
        System.out.println("The sum of the number that can be divided by 3 and 5 is : " + sum);
    }
}

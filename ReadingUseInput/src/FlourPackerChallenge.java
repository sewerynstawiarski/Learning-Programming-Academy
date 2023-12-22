public class FlourPackerChallenge {
    public static void main(String[] args) {
        System.out.println( canPack(1,0,4));
        System.out.println( canPack(1,0,5));
        System.out.println( canPack(0,5,4));
        System.out.println( canPack(2,2,11));
        System.out.println( canPack(-3,2,12));
        System.out.println(canPack(6,2,17));
        System.out.println(canPack(0,2,17));
        System.out.println(canPack(0,189,17));
    }
    public static boolean canPack (int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        int bigCountKilo = bigCount * 5;
        int sumCount = bigCountKilo + smallCount;


        if (sumCount == goal) {
            return true;
        }
        if (sumCount < goal) {
            return false;
        }

        while (goal >= 5 && bigCount >0) {
            goal -= 5;
            bigCount--;
        }
        while (goal > 0 && smallCount >0) {
            goal--;
            smallCount--;
        }
        return goal == 0;
//        while(goal > 0) {
//            if (sumCount >= 5 && bigCount > 0) {
//                bigCount--;
//                goal -=5;
//            } else if (goal < 5 && smallCount > 0) {
//                 smallCount--;
//                 goal--;
//            }
//        }
//        if (goal == 0) {
//


        }
    }

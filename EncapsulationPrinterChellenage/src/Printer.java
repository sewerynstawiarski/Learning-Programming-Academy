public class Printer {
private int tonerLevel;
private int pagesPrinted;
private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel < 0) {
            this.tonerLevel = 0;
        } if (tonerLevel > 100) {
            tonerLevel = 100;
        } else {
            this.tonerLevel = tonerLevel;
        }
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {

        int tempValue =  tonerLevel + tonerAmount;
        if (tempValue > 100 || tempValue < 0) {
            return -1;
        }
        tonerLevel += tonerAmount;
        return tonerLevel;
//        if (((tonerLevel += tonerAmount) > 100) || (((tonerLevel += tonerAmount) < 0 ))) {
//            tonerLevel = (-1);
//        } else {
//            tonerLevel += tonerAmount;
//        } dlaczego dodaje w linijce if??

    }

    public int printPages(int pages) {
            if (pages < 0) {
                System.out.println("Wrong number of pages passed, have to be plus number");
                return pagesPrinted;
            }
//            if (duplex) {
//                pagesPrinted += ((pages / 2) + (pages % 2));
//                System.out.println("The printer is duplex");
//                return ((pages / 2) + (pages % 2));
//
//            } else {
//                pagesPrinted += pages;
//                return pages;
//            }
        int jobPages = (duplex) ? (pages /2) + (pages % 2) : pages;
        pagesPrinted += jobPages;
        return jobPages;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}

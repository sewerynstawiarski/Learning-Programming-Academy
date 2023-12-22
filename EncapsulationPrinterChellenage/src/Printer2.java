public class Printer2 {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer2(int tonerLevel, boolean duplex) {
        if (tonerLevel < 0 || tonerLevel > 100) {
            this.tonerLevel = -1;
        } else {
            this.tonerLevel = tonerLevel;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount <= 0 || tonerAmount >100) {
            return -1;
        }
        int tempValue = tonerLevel + tonerAmount;
        if (tempValue > 100) {
                return -1;
            } else {
            return tonerLevel += tonerAmount;
        }
    }

    public int printPages(int pages) {
        if (duplex) {
            System.out.printf("Printer is duplex");
        }
        int pagesToPrint = (duplex) ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}

package com.HighLand;

public class Pizza {
    String ciasto;
    String sos;
    String ser;
    String składnik;
Pizza (String ciasto,String sos,String ser,String składnik ) {
this.ciasto = ciasto;
this.sos = sos;
this.ser = ser;
this.składnik = składnik;
}
    Pizza (String ciasto,String sos,String ser) {
        this.ciasto = ciasto;
        this.sos = sos;
        this.ser = ser;
    }
    Pizza (String ciasto,String sos) {
        this.ciasto = ciasto;
        this.sos = sos;

    }
    Pizza (String ciasto) {
        this.ciasto = ciasto;
    }
    Pizza () {
    }
}

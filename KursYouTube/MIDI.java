package com.HighLand;

public class MIDI {
   private String make;
   private String model;
   private int year;

   MIDI (String make, String model, int year) {
       //this.make = make; jeśli ustawię metodę publiczną set to nie muszę już w konstruktore ustanawiać tych zmiennych, mogę tylko przywołać ta publiczną metodę
       //this.model = model;
       //this.year = year;
       this.setMake(make);
       this.setModel(model);
       this.setYear(year);


   }
   public String getMake() {
       return make;
   }
    public String getModel() {

       return model;
    }

    public int getYear() {
       return year;
    }
    public void setMake (String make) {
       this.make = make;
    }
    public void setModel (String model) {
        this.model = model;
    }
    public void setYear (int year) {
        this.year = year;
    }
    public void copy (MIDI x) {
       this.setMake(x.getMake());
       this.setModel(x.getModel());
       this.setYear(x.getYear());
    }
    MIDI( MIDI x) {
       this.copy(x);
    }


}

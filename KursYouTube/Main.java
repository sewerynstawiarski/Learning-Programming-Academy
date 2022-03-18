package com.HighLand;



import javax.sound.sampled.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        //Random random = new Random();
        //int x = random.nextInt(100)+1;
        //double y = random.nextDouble();
        //boolean z = random.nextBoolean();

        //int age = 15;

        //if(age>= 75) {
        //   System.out.println("No weź...");
        //}
        // else if (age>= 18) {
        // System.out.println("Dorosły jesteś chłopie!");
        // }
        // else if (age>= 13){
        //  System.out.println("Zmiataj do domu!");
        // }
        //else {
        //  System.out.println("You are not adult!");
        //}

        /*String day = "Gyudon";

        switch (day) {
            case "Sunday":
                System.out.println("It's Sunday");
                break;
            case "Saturday":
                System.out.println("It's Saturday!");
                break;
            case "Friday":
                System.out.println("It's Friday!");
                break;
            default:
                System.out.println("To nie jest weekend?!");
         */

        /*int temp = 40;

        if (temp >= 30) {
            System.out.println("Gorąco!");
        }
        else if (temp >= 20 && temp <= 30) {
            System.out.println("Ciepło jest");
        }
        else System.out.println("No niezbyt ciepło!");

         */
        /*

        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz rozpocząc rozgrywkę?");
        String response = scanner.next();

        if (response.equals("q") || response.equals("Q")) {
            System.out.println("Nie to nie!");
        }
        else System.out.println("Let's play some game");
         */
        //wersja druga

        /*

        Scanner scanner = new Scanner(System.in);
        System.out.println("Gramy dalej?");
        String response = scanner.next();

        if (!response.equals("q") && !response.equals("Q")){
            System.out.println("No to jazda!");
        }
        else System.out.println("Nie to nie");
         */

        /*
        wesrsja 1

        Scanner scanner = new Scanner(System.in);
        String name ="";

        while (name.isBlank()) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }
        System.out.println("Welcome " +name);

         */

        /* wersja druga - gdzie zawsze przynajmniej raz blok kodu zostanie wykonany a później dopiero srawdza się warunek
        Scanner scanner = new Scanner(System.in);
        String name ="";

        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }while (name.isBlank());
            System.out.println("Welcome " +name);

         */
        /* Ta funkcja pozwala wykonać blok kodu określoną liczbę razy (index:warunek: odziałyanie na index)
        for (int i = 10; i >= 0; i-=2) {
            System.out.println(i);
        }
        System.out.println("Happy New Year!");

         */

        /*
Nested loops, Funkcja w funkcji, dopóki nie skończysz jednej nie zakończy się też druga
        Scanner scanner = new Scanner(System.in);
        int rzędy;
        int kolumny;
        String symbol = "";

        System.out.println("Wpisz liczbe wierszy: ");
        rzędy = scanner.nextInt();
        System.out.println("Wpisz liczbe kolumn: ");
        kolumny = scanner.nextInt();
        System.out.println("Jaki symbol? ");
        symbol = scanner.next();

        for (int i = 1; i <= rzędy; i++) {
            System.out.println();
            for (int j = 1; j <= kolumny; j++) {
                System.out.print(symbol);
            }
        }

         */

        /* wersja  1    przypisywaie wielu wartości do jednej zmiennej/ nawiasy
        String[] owoce = {"jabłko", "gruszka", "banan"};

        owoce[0] = "dżem jabłkowy";
        System.out.println(owoce[2]);
         */
        /* sposób drugi, ustanawisz zmienną, a póżniej dopisujesz jej wartości do poszczególnych miejsc
        String[] owoce = new String[3];

        owoce[0] = "jabłko";
        owoce[1] = "gruszka";
        owoce[2] = "brzoskwinia";

        for (int i=0; i<owoce.length; i++) {
            System.out.println(owoce[i]);
        }

         */

        /* nawiasy 2d/ zestawy danych w formie matryc/metoda 1

        String[][] owoce = new String[3][3];

        owoce[0][0] = "jabłko";
        owoce[0][1] = "gruszka";
        owoce[0][2] = "brzoskwinia";
        owoce[1][0] = "jagody";
        owoce[1][1] = "truskawki";
        owoce[1][2] = "arbuz";
        owoce[2][0] = "pomarańcz";
        owoce[2][1] = "grejfrut";
        owoce[2][2] = "melon";

        for (int i = 0; i < owoce.length; i++) {
            System.out.println();
            for ( int j = 0; j < owoce[i].length; j++) {
                System.out.print(owoce[i][j] +" ");
            }
        }

         */

        /*metoda drua, w której podajemy dane od razu zamiast później uszczegóławiać w każdej pozycji

        String[][] owoce = {
            {"jabłko", "gruszka", "brzoskwinia"},
            {"jagody", "truskawki", "arbuz"},
            {"pomarańcz", "grejfrut", "melon"}
        };


        for (int i = 0; i < owoce.length; i++) {
            System.out.println();
            for ( int j = 0; j < owoce[i].length; j++) {
                System.out.print(owoce[i][j] +" ");
            }
        }

         */
        /*
        String name ="Seweryn";
        String nazwisko = " Stawiarski ";
        //ta metoda sprawdzenia czy wartość równa się zadeklarowanej = true/false ignoruje duże/małe litery
        boolean result = name.equalsIgnoreCase("seweryn");
        int ile = name.length(); // oddaje długość wyrazy/wartości
        char znak = name.charAt(3); // pozwala wyodrębnić poszczególny charakter z wyrazu
        int miejsce = name.indexOf("w"); // zwraca index poszukiwanego znaku, czyli gdzie on jest w Stringu, zaczyn się od 0
        boolean pusto = name.isEmpty(); // sprawdza czy String jest pustry = false/true
        String duże = name.toUpperCase(); // zmienia litery na duże
        String małe = name.toLowerCase(); // zmienia litery na małe
        String spacje = nazwisko.trim(); // usuwa spacje/przerwy
        String zamiana = name.replace("e","o"); //pozwala zamienić znaki w wartości na inne

        System.out.println(result);
        System.out.println(ile);
        System.out.println(znak);
        System.out.println(miejsce);
        System.out.println(pusto);
        System.out.println(duże);
        System.out.println(małe);
        System.out.println(spacje);
        System.out.println(zamiana);

         */
        // wrapper class =  provides a way to use primitive data types as reference data types
        //     reference data types contain useful methods
        //     can be used with collections (ex.ArrayList)

        //primitive  //wrapper
        //---------  //-------
        // boolean  Boolean
        // char   Character
        // int   Integer
        // double  Double

        // autoboxing = the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes
        // unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive
        //pozwala zamienić wartości prymitywne (znaki/liczby/false/true) na wartości referencyjne jak String i na nich operować wtedy
        // dzięki unboxing można je jednak traktować wciąż jako prymitywne wartości
        // używanie wrapper class zajmuje znacznie więcej zasobów, jest wlniejsze, niż używanie prymitywnych

        /*
        Boolean a = false;
        Character b = '@';
        Integer c = 345;
        Double d = 3.14;
        String e = "Seweryn";
        //przykład unboxingu
        if (c==345) {
            System.out.println("Correct!");
        }

         */

        // ArrayList = 	a resizable array.
        //				Elements can be added and removed after compilation phase
        //				store reference data types

        /*
        Listy/ szyk wartości, pozwalające ustawić dane według indexów (od zera)
        tylko do referencyjnych danych, więc dla prymitywnych trzeba uzyć wrapper (czyli Boolean, Integer itp.)
        można dodawać elemnty, usuwać elementy, zamianiać na danym miejscu
        ArrayList<String> jedzonko = new ArrayList<String>();


        jedzonko.add("hamburger");
        jedzonko.add("pizza");
        jedzonko.add("jagody");

        jedzonko.set( 0, "sushi");
        //jedzonko.remove(1);
        //jedzonko.clear();


        for (int i=0; i<jedzonko.size(); i++) {
            System.out.println(jedzonko.get(i));
        }

         */

        //Listy list, 2D Arrays listes, pozwalają przechowywać kilka list danych i wywoływać

        /*
        ArrayList<ArrayList<String>> sprzęt = new ArrayList<>();

        ArrayList<String> monitory = new ArrayList<>();
        monitory.add("KRK");
        monitory.add("Presonus");
        monitory.add("Mackie");


        ArrayList<String> słuchawki = new ArrayList<>();
        słuchawki.add("AKG");
        słuchawki.add("beyerdynamic");
        słuchawki.add("HiFiman");


        ArrayList<String> mikrofony = new ArrayList<>();
        mikrofony.add("Rode");
        mikrofony.add("Audio Technica");

        sprzęt.add(monitory);
        sprzęt.add(słuchawki);
        sprzęt.add(mikrofony);

        System.out.println(sprzęt);
        System.out.println(sprzęt.get(1).get(1));

         */

        /*

        // for-each = 	traversing technique to iterate through the elements in an array/collection
        //				less steps, more readable
        //				less flexible
        // Pozwala na szybkie działanie na wszystkich elementach listy
        //String[] monitory = {"presonus", "Mackie", "Yamaha"};
        ArrayList<String> monitory = new ArrayList<String>();

        monitory.add("presonus");
        monitory.add("Mackie");
        monitory.add("Yamaha");

        for(String i : monitory) {
            System.out.println(i);
        }

         */
        /*

        String name = "Seweryn";
        int age = 30;

        hello(name, age);

        To co poniżej musi być podane jako osobna metoda czyli poza main u góry, póxniej osobne {}
        Pozwala na przywołanie jednej metody w innej wpisując tylko nazwę metody i w nawiasie jaką wysyłasz informację
        a po drugiej stronie, w nawiasie tworzenia nowej metody musisz wymienić odpowiedni rodzaj informacju, tak by się zgadzały,
        czly z dwóch stron String albo int na przykład

        static void hello(String imię, int wiek) {
    System.out.println("Hello "+imię);
    System.out.println("Masz "+wiek);
}
         */

        // Tutaj ponownie, wysyłasz zmienne do innej metody, by ta coś zrobiła i je zwróciła w pasującej formie (dlatego return)

        /*

        int x = 5;
        int y = 6;

        int a = suma(x,y);

        System.out.println(a);




    }
    static int suma (int x, int y) {
        //int z = x+y;
        return x+y;

    }

         */
        /*
        // overloaded methods = methods that share the same name but have different parameters
        //						method name + parameters = method signature
        // To są metody o tych samych  nazwach ale różnych parametrach
        //zależnie od tego ile i jakie parametry ( a nawet w jakiej kolejności) wyślemy, zostanie użyta inna m etoda, moze że nazwa i to co robia pozostaje te same

        double z = suma(1.0,2.0,3.0,4.0);
        System.out.println(z);
    }
    static int suma( int a, int b) {
        System.out.println("To jest metoda numer 1 - mogę tylko dwa int wysłać");
        return a+b;
    }
    static int suma(int a, int b, int c) {
        System.out.println("To jest metoda numer 2 - mogę tylko trzy int wysłać");
        return a+b+c;
    }
    static int suma(int a, int b, int c, int d) {
        System.out.println("To jest metoda numer 3 - mogę tylko cztery int wysłać");
        return a+b+c+d;
    }
    static double suma( double a, double b) {
        System.out.println("To jest metoda numer 4 - mogę tylko dwa double wysłać");
        return a+b;
    }
        static double suma(double a, double b, double c) {
        System.out.println("To jest metoda numer 5 - mogę tylko trzy double wysłać");
        return a+b+c;
    }
        static double suma(double a, double b, double c, double d) {
        System.out.println("To jest metoda numer 6 - mogę tylko cztery double wysłać");
        return a+b+c+d;
    }

         */

        // printf() = 	an optional method to control, format, and display text to the console window
        //				two arguments = format string + (object/variable/value)
        //				% [flags] [precision] [width] [conversion-character]
        /*

        boolean myBoolean = true; // %b
        int myInt = 23; //%d
        String myString = "Seweryn"; //%s
        double myDouble = 10000.50; //%f
        char myChar = '@'; //c
        //System.out.printf("%b", myBoolean);
        //System.out.printf("%c", myChar);
        //System.out.printf("%s", myString);
        //System.out.printf("%d", myInt);
        //System.out.printf("%f", myDouble);
        //[width]
        // minimum number of characters to be written as output
        //System.out.printf("Hello %10s",myString); //jak nie starczy liter to pokaże puste miejsca, a jeśli dasz liczbę ujemną
        // to puste miejsca będą za wyrazem zamiast przed

        //[precision]
        // sets number of digits of precision when outputting floating-point values
        //System.out.printf("You have this much money %.2f",myDouble); // .2 kropka i liczba oznacza ile miejsc po przecinku chcesz pokazać


        // [flags]
        // adds an effect to output based on the flag added to format specifier
        // - : left-justify
        // + : output a plus ( + ) or minus ( - ) sign for a numeric value
        // 0 : numeric values are zero-padded
        // , : comma grouping separator if numbers > 1000
        System.out.printf("You have this much money %,.2f",myDouble);

         */

        // final double PI = 3.14; słowo "final" przypisuje wartość, której później już nie można zmienić, są stałe

        // PI = 3; to jest błąd

        //System.out.printf(PI);

        //WAŻNE
        /*

        //object = odrębne klasa ( ty tera zużywasz klasy "main"), która zawiera atrybuty oraz metody
        // nna przykład wybraź sobie przedmioty wokół siebie ( klawiatura, monitor, laptop) mają swoje atrybuty (kolor, stan, wiek itp.) i rzeczy, które mogą wykonać
        // na przykład wysyłasz maila
        //System.out.printf("Wysyłasz maila"); będzie to metoda klasy laptop
        // OOP Object Oriented Programming
        // można tworzyć dodatkową klase w tym samym lub osobnym pliku .java

        Laptop myLaptop = new Laptop();
        Laptop myLaptop2 = new Laptop(); // możesz przywoływać do wielu nazw tą samą klase (zawierającą atrybuty i metody takie same)

        System.out.println(myLaptop.make);
        System.out.println(myLaptop.model);
        System.out.println();
        System.out.println(myLaptop2.make);
        System.out.println(myLaptop2.model);
        System.out.println();
        myLaptop.on();
        myLaptop.off();

         */

        // constractor = tworzenie obiektów o różnych właściwościach, by przywołać je w innej klasie
        //czyli tworzysz human i określasz jakie ma atrybuty, które musisz wymienić by go przywołać
        // dzięki temu, wysyłając atrybuty różne możesz tworzyć ten sam obiekt o różnych atrybutach = człowiek ale różne imię, wiek i waga
        //różne obiekty moga też używać różnej metody zawartej w klasie, co widac poniżej, jeden spożywa, drugi poija
        /*

        Human human1 = new Human("Ron",21,89);
        Human human2 = new Human("Harry", 20,56);
        System.out.println(human1.name);
        System.out.println(human2.name);
        System.out.println();
        human1.spożywa();
        human2.popija();

         */
        //local =  declared inside a method
        //   visible only to that method
        //global  = declared outside a method, but within a class
        //   visible to all parts of a class
        //DiceRoller diceRoller = new DiceRoller();
        //sprawdź klasę DiceRoller

        //overload constructors = mają taką samą nazwę ale różnią się parametrami
        // name + parameters = signature
        /*

        //Pizza pizza = new Pizza("kruche ciasto","czosnkowy", "mozarella", "szynka");
        //Pizza pizza = new Pizza("kruche ciasto","czosnkowy");
        //Pizza pizza = new Pizza("kruche ciasto");
        //Pizza pizza = new Pizza();
        Pizza pizza = new Pizza("kruche ciasto","czosnkowy", "mozarella", "szynka");
        System.out.println("Z czego ta pizza ? ");
        System.out.println(pizza.ciasto);
        System.out.println(pizza.sos);
        System.out.println(pizza.ser);
        System.out.println(pizza.składnik);
        //mogę wysłać tylko 3 wartości, wtedy zostanie użyty inny constuctor, który przyjmuje tylko 3 wartości, ale nazywa się tak samo
        // dlatego czwarte print równa się null

         */

        /*

        // toString() = special method that all objects inherit,
        //    that returns a string that "textually represents" an object.
        //    can be used both implicitly and explicitly
        //pozwala zaprezentować dane na przykład z danej klasy w formie String (tekstu)

        Laptop2 laptop = new Laptop2();
        //System.out.println(laptop); // przywołanie wewnętrzne - implicitly
        System.out.println(laptop.toString()); // przywołanie zewnętrzne - explicitly

         */

        /*

        //rzędy/tabele obiektów
        //Jedzenie[] lodówka = new Jedzenie[3];

        Jedzenie obiekt1 = new Jedzenie("jajka");
        Jedzenie obiekt2 = new Jedzenie("boczek");
        Jedzenie obiekt3 = new Jedzenie("płatki");

        Jedzenie[] lodówka = {obiekt1,obiekt2, obiekt3}; // alternatywny sposó zadeklarowania co jest na liście, przy takim deklarowaniu nie potrzebujesz listy poniżej

        //lodówka[0] = obiekt1;
        //lodówka [1] = obiekt2;
        //lodówka[2] = obiekt3;

        System.out.println(lodówka[1].name);

         */

        // przenoszenie obiektów między klasami. Poniżej wysyłam obiekt z klasy Car do klasy Garage(w której jest motoda "wyświetl, że aut jest zaparkowane)
        /*

        Garage garage = new Garage();
        Car car1 = new Car("BMW");
        Car car2 = new Car("Mercedes");

        garage.park(car1);
        garage.park(car2);

         */
        /*
        // static = modifier. A single copy of a variable/method is created and shared.
        //			The class "owns" the static member
        // czyli jest to jedna kopia zmiennej lub metody, która należy do danej klasy, i jest współdzielona przez tą klasę, Kiedy tworzę 3 obiekty to dla całej klasy ta liczba wynosi 3, dla wszystkich jej elementów

        Friends friend1 = new Friends("Gówniak");
        Friends friend2 = new Friends("Równiak");
        Friends firend3 = new Friends("Coolniak");

        //System.out.println(Friends.numberOfFriends); // można tą liczbę odczytać z poziomu obiektu "friend1.numberOfFriends" ale jest to zła praktyka
        Friends.displayFriends(); // tutaj przywołuje za pomocą osobnej metody, która jako static jest wspóldzielona przez wszystkie obiekty jakie wysłałem

         */
        /*
        // inheritance = 	the process where one class acquires,
        //					the attributes and methods of another.
        Dzięki temu można tworzyć klasy "córki" głównej klasy, które odziedziczą wszystkie jej wartości i metody. Wted nie trzeba przepisywać ich jeszcze raz jeśli różne klasy dzielą te same elementy, tylko tworzymy
        jedną główną klasę. Każda z klas córek może także posiadać soje niezależne elementy i metody.

        Bolid bolid = new Bolid();

        //bolid.go();

        Bicyle bicyle = new Bicyle();

        //bicyle.stop();

        //System.out.println(bolid.speed);
        //System.out.println(bicyle.speed);

        System.out.println(bolid.doors);
        System.out.println(bicyle.pedals);

         */
        /*
        // method overriding = 	Declaring a method in sub class,
        //						which is already present in parent class.
        //						done so that a child class can give its own implementation
        //pozwala nadpisać metodę lub wartość juz zawartą w super klasie, tak by klasa córka miała swoją niezależną wersję

        Dog dog = new Dog();
        Animal animal = new Animal();

        dog.speak();
        animal.speak();

         */
        /*

        // super = 	keyword refers to the superclass (parent) of an object
        //			very similar to the "this" keyword
        // pozwala nawiązywać do wartości i metod z klasy matki i szybko implemetować je w klasie córce za pomocą słowa "super"
        // tutaj klasa Person to Super, a hero to córka
        Hero hero1 = new Hero("Batman", 56, "cash");
        Hero hero2 =new Hero("Superman", 156, "Allien");

        System.out.println(hero2.toString());

         */
        /*

        // abstract =  	abstract classes cannot be instantiated, but they can have a subclass
        //				abstract methods are declared without an implementation
        // pozwalają stworzyć zabezpieczenie, użytkownik nie może stworzyć/zadeklarować zbyt ogólnego wariantu, musi bardziej szczegółowo
        // można tej stworzyć metody abstrakcyjne, ale wtedy w każdej klasie córce trzeba je uzupełnić, czyli tutaj wypłacalność jest bastrakcyjna dla województwa i trzeba to uzupełnić  w klasie powiat(co ta metoda robi w tym przypadku)


        Powiat powiat = new Powiat();
        //Województwo województwo = new Województwo();
        powiat.wypłacalność();

         */

        //public modifier wtedy jest widoczne dla wszystkich klas
        //protected to udostępnia jeśli klasa której używasz jest subklasą tej gdzie znajduje się dana zmienna/wartość
        // private daje dostęp tylko w zakresie danej klasy

        /*


        // encapsulation - metody getters and setters
        //getCoś to metoda, która pozwala wysłać prywatne wartości do innej klasy, ustawiasz taką metodą w klasie gdzie
        //są prywatne wartości i później za jej pośrednictwem uzyskasz dostęp  innych klasach

        MIDI midi = new MIDI("Maudio","Axiom",2020);

        //midi.setYear(2022); metoda set pozwala by z inne klasy ustawiać wartości w klasie, tutaj ustawiłem metody set w MIDI
        // które pozwalają za pomocą metody ustawić wartości  w tej klasie wysyłając je z klasy Main

        // get i set sprawia, że możesz uzyskac dostęp do private wartosci w danej klasie ale inne klasy nie mają domyślnie dostępu

        System.out.println(midi.getMake());
        System.out.println(midi.getModel());
        System.out.println(midi.getYear());

         */
        /*
        //jak skopiować jeden obiekt do drugiego
        MIDI midi1 = new MIDI("Maudio","Axiom",2020);
        //MIDI midi2 = new MIDI("Arturia","Microlab",2019);
        MIDI midi2 = new MIDI(midi1); // druga metoda to ustanowić konstruktor, który będziekopiował nadesłane dane i tworzył nowy obiekt i tak to zadeklarować
        // to wyszło tutaj krócej ponieważ wcześniej była metoda do kopiowa ustanowiona "copy"

        // midi2=midi1; to jest błąd bo będą miały ten sam adres w pamięci, właściwie nadałeś midi1 dwie nazwy
        // musisz ustanowić odpowiednią metodę do kopiowania(tutaj w klasie midi

        //midi2.copy(midi1); // teraz mają identyczne dane ale rózne adresy w pamięci dzieki metodzie "copy", czyli to różne obiekty, ale posiadaja te same atrybuty

        System.out.println(midi1);
        System.out.println(midi2);
        System.out.println();
        System.out.println(midi1.getMake());
        System.out.println(midi1.getModel());
        System.out.println(midi1.getYear());
        System.out.println();
        System.out.println(midi2.getMake());
        System.out.println(midi2.getModel());
        System.out.println(midi2.getYear());

         */
        // interface =  a template(szablon) that can be apllied to a class
        //sumiliar to inheritance but specifies what class has/must do
        //classes can apply more than one interface, inheritance is limited to 1 super
        // klasy Rabbit, Hawk, Fish oraz intereface Prey i Predator
        // w szablonach interefjsów nie musisz spisywać body dla metody
        // szablon pozwala przypomnieć co dana klasa musi zrobić, ale w kazdej klasie musisz uszczegółowić jak to robi
        //czyli tutaj ten sam szblon hunt daje innych wynik dla klasy fish i hawk
        /*

        Rabbit rabbit = new Rabbit();
        rabbit.flee();
        Hawk hawk =new Hawk();
        hawk.hunts();
        Fish fish = new Fish();
        fish.hunts();
        fish.flee();

         */
        // polymorphism = 	greek word for poly-"many", morph-"form"
        //					The ability of an object to identify as more than one type
        /*

        CarRace carRace =  new CarRace();
        BikeRace bikeRace = new BikeRace();
        BoatRace boatRace = new BoatRace();

        VehicaleRace[] racers = {carRace,bikeRace,boatRace}; // wspólną cechą jest to, że są pojazdami, dlatego mogę jew jednej tabeli umieścić w ten sposób
        // wszystkie trzy są subklasą Vehicale
        for (VehicaleRace x : racers) {
            x.go();
        } // dla każdego racers wykonaj

         */
        // dynamiczny polimorfizm, czyli okreslanie obiektów w czasie gdy program działa
        //tworzysz miejsce na obiekt w pamięci, mimo że jeszcze nie wiesz jakie to obiekt będzie
        //tutaj określa to user
        /*

        Zwierzaki zwierzaki;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Którego zwierzaka byś chciał?");
        System.out.print("(1=piechu) or (2=kot)");
        int wybór = scanner.nextInt();

        if (wybór == 1) {
            zwierzaki = new Pies();
            zwierzaki.speak();
        }
        else if (wybór == 2) {
            zwierzaki = new Kot();
            zwierzaki.speak();
        }
        else {
            zwierzaki = new Zwierzaki();
            System.out.println("Nie zdecydowałeś się!");
            zwierzaki.speak();
        }

         */
        // exception = 	an event that occurs during the execution of a program that,
        //				disrupts the normal flow of instructions
        // "try pozwala otoczyć niebezpieczny kod i uściślić co zrobić, gyd natkniemy się na wyjątek w "catch"
        /*
        Scanner scanner = new Scanner(System.in);
        try {



            System.out.println("Jaką liczbę chcesz podzielić? :");
            int x = scanner.nextInt();
            System.out.println("Przez jaką liczbę chcesz dzielić? :");
            int y = scanner.nextInt();

            int z = x / y;

            System.out.println("Wynik: " + z);
        }
        catch (ArithmeticException i) {
            System.out.println("Nie mozna dzielić przez zero!");
        }
        catch (InputMismatchException u) {
            System.out.println( "Wpisz liczbę!!!!");
        }
        catch (Exception k) {
            System.out.println("Coś się schrzaniło");
        } // ostatni catch "Exception" pozwala na reakcje na wszystki wyjątki, ale to leniwa praktyka, i uznaje się, że lepiej radzić sobie na poszczególne
        finally {
            //System.out.println("To zawsze się tu pojawi");
            scanner.close();
        } // blok finally zawsze zadziała na sam koniec, dobrą praktyką jest tu zamknąć skaner, ale pamiętaj by dać go poza "try" wtedy, inaczej nie będzie widziany

         */
        /*

        // file = An abstract representation of file and directory pathnames
        // pozwala sprawdzić czy dany plik istnieje, gdzie jest, i czy jest plikiem a nie folderem
        File file = new File("linki.txt");

        if (file.exists()) {
            System.out.println("Mam swoje linki zachowane~!~!~!");
            System.out.println(file.getPath()); // pkazuje nazwe pliku
            System.out.println(file.getAbsolutePath()); // dokładną ściężkę po plikach pokazuje
            System.out.println(file.isFile()); //sprawdza czy jest plikiem nie folderem
            file.delete(); // usuwa plik
        }
        else {
            System.out.println("Zgubiłem swoje linki!~!~!");
        }

         */
        // FileWrite pozwala stworzyć plik na przykład pisany, i dzięki metodom zmieniać
        // nalezy zawsze używać w formacie try jak poniżej
        /*
        try {
            FileWriter writer = new FileWriter("poezja mruczana");
            writer.write("Na górze róże (chyba) \n Na dole maki \n A to jes napad \n zdejmować kubraki");
            writer.append("\n Historia nieudanego poranka");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

         */
        // FileReader = read the contents of a file as a stream of characters.
        //read() returns an int value which contains the byte value
        //when read() returns -1, there is no more data to be read
        // File Reader pozwala sczytać znaki/dane z pliku
        //zawsze używamy z trybem try i trzeba później zamknąć
        /*
        try {
        FileReader reader = new FileReader("miejscówki do zwiedzenia.txt");
        int data = reader.read();
        while (data != -1) {
            System.out.print((char)data);
            data = reader.read();
        }
        reader.close();
    } catch (FileNotFoundException r) {
        r.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
        }

         */
        // tworzenie prostego odtwarzacza muzyki, w tym wypadku tylko dla plków wav
        /*
        Scanner scanner = new Scanner(System.in);
        File file = new File("podkład z aranżacją.wav");

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);


        String response = "";

        while (!response.equals("Q")) {
            System.out.println("P = Play, S = Stop, R = Resest , Q = Quit ");
            System.out.print("Enter your choice ");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case ("P") : clip.start();
                break;
                case ("S") :
                    clip.stop();
                    break;
                case ("R"): clip.setFramePosition(0);
                break;
                case ("Q"): clip.close();
                break;
                default:
                    System.out.println("Źle coś nacisnąłeś");
            }
        }
        System.out.println("THE END");

         */

        // JFrame = a GUI window to add components to
        // metoda pierwsza na stworzenie okienka
        /*
        JFrame frame = new JFrame(); // tak tworzysz obramowanie/menu/okienko
        frame.setTitle("Okienko próbne - tutaj tytuł"); // ustawiasz tytuł okienka
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sprawia, że po kliknięciu X program przestanie działać, domyślnie jest po prostu HIDe
        frame.setResizable(false); // sprawia, że nie można zmienić rozmiaru okienka za pomocą myszki
        frame.setSize(440,440); // ustawia wysokość i szerokość okienka

        ImageIcon icon = new ImageIcon("SharingaLogo.jpg"); // tworzy obraz/ikonę
        frame.setIconImage(icon.getImage()); // ustawia przywołaną ikonę jako ikonę okienka
        //frame.getContentPane().setBackground(Color.yellow); //ustanawiasz tło okienka, jego kolor, jeden z domyślnych
        frame.getContentPane().setBackground(new Color(100,3,89)); // tak ustawiasz kolor na podstawie współrzędnych RGB (o-255)/ *(red, green, blue)
        //frame.getContentPane().setBackground(new Color(0x0000FF)); // tak ustawiasz na podstawie liczb szesnastkowych

        frame.setVisible(true); // sprawia, że okrenko będzie widoczne


        //druga metoda na stworzenie okienka to stworzyć klasę córkę do klas JFrame i tam konstruktor odpowiedni
        //MyFrame myFrame = new MyFrame(); // przywołuje konstruktor okienka ze specjalnie utworzonej klasy
        //new MyFrame(); tak przywołujesz jeśli nie będziesz niczego zmieniał w tabelce już
         */

        // JLabel = a GUI display area for a string of text, an image, or both /  label=etykieta
        /*
        ImageIcon imageIcon = new ImageIcon("Avatar próbny.jpg"); // dodanie obrazka do projektu
        Border border = BorderFactory.createLineBorder(Color.red,5);    // tworzy możłiwość dodawania granic/obramowanie dla kompoenentu label

        JLabel label = new JLabel(); // albo new JLabel("Rany, rany, zakuwamy");
        label.setText("Rany, rany, zakuwamy"); // doda teskt do etykiety/label
        label.setIcon(imageIcon); // dodaje obraz do label
        label.setHorizontalTextPosition(JLabel.CENTER); // przy pomocy tej metody ustawiasz gdzie chcesz tekst LEFT/CENTER/RIGHT w stosunku do ikony
        label.setVerticalTextPosition(JLabel.TOP); // ustawiasz tekst TOP/CENTER/BOTTOM w stosunku do ikony
        label.setForeground(new Color(100,3,89)); // ustawiasz kolor czcionki tymi samymi metodai jak wyżej we frame, są trzy, domyślne/RGB/szesnastkowe liczby
        label.setFont(new Font("MV Boli",Font.CENTER_BASELINE,18)); // ustawiasz czcionkę tekstu rodzaj/styl/rozmiar
        label.setIconTextGap(10); // ustanawiasz odległość mędzy tekstem a ikoną ( moga być ujemne, wtedy zbliża je bardziej)
        label.setBackground(Color.yellow); // ustawiasz kolor tła
        label.setOpaque(true); // ustawiasz, że kolor tła ma być wyświetlany
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP); // ustawiasz gdzie wertykalnie ma się znajdować zawartość label TOP/CENTER/RIGHT
        label.setHorizontalAlignment(JLabel.CENTER); // ustawiasz horyzontalnie gdzie się ma zjadować zawartość, jak wyżej
        //label.setBounds(50,50,250,250); // ustawiasz granice etykiety, najpierw oś X, oś y, szerokość, wysokość


        JFrame frame = new JFrame();
        frame.setTitle("Próbna Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null); // tutaj ustawiasz żeby etykieta nie wypełniała automatycznie całego okna ale za to musisz to ustawić recznie w label
        frame.setSize(440,440);
        frame.add(label); // PAMIĘTAJ by dodać etykiete/label do frame!!!!
        frame.pack(); // autmatycznie dopasowuje etykietę, tak by okazać okno, w której etykieta się idealnie mieści, okno opakowuje etykietę
        // aby pack zadziałało trzeba najpierw dodać wszystkie komponenty a później tą metodę

        frame.setVisible(true);

         */
        // JPanel = a GUI component that functions as a container to hold other components
        //panel pozwala przechowywac obiekty w danym miejscu w ramach frame
        /*
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(5,5,150,150);
        //redPanel.setLayout(new BorderLayout());
        redPanel.setLayout(null);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.yellow);
        yellowPanel.setBounds(155,5,150,150);
        //yellowPanel.setLayout(new BorderLayout());
        yellowPanel.setLayout(null);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(5,155,300,150);
        //bluePanel.setLayout(new BorderLayout()); // normalnie panele używają coś co się nazwa flat layout, tutaj zmieniasz tak, by funkcjonowały jak frame, które uzywają border layout
        bluePanel.setLayout(null); // ustawiasz żeby nie było żadnego layout manegera (opcja)

        ImageIcon imageIcon = new ImageIcon("Avatar próbny.jpg");

        JLabel label = new JLabel();
        label.setText("Hello!");
        label.setFont(new Font("MV Boli",Font.BOLD,20));
        label.setForeground(Color.white);
        //label.setIcon(imageIcon);
        label.setVerticalAlignment(JLabel.TOP); // ustawiasz by komponent(naklejka) był do u góry ustawiany (lub Center/bottom)/ używa się z border layout
        label.setHorizontalAlignment(JLabel.LEFT); // ustawiasz by naklejka była do prawej dociągnięta (lub center/left) / używa się z border layout
        label.setBounds(0,0,100,100); // jesli nie używasz layout manegera w panelach, to musisz ustawić granice tego label

        JFrame frame = new JFrame();
        frame.setTitle("Próbne panele");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // tutaj ustawiasz żeby etykieta nie wypełniała automatycznie całego okna ale za to musisz to ustawić recznie w label
        frame.setSize(700,700);
        frame.add(redPanel); // UWAGA nie zapomnij dodać tego!
        frame.add(yellowPanel);
        frame.add(bluePanel);
        bluePanel.add(label);


        frame.setVisible(true);

         */
        // JButton = a button that performs an action when clicked on
       // new MyFrame2(); // jest  w klasie MyFrame2 wszystko

        // Layout Manager = Defines the natural layout for components within a container
        // 3 common managers
        // BorderLayout = 	A BorderLayout places components in five areas: NORTH,SOUTH,WEST,EAST,CENTER.
        //					All extra space is placed in the center area.
        /*
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10)); // normalnie tego nie trzeba, ale jeśli z nowymi panelami to wtedy tak??
        // w nawiasie powyżej ustawiasz przerwę pomiędzy poszczególnymi panelami/elementami
        frame.setSize(500,500);
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.red);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.green);

        panel1.setPreferredSize(new Dimension(100,100)); // ??? ustawianie jakich rozmiarów ma się trzymac jesli może
        panel2.setPreferredSize(new Dimension(150,100));
        panel3.setPreferredSize(new Dimension(150,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));

        // ------------------sub panel do 2 --------------------
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();

        panel2.setLayout(new BorderLayout());

        panel6.setBackground(Color.black);
        panel7.setBackground(Color.lightGray);
        panel8.setBackground(Color.darkGray);
        panel9.setBackground(Color.gray);
        panel10.setBackground(Color.cyan);

        panel6.setPreferredSize(new Dimension(50,50));
        panel7.setPreferredSize(new Dimension(50,50));
        panel8.setPreferredSize(new Dimension(50,50));
        panel9.setPreferredSize(new Dimension(50,50));
        panel10.setPreferredSize(new Dimension(50,50));

        panel2.add(panel6, BorderLayout.NORTH);
        panel2.add(panel7, BorderLayout.EAST);
        panel2.add(panel8, BorderLayout.WEST);
        panel2.add(panel9, BorderLayout.SOUTH);
        panel2.add(panel10, BorderLayout.CENTER);


        // ---------------- koniec sub panel -----------------------------

        frame.add(panel1, BorderLayout.NORTH); // dodajesz stworzony panel do granic "północnych" frame
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.EAST);
        frame.add(panel4, BorderLayout.WEST);
        frame.add(panel5, BorderLayout.SOUTH);

         */

        // Layout Manager = Defines the natural layout for components within a container
        // FlowLayout = 	places components in a row, sized at their preferred size.
        //					If the horizontal space in the container is too small,
        //					the FlowLayout class uses the next available row.
        /*JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); //domyślnie frame używają border layout, ale tu zmieniasz na flow (pływający)
        // w nawiasie możesz ustawiać jak się będą zachowywać, czy do prawej, do lewej, centrum?, później liczby to przerwy między obiektami

        JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(250,250));
            panel.setLayout(new FlowLayout()); //  panele używają właściwie domyślnie flow layout
            panel.setBackground(Color.lightGray);

         */

        /*frame.add(new JButton("1")); //  skrótowy sposób stworzenia przycisku/ zamiast przywoływania wszystkich najpierw tworzysz już tutaj
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("9"));
        frame.add(new JButton("10"));
        
         */
        /*
        panel.add(new JButton("1")); 
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("9"));
        panel.add(new JButton("10"));

        frame.add(panel);
        frame.setVisible(true);

         */
        // GridLayout = 	places components in a grid of cells.
        //					Each component takes all the available space within its cell,
        //					and each cell is the same size.
        /*

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(3,3,5,5)); //tutaj ustawiasz Grid Layout, który automatycznie dopasowuje by wypełnić całą przestrzeń
        // ustawiasz lość kolumn, szeregów, później odległości w pixelach od przycisków

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));


        frame.setVisible(true);

         */
        // JLayeredPane = Swing container that provides a
        //				third dimension for positioning components
        //				ex. depth, Z-index
        /*
        JLabel jLabel1 = new JLabel();
        jLabel1.setOpaque(true);
        jLabel1.setBounds(50,50,150,150);
        jLabel1.setBackground(Color.red);

        JLabel jLabel2 = new JLabel();
        jLabel2.setOpaque(true);
        jLabel2.setBounds(100,100,150,150);
        jLabel2.setBackground(Color.blue);

        JLabel jLabel3 = new JLabel();
        jLabel3.setOpaque(true);
        jLabel3.setBounds(150,150,150,150);
        jLabel3.setBackground(Color.green);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5,5,400,400);

        //layeredPane.add(jLabel1);
        //layeredPane.add(jLabel2);
        //layeredPane.add(jLabel3);
        //layeredPane.add(jLabel1, JLayeredPane.DEFAULT_LAYER);
        //layeredPane.add(jLabel2, JLayeredPane.DEFAULT_LAYER);
        //layeredPane.add(jLabel3, JLayeredPane.DRAG_LAYER); //ta metoda pozwala i określić, który obiekt na której warstwie ma być, bardziej z przodu czy z tyłu
        layeredPane.add(jLabel1, Integer.valueOf(0));
        layeredPane.add(jLabel2, Integer.valueOf(2));
        layeredPane.add(jLabel3, Integer.valueOf(1)); // tutaj określasz numer warstwy

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.add(layeredPane);


        frame.setVisible(true);

         */

        //Otwieranie nowego kna zawarłem w osobnym projekcie

        // JOptionPane = okno dialogowe informujące użytkownika o czymś lub rzadające podania jakiejś wartości
        /*

        //JOptionPane.showMessageDialog(null,"Rozwijamy się a co!","Wiadomość od losu!",JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Nie damy się, a co!","Wiadomość od losu!",JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null,"No janse, że tak, co nie?","Wiadomość od losu!",JOptionPane.QUESTION_MESSAGE);
       //JOptionPane.showMessageDialog(null, "ALARM!ALARM!ALARM!", "Wiadomość od losu!", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Się wykobzałem!","Wiadomość od losu!",JOptionPane.ERROR_MESSAGE);

        //JOptionPane.showConfirmDialog(null,"Dajemy radę?","Pytanie dnia",JOptionPane.YES_NO_CANCEL_OPTION);
        //System.out.println(JOptionPane.showConfirmDialog(null,"Dajemy radę?","Pytanie dnia",JOptionPane.YES_NO_CANCEL_OPTION));
        // Tak zwróci zero, Nie zwróci 1, Cancel zwróci 2, krzyżeyk zwróci -1
        //int answer = JOptionPane.showConfirmDialog(null,"Dajemy radę?","Pytanie dnia",JOptionPane.YES_NO_CANCEL_OPTION);
        // jako int możesz używać z opcją switch albo if i dopisać różne rekacje na odpowiedzi
        //String name = JOptionPane.showInputDialog("Jak się nazywasz: "); // okno, które pozwala wpisać informajcę w odpowiedzi na pytanie na przykład
        //System.out.println("No siema " + name);

        //Okno dialogowe łączy w sobie cechy wymienionych wyżej
        ImageIcon icon = new ImageIcon("Avatar próbny.jpg");
        String[] responses = {"Dobrze!", "Lepiej", "Coraz lepiej"};
        JOptionPane.showOptionDialog(null,"Jest dobrze?","Odpowiedź",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,icon,responses, 0);

         */

        // JTextField = A GUI textbox component that can be used to add, set, or get text
        /*


        Ramka ramka = new Ramka();
        Wszystko jest w klasie Ramka
         */

        // JCheckBox = A GUI component that can be selected or deselected
        //new MyFrame3();
        // wszystko jest wklasie myFrame3

        // JRadioButton = One or more buttons in a grouping in which only 1 may be selected per group
        //new MyFrame4();
        //wszystko jest w klasie MYFrame4

        // JComboBox = A component that combines a button or editable field and a drop-down list
        //new MyFrame5();
        // wszystko jest w klasie MyFrame5

        // JSlider =  GUI component that lets user enter a value
        //    by using an adjustable sliding knob on a track

        //SliderDemo sliderDemo = new SliderDemo();
        // wszystko zawarte w klasie SliderDemo

        //JProgressBar pomaga pokazać w formie GIU postępujący proces
        //ProgressBarDemo progressBarDemo = new ProgressBarDemo();
        // wszystko zawarte w klasie ProgressBarDemo

        //MenuDemo menuDemo = new MenuDemo();
        // tworzenie listwe z menu i wyborów wewnątrz menu
        // wszystko w klasie MenuDemo

        // JFileChooser = A GUI mechanism that let's a user choose a file (helpful for opening or saving files)
        //new SelectFileDemo();
        // wszystko w klasie SelectFileDemo

        // JColorChooser = A GUI mechanism that let's a user choose a color
        //new ColorChooserDemo();
        // wszystko w klasie ColorChooserDemo

        //new KeyDemo();
        //KeyListener - zczytuje dane z klawiatury
        // wszystko zawarte w klasie KeyDemo

        //new MouseDemo();
        //pozwala wpisać reakcję na działania myszki
        // wszystko w klasie MouseDemo

        //DragAndDrop dragAndDrop = new DragAndDrop();
        //przesuwanie obiektu myszką
        // wszystko w klasach DragAndDrop i DragPanel

        // Key Bindings = 	bind an Action to a KeyStroke
        //					don't require you to click a component to give it focus
        //					all Swing components use Key Bindings
        //					increased flexibility compared to KeyListeners
        //					can assign key strokes to individual Swing components
        //					more difficult to utilize and set up :(

        //KeyBindingDemo keyBindingDemo =  new KeyBindingDemo();

        //Grafiki 2D i rysowanie ich
        //new Grafiki2D();
        // wszystko w klasach Grafiki2D oraz PanelGrafiki2D

        //new Animation();
        // proste animacje 2D, wszystko w klasie Animation oraz AnimationPanel

        // Generics, pozwala używać tej samej metody dla różnego rodzaje danych referencyjnych (Więc trzeba używać Wraper class)
        /*
        Integer[] intArray = {1, 2, 3, 4, 5}; // różne wartości w wrapper clas
        Double[] doubleArray = {5.5, 4.4, 3.3, 2.2, 1.1};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"B","Y","E"};

        //displayArray(intArray); // przywołanie metody generycznej i którą array wysyłasz
        //displayArray(doubleArray);
        //displayArray(charArray);
        //displayArray(stringArray);

        System.out.println(getFirst(intArray));
        System.out.println(getFirst(doubleArray));
        System.out.println(getFirst(charArray));
        System.out.println(getFirst(stringArray));
    }
    public static <T> void displayArray(T[] array) { // trzeba dodać nazwę w <> zwykle T, by oznaczyć jako metodę generyczną
        for(T x : array) { // dla każdego generycznego X array, czyli wyświetl w lini
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static <T> T getFirst(T[] array) { // metoda, która zwraca coś więc nie void, zaznaczasz, że przychodzi generyczna tabela i nazywasz ją array
        return array[0]; // chcesz zwrócić indeks 0 z tabeli, czyli pierwszą wartość
    }

         */


        /*MyIntegerClass myInt = new MyIntegerClass(1);
        MyDoubleClass myDouble = new MyDoubleClass(1.25);
        MyCharacterClass myChar = new MyCharacterClass ('@');
        MyStringClass myString = new MyStringClass("Hello");
        // To jest długa metoda z tworzeniem 4 klas,
        System.out.println(myInt.getValue());
        System.out.println(myDouble.getValue());
        System.out.println(myChar.getValue());
        System.out.println(myString.getValue());

         */
        // tutaj generic class, wysyłasz do jednej generycznej klasy wszystko
        /*MyGenericClass <Integer, Integer> myInt = new MyGenericClass <>(1,5); // trzeba zadeklarować jaki rodzaj danych wysyłach dlatego <>
        MyGenericClass <Double, Double> myDouble = new MyGenericClass <>(1.25,9.01);
        MyGenericClass <Character,Character> myChar = new MyGenericClass <> ('@','#');
        MyGenericClass <String,Character> myString = new MyGenericClass <>("Hello",'!');

        System.out.println(myInt.getValue());
        System.out.println(myDouble.getValue());
        System.out.println(myChar.getValue());
        System.out.println(myString.getValue());

        //bounded types = 	you can create the objects of a generic class to have data
        //					of specific derived types ex.Number to jest dodanie np. extends Numbers patrz MyGenericClass

         */

        // method chaining =  a common syntax for invoking multiple method calls in OOP
        //      condense code into less lines
        /*
        String name = "    Seweryn ";
        //name = name.concat("Stawiarski");
        //name = name.toUpperCase();
        //name =  name.trim();

        name = name.concat("Stawiarski").toUpperCase().trim();


        System.out.println(name);

         */
        //enum = enumerated (ordered listing of items in a collection)
        //grouping of constants that behave similarly to objects
        //new Enum();
        // wszystko w klasie Enum, która nie działa z jakichś nienzanych mi powodów

        // HashMap implements the Map interface (need import)
        // HashMap is similar to ArrayList, but with key-value pairs
        // stores objects, need to use Wrapper Class
        // ex: (name,email),(username,userID),(country,capital)
        /*
        HashMap<String,String> countries = new HashMap<>();
        // dodajesz key/klucz i przypisaną do niego wartość
        countries.put("USA" , "Washington");
        countries.put("Russia" , "Moscow");
        countries.put("Poland", "Warsaw");
        countries.put("Chech" , "Praga");

        //countries.remove("Russia");
        //System.out.println(countries.get("Poland"));
        //countries.clear();
        //countries.replace("Poland","Wrocław");
        //System.out.println(countries.containsKey("China")); // boolean pokazujący czy dany klucz jest w HashMap
        //System.out.println(countries.containsValue("Praga")); // sprawdza czy dana wartość jest w HashMap
        //System.out.println(countries);
        for (String i : countries.keySet()) { // key set sprawi, że dla każdej wartości key coś się wydarzy
            System.out.print(i + "\t" + "= "); // "\t" to oznaczenie tab,
            System.out.println(countries.get(i)); // tak sprawisz, by pokazało przypisane do kluczy wartości
        }

         */
        // Recursion = the process in which a method calls itself continuously
        // A method that calls itself is called a recursive method
        /*
        System.out.println("Jak wiele razy mam powtarzać Hello? :/  ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        HelloWorld(number);
    }
    static void HelloWorld (int n) {
        if (n>0) {
            System.out.println("Hello World!" + n);
            n--;
            HelloWorld(n); // tutaj wydajesz polecenie by powtarzała się z przesłaną wartością n
        }

         */
        // liczenie kroków
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jak daleko chcesz zajść(kroki)?: ");
        int distance = scanner.nextInt();

        takeAWalk(0, distance);
    }
    static void takeAWalk (int i, int distance) {
        if (i<distance) {
            i++;
            System.out.println("Zrobiłeś krok numer: " + i);
            takeAWalk(i,distance); // przywołujesz metodę by się powtarza aż i dojdzie do liczby distance i wtedy się zatrzyma
        }
        else {
            System.out.println("No i jesteśmy na miejscu!");
        }

         */

        // Custom exceptions
        // tworzą wyjątki określone przez użytkownika
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your age?: ");
        int age = scanner.nextInt();

        try {
            checkAge(age);
        }
        catch (Exception e) {
            System.out.println("A problem occured: " + e);
        }
    }
    static void checkAge (int age) throws AgeException { // tworzysz metodę, która wysyła exception do stworzonej wcześniej klasy osobnej AgeException
        if (age<18) {
            throw new AgeException("\n"+"You must be 18+ to sign up");
        }
        else {
            System.out.println("You have just signed up");
        }

         */
        // tworzenie bezimiennych obiektów, co skraca czas przy dodawaniu wielu obiektów, na przykład 50 label przy talii kart

        /*JFrame frame = new JFrame();
        ArrayList<JLabel> deck = new ArrayList<JLabel>();

        deck.add(new JLabel(new ImageIcon("iconmew.jpg")));// to są normalnie 3 linijki kodu, najpierw dodajesz nowa JaLabel, później Icon i dodajesz do deck
        deck.add(new JLabel(new ImageIcon("iconpikachu.jpg")));



        // gdybyś miał ponumerowane pliki w jednym folderze to przy
        //for(int i =1;i<=52;i++) {
          //  deck.add(new JLabel(new ImageIcon("src\\cards\\"+i+".png")));
            //frame.add(deck.get(i-1)); // dał minus jeden bo zaczynał i od 1 , a u niego karta 0 to był tył karty


        frame.add(deck.get(0)); // dodajesz do frame label o indeksie 0 z listy labels, którą wyżej stworzyłeś
        frame.add(deck.get(1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,440);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

         */


        /* inner class = 	A class inside of another class.
							useful if a class should be limited in scope.
							usually private, but not necessary
							helps group classes that belong together
							extremely useful for listeners for specific events
							precursor for anonymous inner classes
		*/
        /*Outside out = new Outside();
        Outside.Inside in = out.new Inside();

        in.Greetings(); // przywołanie metody z klasy inside, która jest wewnątrz Outside

         */

        /*anonymous class = an inner class without a name
          only a single object is created from one
         The object may have “extras” or "changes"
        and no need to create a separate innerclass
        when it only need it once.
        Helps us to avoid cluttering code with a class name

        Syntax is similar to a constructor,
         except that there is also a class definition
         within a block of code.
         GREAT FOR LISTENERS
  */
        /*Greetings greetings = new Greetings() {
            @Override
            public void Welcome() {
                System.out.println("No jak leci jak jak jak!!!");
            }};
        Greetings greetings1 = new Greetings();

        greetings.Welcome();
        greetings1.Welcome(); //tutaj wyświetla wiadomość z osobnej clasy ponieważ, nie nadpisałeś nić przy tworzeniu tego obiektu greetings1

         */
        // przykładowe użycie
        //MyFrame6 myFrame6 = new MyFrame6(); // wszystko w klasie MyFrame6

        /* lambda expression = 	feature for Java 8 and above
         * 						also known as an anonymous method
         * 						a shorter way to write anonymous classes with only one method
         *						need to use a functional interface or use a pre-defined functional interface
         *						they contain only one abstract method
         *						ex. ActionListener, Runnable, (user-defined)
         *						A Lambda expression can be used in any place where a functional interface is required
         *						How to use a lambda expression:
         *						(arguments) -> {statement/s} !!!!!
         */
        /*String name = "Seweryn";
        char symbol = '!';
        MyInterface myInterface = (x,y) -> { // kiedy wysyłasz do konstruktora możesz zmieniać nazwy, a lamda jest przecież takim skrótem
            System.out.println("No witam witam, tutaj lambda!");
            System.out.println("Jak się miewasz?  " + x + y);
        };
        MyInterface myInterface1 = (x,y) -> {
            System.out.println("Hello " + x +y);
        }; // do tego samego konstruktora wysyłasz ale te same zmienne, ale konstruktor co innego wykonuje
        myInterface1.message(name,symbol);

         */
        // przykład użycia lambda!!!!!
        //MyFrame7 myFrame7 = new MyFrame7();

        //Serialization = 	The process of converting an object into a byte stream.
        //					Persists (saves the state) the object after program exits
        //					This byte stream can be saved as a file or sent over a network
        //					Byte stream can be saved as a file (.ser) which is platform independent
        //					(Think of this as if you're saving a file with the object's information)
        //					Steps to Serialize
        //					---------------------------------------------------------------
        //					1. Your class should implement Serializable interface
        //					2. add import java.io.Serializable;
        //					3. FileOutputStream fileOut = new FileOutputStream(file path)
        //					4. ObjectOutputStream out = new ObjectOutputStream(fileOut);
        //					5. out.writeObject(objectName)
        //					6. out.close(); fileOut.close();
        //					------------------------------------------------------------

        /*User user = new User();

        user.name = "BLa bla bla";
        user.password = "Nope";
        user.message();

        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        System.out.println("Object was saved!");
        out.close();
        fileOut.close();

         */
        //Deserialization = 	The reverse process of converting a byte stream into an object.
        //					(Think of this as if you're loading a saved file)
        //					Steps to Deserialize
        //					---------------------------------------------------------------
        //					1. Your class should implement Serializable interface
        //					2. add import java.io.Serializable;
        //					3. FileInputStream fileIn = new FileInputStream(file path);
        //					4. ObjectInputStream in = new ObjectInputStream(fileIn);
        //					5. objectNam = (Class) in.readObject();
        //					6. in.close(); fileIn.close();
        //					--------------------------------------------------------------- W projekcie Deserializer
        // important notes	1. children classes of a parent class that implements Serializable will do so as well
        //					2. static fields are not serialized (they belong to the class, not an individual object)
        //					3. Fields declared as "transient" aren't serialized, they're ignored
        //					4. the class's definition ("class file") itself is not recorded, cast it as the object type
        //					5. serialVersionUID is a unique version ID
        //SerialVersionUID =	serialVersionUID is a unique ID that functions like a version #
        //					verifies that the sender and receiver of a serialized object,
        //					have loaded classes for that object that are compatible
        //					Ensures object will be compatible between machines
        //					Number must match. otherwise this will cause a InvalidClassException
        //					A SerialVersionUID will be calculated based on class properties, members, etc.
        //					A serializable class can declare its own serialVersionUID explicitly (recommended)

        // Projekty Serialization i Desrialization, niestety nie działają... ?????


        // Timer = 		A facility for threads to schedule tasks
        //				for future execution in a background thread
        // TimerTask = 	A task that can be scheduled for one-time
        //				or repeated execution by a Timer
        /*
        Timer timer = new Timer(); // ustanawiasz nstancje

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Wykonałem zadanie!");
            }
        };

         */

        /*TimerTask task = new TimerTask() { // określasz zadanie do wykonania po timer
            int counter = 10;
            @Override
            public void run() {
                if (counter>0) {
                    System.out.println(counter + " seconds!");
                    counter--;
                }
                else {
                    System.out.println("Happy New Year!");
                    timer.cancel();
                }
            }
        };
        //timer.schedule(task, 2000);
        Calendar date = Calendar.getInstance(); // tworzysz kalendarz
        date.set(Calendar.YEAR,2022); // ustanawiasz jego datę
        date.set(Calendar.MONTH,Calendar.FEBRUARY);
        date.set(Calendar.DAY_OF_MONTH,3);
        date.set(Calendar.HOUR_OF_DAY,12);
        date.set(Calendar.MINUTE,59);
        date.set(Calendar.SECOND,0);
        date.set(Calendar.MILLISECOND,0);

        //timer.schedule(task,date.getTime());
        //timer.scheduleAtFixedRate(task,0,1000);
        timer.scheduleAtFixedRate(task,date.getTime(),1000); // rozpocznie task o określonej w kalendarzu godzinie

         */


        /*
    	thread =	A thread of execution in a program (kind of like a virtual CPU)
    				The JVM allows an application to have multiple threads running concurrently
    				Each thread can execute parts of you code in parallel with the main thread
    				Each thread has a priority.
    				Threads with higher priority are executed in preference compared to threads with a lower priority
    			    The Java Virtual Machine continues to execute threads until either of the following occurs
    					1. The exit method of class Runtime has been called
    					2. All user threads have died
    				When a JVM starts up, there is a thread which calls the main method
    				This thread is called “main”
    				Daemon thread is a low priority thread that runs in background to perform tasks such as garbage collection
				JVM terminates itself when all user threads (non-daemon threads) finish their execution
    	 */
        //System.out.println(Thread.activeCount());  // pokazuje ile masz wątków otwartych
        //Thread.currentThread().setName("WOOOOOW"); // ustawiasz nazwę danego wątku
        //System.out.println(Thread.currentThread().getName()); // pokazuje nazwę obecnego wątku
        //Thread.currentThread().setPriority(10);
        //System.out.println(Thread.currentThread().getPriority()); // pokazuje priorytet na skali od 1 do 10, 10 najwyższy priorytet
        //System.out.println(Thread.currentThread().isAlive()); // pkazuje czy wątek działa obecnie

        /*for (int i=3 ; i>0 ; i--) { // pamiętaj, że w for rozdzielasz ;
            System.out.println(i);
            Thread.sleep(1000); // co sekundę usypia thread i budzi aż do zamknięcia.
        }
        System.out.println("Hello!");

         */
       /* MyThread thread2 = new MyThread();
        thread2.setDaemon(true); // ustawia jako daemon wątek, czyli działający w tle
        thread2.start(); // uruchamiasz inny wątek, nie uruchamia się automatycznie/ kiedy uruchomisz, wykona swoje metody

        //System.out.println(thread2.isAlive());
        //thread2.setName("Wątek numer 2");
        //System.out.println(thread2.getName());
        //thread2.setPriority(2);
        //System.out.println(thread2.getPriority());
        //System.out.println(Thread.activeCount());
        System.out.println(thread2.isDaemon());
                */
        /*
        //Multithreating = przypisywanie osobnych wątków do niezależnych operacji, wyjątki jednej operacji nie zakłócą działania pozostałych
        MyMultiThread thread1 = new MyMultiThread(); // pierwsza metoda tworzenia thread, sobna clasa extends Thread
        // druga metoda, csobna classa, implements interfejs Runnable i wysyłasz do classy Thread
        // to jest o tyle lepsze, że pozwala ci inną class dopisać jeszcze, bo class może mięc tylko jedną parent
        // klasy MyMultiThread i MyRunnable

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);

        //thread1.setDaemon(true); jeśli zamienisz na daemon, to java wyłączy wszystko jeśli któryś z thread users się zamknie, n. jeśli wyskoczy błąd, to daemon zamknie, mimo że tam się nic nie dzieje
        //thread2.setDaemon(true);

        thread1.start();
        //thread1.join(2000); // jeśli nie wpiszesz czasu, thread 2 będzie czekał aż, thread 1 skończy, jeśli wpiszesz to określasz po jakim czasie thread 2 ma się uruchomić od startu thread 1
        thread2.start();
        */

        //importowanie package
        //Toolbox toolbox = new Toolbox();

        //compile and run Java with Command Prompt
        /*
        1. Make sure you have a Java JDK installed (we did this in lesson #1)
        2. (optional) use a text editor and save a file as .java
        3. Open Command Prompt (Windows) or Terminal (Mac) on your computer
        4. set path=C:\Program Files\Java\jdk-14.0.1\bin (where JDK is located)
        5. cd C:\Users\Myname\Desktop (or wherever you java file is)
        6. javac HelloWorld.java (to compile a .java file to .class file)
        7. java HelloWorld (to run a .class file, it's portable)

         */
        /*
        Create an executable jar with IntelliJ
        -----------------------------------------
                1. File , Project Structure , Artifacts , (+) , JAR ,  jar from module with dependencies
        2. Main Class: select the class containing your main method
        3. OK
        3. Change output directory to where you want this JAR saved to
        6. Apply , OK
        7. Build (top of window in IntelliJ) , Build Artifacts , Build
        If you want an icon, convert an image to a .ico file
        ----------------------------------------------------
                1. https://icoconvert.com/ (this is a decent site)
        2. Choose your image (file type my vary)
        3. Upload
        4. Convert to ICO
        5. Download your icon
        Use Launch4j to create an .exe with custom icon
        ----------------------------------------------
                1. Install Launch4j http://launch4j.sourceforge.net/
        2. Output file: browse for the output destination and name your file ending with .exe
        3. Jar: browse for where you saved your jar or executable jar file
        4. (Optional) Icon: browse for your custom icon (must be .ico)
        5. navigate to JRE tab
        6. Bundled JRE path: Browse for location of your jdk (Example C:\Program Files\Java\jdk-14.0.1)
        7. At the top of window, click the Build Wrapper (gear icon)
        8. name and save the Lauch4j config file where you want
        9. Your application.exe should be saved to your output file location (no longer need previous files)

         */


        // *******************************************************
        // LinkedList =  Nodes are in 2 parts (data + address)
        //                        Nodes are in non-consecutive memory locations
        //                        Elements are linked using pointers
        //    advantages?
        //    1. Dynamic Data Structure (allocates needed memory while running)
        //    2. Insertion and Deletion of Nodes is easy. O(1)
        //    3. No/Low memory waste
        //    disadvantages?
        //    1. Greater memory usage (additional pointer)
        //    2. No random access of elements (no index [i])
        //    3. Accessing/searching elements is more time consuming. O(n)
        //    uses?
        //    1. implement Stacks/Queues
        //    2. GPS navigation
        //    3. music playlist
        // *******************************************************
        /*
        LinkedList<String> linkedList = new LinkedList<String>();

        //linkedList.push("A"); //dodajesz kolejne elemnty, ghdzie pierwszy wpisany jest jakby ogonem
        //linkedList.push("B");
        //linkedList.push("C");
        //linkedList.push("D");
        //linkedList.push("F");

        //linkedList.pop(); // usuwasz pierwszy elemnt z listy, czyli tutaj ostatni dodany

        linkedList.offer("A"); //dodajesz kolejne elemnty, ale tutaj zachowujesz kolejność
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");

        //linkedList.poll(); // usuwasz pierwsz z listy, czyli tutaj pierwszy dodany

        linkedList.add(4,"E"); // dodajesz w danym miejscu wartość
        //linkedList.remove("E"); // usuwasz element dany z listy

        //System.out.println(linkedList.indexOf("D")); // poszukujesz indexu danego obiektu
        System.out.println(linkedList.peekFirst()); // zwraca pierwszą wartość z listy
        System.out.println(linkedList.peekLast()); // zwraca ostatni elemnt z listy

        linkedList.addFirst("Z"); // dodajesz na początku listy
        linkedList.addLast("G"); // dodajesz na końcu listy

        String first = linkedList.removeFirst(); // usuwasz z listy pierwszy obiekt i zapisujesz jako osobny poza listą
        String last = linkedList.removeLast(); // usuwasz z listy ostatno obiekt i zapisujesz jako osobny

        System.out.println(linkedList);

         */

        List<String> names = new ArrayList<>();

        names.add("Wieczysław");
        names.add("Wolodymir");
        names.add("Wladymir Wlodymirowicz");
        names.add("Zenek");
        names.add("Wolodja");


        /*names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

         */

        names.sort((o1,o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(names);

        /*List<String> modifiedNames = new ArrayList<>();
        for (String name : names) {
            Random random = new Random();
            String modifiedName = name+random.nextInt(11);
            modifiedNames.add(modifiedName);
        }

         */
        List<String> modifiedNames = new ArrayList<>();
        for (String name : names) {
            /*String modifiedName = modify(name, new Modifier() {
                public String modify(String s) {
                    Random random = new Random();
                    return name+random.nextInt(11);
                }
            });

             */
            String modifiedName = modify(name, s -> s + new Random().nextInt(11)); //wyrażenie lamda do funkcji powyżej z użyciem metody modify, która wykorzystuje interefejs abstrakcyjny  Modifier
            modifiedNames.add(modifiedName);
        }
        System.out.println(modifiedNames);
     }

     private static String modify(String string, Modifier modifier) {
       return modifier.modify(string);
     };
}
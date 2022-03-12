package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Przystanek {
    int lp;
    String nazwa;
    String droga;
    double kilometraż;
    double lat;
    double lon;

public String toString(){
    return "Przystanek nr: " + lp +
            " Nazwa: " + nazwa +
            " Droga: " + droga +
            " Kilometraż: " + kilometraż +
            " Lat: " + lat +
            " Lon: " + lon;
}
public String getNazwa(){
    return nazwa;
}
public double getKilometraz() { return kilometraż; }


    public static void main(String[] args) throws Exception {
        ArrayList<Przystanek> Przystanki = new ArrayList<>();
        CSVReader reader = new CSVReader("przystanki.csv", ";", true);

        while (reader.next()) {
            Przystanek p = new Przystanek();
            p.lp = reader.getInt("Lp");
            p.nazwa = reader.get("Nazwa");
            p.droga = reader.get("Droga");
            p.kilometraż = reader.getDouble("Kilometraż");
            p.lat = reader.getDouble("Lat");
            p.lon = reader.getDouble("Lon");


            Przystanki.add(p);
        }

        //a) Wypisz wszystkie przystanki przy drogach, których symbol ma pierwszą literę P
        System.out.println("-------a)--------");

        Przystanki.stream()
                .filter(Przystanek -> Przystanek.droga.contains("P"))
                .forEach(Przystanek -> System.out.println(Przystanek.droga));


        //b) Wypisz wszystkie przystanki mieszczące się wewnątrz obszaru (50.54 21.63) - (50.62 21.73) posortowane według nazwy
        System.out.println("-------b)--------");

        Przystanki.stream()
                .filter(Przystanek -> Przystanek.lat > 50.54 && Przystanek.lat < 50.62 && Przystanek.lon > 21.63 && Przystanek.lon < 21.73)
                .sorted(Comparator.comparing(Przystanek::getNazwa))
                .forEach(Przystanek -> System.out.println(Przystanek.toString()));

        //c) Wypisz wszystkie przystanki przy ulicy Warszawskiej posortowane według kilometrażu.
        // Uwaga 2+210 oznacza 2.210 km od ustalonego początku drogi. Patrz Pikietaż
        //dodalem replace w CSVReader getDouble
        System.out.println("-------c)--------");

        Przystanki.stream().filter(Przystanek -> Przystanek.nazwa.contains("Warszawska"))
                .sorted(Comparator.comparing(Przystanek::getKilometraz))
                .forEach(Przystanek -> System.out.println(Przystanek.toString()));

        Map<Przystanek, Float> przystanekKilometraz;




        //d) Wyznacz współrzędne prostokąta zawierającego wszystkie przystanki
        System.out.println("-------d)--------");

        double latMax = 0;
        double latMin = 0;
        double lonMax = 0;
        double lonMin = 0;


        latMax = Przystanki.stream().max((Przystanek a, Przystanek b) -> a.lat > b.lat ? 1 : -1).get().lat;
        latMin = Przystanki.stream().min((Przystanek a, Przystanek b) -> a.lat > b.lat ? 1 : -1).get().lat;
        lonMax = Przystanki.stream().max((Przystanek a, Przystanek b) -> a.lon > b.lon ? 1 : -1).get().lon;
        lonMin = Przystanki.stream().min((Przystanek a, Przystanek b) -> a.lon > b.lon ? 1 : -1).get().lon;

        System.out.println("|||Wspolrzedne prostokata|||\n" + latMax + ", " + lonMax + "\n" + latMax + ", " + lonMin + "\n" +
                + latMin + ", " + lonMax + "\n" + latMin + ", " + lonMin );

    }

}

import OSPRNG.TriangularRNG;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main6 {

    public static void main(String[] args) {

        TriangularRNG trojuholnikFast = new TriangularRNG(40d, 50d, 75d);
        TriangularRNG trojuholnikFur = new TriangularRNG(35d, 52d, 80d);

        int pocetIteracii = 100000;


        double priemerObePrve = 0;
        int bodyFastViacAkoFurious = 0;

        for (int i = 0; i < pocetIteracii; i++) {
            int prveBody = 0;
            int druheBody = 0;
            for (int j = 0; j < 15; j++) {
                HashMap<Double, String> poradiePretekov = new HashMap<>();
                for (int k = 0; k < 5; k++) {
                    double rychlostFast1 = trojuholnikFast.sample();
                    double rychlostFur1 = trojuholnikFur.sample();

                    poradiePretekov.put(rychlostFast1, "fast");
                    poradiePretekov.put(rychlostFur1, "fur");
                }

                Double key = Collections.min(poradiePretekov.keySet());
                String prvy = poradiePretekov.get(key);
                if (prvy.equals("fast")) {
                    prveBody += 10;
                } else {
                    druheBody += 10;
                }

                poradiePretekov.remove(key);

                Double key2 = Collections.min(poradiePretekov.keySet());
                String druhy = poradiePretekov.get(key2);

                if (druhy.equals("fast")) {
                    prveBody += 9;
                } else {
                    druheBody += 9;
                }
                poradiePretekov.remove(key2);
                if ( prvy.equals("fast") && druhy.equals("fast")) {
                    priemerObePrve++;
                }
                int body = 8;
                for (int k = 0; k < 8; k++) {

                    key = Collections.min(poradiePretekov.keySet());
                    String dalsi = poradiePretekov.get(key);
                    if (dalsi.equals("fast")) {
                        prveBody += body;
                    } else {
                        druheBody += body;
                    }
                    body--;
                    poradiePretekov.remove(key);

                }
            }
            if (prveBody > druheBody) {
                bodyFastViacAkoFurious++;
            }
        }

        System.out.println("Priemer oba fast: " + priemerObePrve / pocetIteracii /15 * 100);
        System.out.println("Pravdepodobnost že FAST bude mat vyssi bodovy zisk : " + (double)bodyFastViacAkoFurious / pocetIteracii * 100);
    }
}
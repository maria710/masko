import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Main1 {


    public static void main(String[] args) {


        double vytlacok = 0.15;
        int pocetPredanych = 0;
        int pocetIteracii = 100000;
        double casMedziPredajom = 2.7;
        TriangularRNG triangularRNG = new TriangularRNG(0.25, 0.6, 0.95);
        UniformContinuousRNG uniformContinuousRNG = new UniformContinuousRNG(250d, 420d);

        ArrayList<Double> ziskyZBalikov = new ArrayList<>();
        for (int j = 0; j < 30; j++) {
            double zisk = 0;
            for (int i = 0; i < pocetIteracii; i++) {

                double cena = triangularRNG.sample();
                double dlzkaPredaja = uniformContinuousRNG.sample();

                pocetPredanych = (int) Math.round(dlzkaPredaja / casMedziPredajom);

                double realnePreda = Math.min(j * 10, pocetPredanych);
                double strata = j * 10 * vytlacok;
                double vratenaCena = (j * 10 - realnePreda) * vytlacok * 0.65;
                zisk += realnePreda * cena - strata + vratenaCena;
            }
            ziskyZBalikov.add(zisk/pocetIteracii);
        }

        double poziciaNajlepsieho = Collections.max(ziskyZBalikov);
        int pozicia = ziskyZBalikov.indexOf(poziciaNajlepsieho);

        System.out.println("Pocet balikov: " + pozicia);
        System.out.println("Zisk s danym poctom balikov: " + poziciaNajlepsieho);

    }

}
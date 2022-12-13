import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Cestovatel {

    public static void main(String[] args) {


        TriangularRNG triangularRNG = new TriangularRNG(0.1, 0.2, 0.3);
        UniformContinuousRNG continuousRNG = new UniformContinuousRNG(0.1, 0.15);
        double[] cenyJednotliveDni = new double[7];
        int pocetIteracii = 100000;
        for (int i = 0; i < pocetIteracii; i++) {

            double naplnenost = 0.5;
            double cena = 150;

            for (int j = 0; j < 7; j++) {
                if (naplnenost >= 0.8) {
                    cena += cena * 0.35;
                    for (int k = j; k < 7; k++) {
                        cenyJednotliveDni[k] += cena;
                    }
                    break;
                }
                cenyJednotliveDni[j] += cena;
                cena = cena * (1 - triangularRNG.sample());
                naplnenost += continuousRNG.sample();
            }
        }

        double min = Arrays.stream(cenyJednotliveDni).min().orElse(0.0);
        int index = 0;
        for (int i = 0; i < cenyJednotliveDni.length; i++) {
            if (cenyJednotliveDni[i] == min) {
                index = i;
            }
        }

        System.out.println("Najvhodnejsi den je: " + index);
        System.out.println("Priemerna cena je: " + (double)min / pocetIteracii);

    }

}

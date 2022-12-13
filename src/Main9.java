import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import java.util.Arrays;

public class Main9 {

    public static void main(String[] args) {

        TriangularRNG dennaZmenaCeny = new TriangularRNG(0.01,0.04 , 0.11);
        UniformContinuousRNG zmenaNaplnenosti = new UniformContinuousRNG(0.05, 0.14);

        int pocetIteracii = 100000;
        double[] cena = new double[7];

        for (int i = 0; i < pocetIteracii; i++) {
            double naplnenost = 0.27;
            double cenaLetenky = 500;
            for (int j = 0; j < 7; j++) {

                if (naplnenost >= 0.75) {
                    cenaLetenky += cenaLetenky * 0.30;
                    for (int k = j; k < 7; k++) {
                        cena[k] += cenaLetenky;
                    }
                    break;
                }
                cena[j] += cenaLetenky;
                naplnenost += zmenaNaplnenosti.sample();
                if (!(naplnenost >= 0.75)) {
                    cenaLetenky = cenaLetenky * (1 - dennaZmenaCeny.sample());
                }
            }
        }

        double min = Arrays.stream(cena).min().orElse(0.0);
        int index = 0;
        for (int i = 0; i < cena.length; i++) {
            if (cena[i] == min) {
                index = i;
            }
        }
        System.out.println("Najvhodnejsi den je: " + index);
        System.out.println("Priemerna cena je: " + (double)min / pocetIteracii);
    }
}

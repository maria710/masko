import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Medovniky {


    public static void main(String[] args) {


        TriangularRNG triangularCena = new TriangularRNG(0.5d, 0.75d, 1d);
        TriangularRNG triangularKupa = new TriangularRNG(2d, 6d, 10d);
        UniformContinuousRNG vypredaj = new UniformContinuousRNG(1d, 3d);

        int pocetReplikacii = 100000;
        int zostatok = 0;
        double zarobok = 0;


        for (int i = 0; i < pocetReplikacii; i++) {

            int medovniky = 100;
            double cas = 10 * 60;
            double cena = triangularCena.sample();

            while (cas < 17 * 60) {
                if (medovniky <= 0) {
                    break;
                }
                medovniky--;
                zarobok += cena;
                cas += triangularKupa.sample();
            }

            boolean ostavaVela = medovniky >= 10;
            if (ostavaVela) {
                while (cas <= 18 * 60) {
                    if (medovniky <= 0) {
                        break;
                    }
                    zarobok += cena * 0.25;
                    medovniky--;
                    cas += vypredaj.sample();
                }
            } else {
                while (cas <= 18 * 60) {
                    if (medovniky <= 0) {
                        break;
                    }
                    medovniky--;
                    zarobok += cena;
                    cas += triangularKupa.sample();
                }
            }
            zostatok += medovniky;
        }

        System.out.println("priemerny zostatok: " + (double) zostatok / pocetReplikacii);
        System.out.println("priemerny zarobok: " + zarobok / pocetReplikacii);
    }
}

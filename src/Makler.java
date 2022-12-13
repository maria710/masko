import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Makler {

    public static void main(String[] args) {
        TriangularRNG dennaZmenaATriangular = new TriangularRNG(-0.05d, 0.014, 0.035);
        UniformContinuousRNG tyzdennaZmenaB = new UniformContinuousRNG(-0.025, 0.045);

        int pocetIteracii = 100000;
        double celkovaInvesticiaA = 0;
        double celkovaInvesticiaB = 0;

        for (int i = 0; i < pocetIteracii; i++) {

            double investiciaA = 10_000;
            double investiciaB = 10_000;
            int pocetTyzdnov = 52;
            for (int j = 0; j < pocetTyzdnov; j++) {
                investiciaB = investiciaB * (1 + tyzdennaZmenaB.sample());
                for (int k = 0; k < 7; k++) {
                    //tu bude denna zmena aby sa prepocitala na tyden
                    investiciaA = investiciaA * (1 + dennaZmenaATriangular.sample());
                }
            }
            celkovaInvesticiaA += investiciaA;
            celkovaInvesticiaB += investiciaB;
        }
        System.out.println("Investicia do fondu A je: " + (double)celkovaInvesticiaA / pocetIteracii);
        System.out.println("Investicia do fondu B je: " + (double)celkovaInvesticiaB / pocetIteracii);

        if (celkovaInvesticiaA < celkovaInvesticiaB) {
            System.out.println("Oplati sa investovat do fondu B");
        } else {
            System.out.println("Oplati sa investovat do fondu A");
        }
    }
}

import OSPRNG.TriangularRNG;
import OSPRNG.UniformDiscreteRNG;

public class Main2 {

    public static void main(String[] args) {


        TriangularRNG triangularA = new TriangularRNG(1d, 1.75, 2.5);
        TriangularRNG triangularB = new TriangularRNG(0.7, 1.2, 1.7);

        UniformDiscreteRNG uniformDiscreteA = new UniformDiscreteRNG(40, 80);
        UniformDiscreteRNG uniformDiscreteB = new UniformDiscreteRNG(66, 155);

        int cenaA = 3;
        int cenaB = 2;

        int maxA = 70;
        int maxB = 90;

        int pocetReplikacii = 10000;

        double ziskA = 0;
        double ziskB = 0;

        for (int i = 0; i < pocetReplikacii; i++) {

            double nakladyA = triangularA.sample();
            double nakladyB = triangularB.sample();

            double dopytA = uniformDiscreteA.sample();
            double dopytB = uniformDiscreteB.sample();

            ziskA += (Math.min(dopytA, maxA) * cenaA - nakladyA * maxA);
            ziskB += (Math.min(dopytB, maxB) * cenaB - nakladyB * maxB);
        }

        System.out.println("Zisk A: " + ziskA/pocetReplikacii);
        System.out.println("Zisk B: " + ziskB/pocetReplikacii);

        String vitaznyProdukt = ziskA > ziskB ? "A" : "B";
        System.out.println("Oplati sa " + vitaznyProdukt);
    }
}

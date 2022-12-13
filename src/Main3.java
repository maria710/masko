import OSPRNG.UniformContinuousRNG;

public class Main3 {


    public static void main(String[] args) {

        //2PI R
        UniformContinuousRNG x = new UniformContinuousRNG(0d, 1d);
        UniformContinuousRNG y = new UniformContinuousRNG(0d, 1d);


        int pocetIteracii = 1_000_000;

        int pocetPadnutychDoKruhu = 0;
        double stredX = 0.5;
        double stredY = 0.5;
        double polomer = 0.5;

        for (int i = 0; i < pocetIteracii; i++) {
            double xOs = x.sample();
            double yOs = y.sample();

            if (Math.pow(xOs -stredX, 2) + Math.pow(yOs - stredY, 2) <= Math.pow(polomer, 2)){
                pocetPadnutychDoKruhu++;
            }
        }
        double podielPadnutych = (double) pocetPadnutychDoKruhu / pocetIteracii;
        double pi = podielPadnutych / Math.pow(polomer, 2);

        System.out.println("Pi je: " + pi);


    }
}

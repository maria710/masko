import OSPRNG.TriangularRNG;

public class Main8 {

    public static void main(String[] args) {


        TriangularRNG triangularRNG = new TriangularRNG(1d, 3d, 3.5);
        double pracovnyCas = 10;
        int pocetIteracii = 1000;

        for (int j = 1; j < 50; j++) {

            int pocetPrekroceni = 0;
            for (int i = 0; i < pocetIteracii; i++) {
                double rozlohaSpracovanaKombajnami = 0;
                for (int k = 0; k < pracovnyCas * 2 * j; k++) {
                    rozlohaSpracovanaKombajnami += triangularRNG.sample();
                }
                if (rozlohaSpracovanaKombajnami < 300) {
                    pocetPrekroceni++;
                }
            }
            double pPrekrocenia = (double) pocetPrekroceni / pocetIteracii;
            if (pPrekrocenia <= 0.1) {
                System.out.println("Minimalny Pocet kombajnov je: " + j);
                System.out.println("Pravdepodobnost prekrocenia: " + pPrekrocenia);
                break;
            }
        }




    }
}

import OSPRNG.TriangularRNG;

public class Main7 {

    public static void main(String[] args) {

        TriangularRNG triangularRNG = new TriangularRNG(1000d, 4000d, 8500d);
        int nakupnaCena = 150;
        int zostatkovaCena = 50;
        int idealnaKapacita = 0;
        double idealneNaklady = 100000000.0;
        int pocetIteracii = 100000;

        for (int j = 5200; j < 5900; j++) {
            double naklady = 0;

            for (int i = 0; i < pocetIteracii; i++) {
                long dopyt = Math.round(triangularRNG.sample());
                if (dopyt > j) {
                    long dodat = dopyt - j;
                    naklady += dodat * nakupnaCena;
                } else {
                    long predat = j - dopyt;
                    naklady += predat * zostatkovaCena;
                }
            }
            double priemerneNaklady = naklady / pocetIteracii;
            if (priemerneNaklady < idealneNaklady) {
                idealneNaklady = priemerneNaklady;
                idealnaKapacita = j;
            }
        }
        System.out.println("Idealna kapacita skladu je : " + idealnaKapacita);
    }
}

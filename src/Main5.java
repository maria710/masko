import OSPRNG.TriangularRNG;

public class Main5 {

    public static boolean odpoved1;
    public static boolean odpoved2;
    public static boolean odpoved3;

    public static boolean naozajstnaOdpoved;


    public static void main(String[] args) {


        double uhadliObeSpravne = 0;
        double uhadliObe = 0;

        for (int i = 0; i < 10000000; i++) {

            int vestica1 = 0;
            int vestica2 = 0;

            if(Math.random() < 0.8)
                vestica1 = 1;

            if(Math.random() < 0.8)
                vestica2 = 1;

            if(vestica1 == 1 && vestica2 == 1)
                uhadliObeSpravne++;

            if(vestica1 == vestica2)
                uhadliObe++;
        }
        System.out.println(uhadliObeSpravne / uhadliObe);


        double uhadliTriSpravne = 0;
        double uhadliTri = 0;

        for (int i = 0; i < 10000000; i++) {

            int vestica1 = 0;
            int vestica2 = 0;
            int vestica3 = 0;

            if(Math.random() < 0.8)
                vestica1 = 1;
            if(Math.random() < 0.8)
                vestica2 = 1;
            if(Math.random() < 0.8)
                vestica3 = 1;

            if(vestica1 == 1 && vestica2 == 1 && vestica3 == 1)
                uhadliTriSpravne++;

            if(vestica1 == vestica2 && vestica2 == vestica3)
                uhadliTri++;
        }
        System.out.println(uhadliTriSpravne / uhadliTri);


        double uhadliObeSpravneTRIANGULAR = 0;
        double uhadliObeTRIANGULAR = 0;

        TriangularRNG triangular = new TriangularRNG(0.3, 0.8, 1.0);

        for (int i = 0; i < 10000000; i++) {

            int vestica1 = 0;
            int vestica2 = 0;

            double uspesnos1 = triangular.sample();
            double uspesnost2 = triangular.sample();
            double p1 = Math.random();
            double p2 = Math.random();

            if(p1 < uspesnos1)
                vestica1 = 1;

            if(p2 < uspesnost2)
                vestica2 = 1;

            if(vestica1 == 1 && vestica2 == 1)
                uhadliObeSpravneTRIANGULAR++;

            if(vestica1 == vestica2)
                uhadliObeTRIANGULAR++;
        }
        System.out.println(uhadliObeSpravneTRIANGULAR / uhadliObeTRIANGULAR);

    }

}
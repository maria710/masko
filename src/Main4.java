import java.util.Random;

public class Main4 {


    public static void main(String[] args) {

        //1
        int polohaPriemer = 0;
        for (int j = 0; j < 1000; j++) {
            int poloha = 0;
            for (int i = 0; i < 1000; i++) {
                int randomOfTwoInts = new Random().nextBoolean() ? 1 : 0;
                if (randomOfTwoInts == 1) {poloha++;} else {poloha--;}
            }
            polohaPriemer += Math.abs(poloha);
        }
        //System.out.println("Poloha: " + (double)polohaPriemer/1000);

        //2
        int polohaPriemerX = 0;
        int polohaPriemerY = 0;
        for (int j = 0; j < 100000; j++) {
            int polohaX = 0;
            int polohaY = 0;
            for (int i = 0; i < 1000; i++) {
                double p = Math.random();
                if (p < 0.25) {
                    polohaX++;
                } else if (p < 0.5) {
                    polohaX--;
                } else if(p < 0.75) {
                    polohaY++;
                } else {
                    polohaY--;
                }
            }
            polohaPriemerX += Math.abs(polohaX);
            polohaPriemerY += Math.abs(polohaY);
        }
        System.out.println("teoreticka: " + Math.sqrt((4*100000)/Math.PI));
        System.out.println("PolohaX: " + (double)polohaPriemerX/100000);
        System.out.println("PolohaY: " + (double)polohaPriemerY/100000);

        double kroky = (double)polohaPriemerX/100000 + (double)polohaPriemerY/100000;
        System.out.println("Kroky: " + kroky);


        //3
        double teoretickyOdhad3 = Math.sqrt((6 * 1000) / Math.PI);
        System.out.println("TEORETICKY ODHAD : " + teoretickyOdhad3);

        double vzdialenostX1 = 0;
        double vzdialenostY1 = 0;
        double vzdialenostZ1 = 0;

        for (int j = 0; j < 100000; j++) {
            int pociatocnyBodX = 0;
            int pociatocnyBodY = 0;
            int pociatocnyBodZ = 0;

            for (int i = 0; i < 1000; i++) {
                double p = Math.random();
                if (p < 0.166) {
                    pociatocnyBodX++;
                } else if (p < 0.3332) {
                    pociatocnyBodX--;
                } else if(p < 0.4998) {
                    pociatocnyBodY++;
                } else if (p < 0.6664){
                    pociatocnyBodY--;
                } else if(p < 0.833) {
                    pociatocnyBodZ++;
                } else {
                    pociatocnyBodZ--;
                }
            }
            vzdialenostX1 += Math.abs(pociatocnyBodX);
            vzdialenostY1 += Math.abs(pociatocnyBodY);
            vzdialenostZ1 += Math.abs(pociatocnyBodZ);
        }
        System.out.println("priemerna vzdialenost X : " + vzdialenostX1 / 100000);
        System.out.println("priemerna vzdialenost Y : " + vzdialenostY1 / 100000);
        System.out.println("priemerna vzdialenost Z : " + vzdialenostZ1 / 100000);
        double potrebnyPocetKrokov1 =  vzdialenostX1 / 100000 +  vzdialenostY1 / 100000 +  vzdialenostZ1 / 100000;
        System.out.println("Potrebny počet krokov : " + potrebnyPocetKrokov1);


    }




}

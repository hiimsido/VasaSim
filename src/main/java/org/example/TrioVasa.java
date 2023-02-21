package org.example;


public class TrioVasa {


    private static int Success = 0;
    private static int Failure = 0;
    private static final int attempts = 10000000;


    //bow accuracy
    private static final double BowAccA = 69.07;
    private static final double BowAccB = 60.66;

    //zcb accuracy
    private static final double SpecAccA = 80.45;
    private static final double SpecAccB = 76.79;

    // ZCB max hit and Twisted Bow Max hit
    private static final int Spec = 110;
    private static final int Max = 96;
    private static final int Min = 0;

    public static void main(String[] args) {
        System.out.println("Vasa coding simulator begins.");


        for (int i = 0; i < attempts; i++) {
            int VasaHealth = 900;
            int ZCBCount = 3;
            int ZCBCountTPAway = ZCBCount/2;
            int ZCBCountBesideBoss = ZCBCountTPAway + (ZCBCount%2);
            VasaHealth = VasaHealth - (58 * 3);

            for (int j = 0; j < ZCBCountBesideBoss; j++) {
                boolean AccCheck = (SpecAccB >= (Math.random() * (100.00) + 0.00));

                if (AccCheck) {
                    VasaHealth = VasaHealth - Spec;
                }


            }

            for (int j = 0; j < ZCBCountTPAway; j++) {
                boolean AccCheck = (SpecAccA >= (Math.random() * (100.00) + 0.00));

                if (AccCheck) {
                    VasaHealth = VasaHealth - Spec;
                }


            }
            for (int z = 0; z < (9); z++) {
                boolean AccCheckB = (BowAccA >= (Math.random() * (100.00) + 0.00));

                if (AccCheckB) {
                    VasaHealth = VasaHealth - (int) Math.floor(Math.random() * (Max - Min + 1.00) + Min);
                }
            }

            if (VasaHealth <= 0) {
                Success = Success + 1;
            }

            if (VasaHealth >= 0) {
                Failure = Failure + 1;
            }

        }
        System.out.println("Successful 0 Crystals: " + Success + " out of " + attempts);
        System.out.println("Success Rate = " + (double) Success / attempts);
    }

}

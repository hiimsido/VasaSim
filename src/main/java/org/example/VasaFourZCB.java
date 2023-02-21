package org.example;


import java.sql.Struct;

public class VasaFourZCB {


    private static int Success = 0;
    private static int Failure = 0;
    private static final int attempts = 10000000;


    //bow accuracy
    private static final double BowAccA = 66.87;
    private static final double BowAccB = 60.66;

    //zcb accuracy
    private static final double SpecAccA = 80.03;
    private static final double SpecAccB = 76.28;


    private static final int Spec = 110;
    private static final int Max = 96;
    private static final int Min = 0;
    private static final int MaxB = 79;

    public static void main(String[] args) {
        System.out.println("Vasa coding simulator begins.");


        for (int i = 0; i < attempts; i++) {
            int VasaHealth = 1350;
            int ZCBCountTP = 3;
            int ZCBCountTPAway = 1;
            boolean TeleportOdds = (3<=(int)(Math.random() * (5) + 1.00));
            //If the non-ZCB gets teleported inwards
            if (TeleportOdds)
            {
                ZCBCountTP = 2;
                ZCBCountTPAway = 2;
                // 1 No Rigour Bow
                boolean AccCheckB = (BowAccB >= (Math.random() * (100.00)));

                if (AccCheckB) {
                    VasaHealth = VasaHealth - (int) Math.floor(Math.random() * (MaxB - Min + 1.00) + Min);
                }

            }
            //If the non-ZCB gets teleported away
            if (!TeleportOdds)
            {
                // 1 Rigour bow
                boolean AccCheckB = (BowAccA >= (Math.random() * (100.00)));

                if (AccCheckB) {
                    VasaHealth = VasaHealth - (int) Math.floor(Math.random() * (Max - Min + 1.00) + Min);

                }
            }
            // Venge Bomb
            VasaHealth = VasaHealth - (52 * 5);

            // ZCBs beside Vasa
            for (int j = 0; j < ZCBCountTPAway ; j++) {
                boolean AccCheck = (SpecAccB >= (Math.random() * (100.00)));

                if (AccCheck) {
                    VasaHealth = VasaHealth - Spec;

                }


            }

            for (int j = 0; j < ZCBCountTP; j++) {
                boolean AccCheck = (SpecAccA >= (Math.random() * (100.00)));

                if (AccCheck) {
                    VasaHealth = VasaHealth - Spec;
                }


            }
            for (int z = 0; z < 15; z++) {
                boolean AccCheckB = (BowAccA >= (Math.random() * (100.00)));

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

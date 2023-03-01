package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeSet;

public class VasaNoZCB {

    private final static int attempts = 100000;
    private static int failure = 0;
    private static int NoCrystal = 0;
    private static int Success = 0;
    private static double TotalTime = 0;
    private static final DecimalFormat df = new DecimalFormat("0.0");
    private static final DecimalFormat formattwo = new DecimalFormat("0.000");

    static int AttackSim(double acc, int max) {
        //double check to see if damage changes or stays persistent


        int damage = 0;
        if (acc > Math.random()) {
            damage = (int) (Math.random() * (max + 1));
            return damage;
        }

        return 0;
    }


    public static void main(String[] args) {

        ArrayList<Integer> StoredHits = new ArrayList<>();
        TreeSet<Integer> HitTypes = new TreeSet<>();

        for (int i = 0; i < attempts; i++) {


                int HitCount = 0;
                int CrystalHits = 0;
                int VasaHealth = 1350;
                int max = 96;
                double acc = .6687;
                //vengebomb
                VasaHealth = VasaHealth - (52 * 5);
                int VolA = 3;
                //first volley of attacks
                HitCount++;
                for (int j = 0; j < 5; j++) {


                    if (VolA > 0) {

                        VasaHealth = VasaHealth - AttackSim(.6066, 79);

                        VolA = VolA - 1;
                    } else {
                        VasaHealth = VasaHealth - AttackSim(acc, max);
                    }

                }
                //hits after teleport finishes (rigour on)
                for (int j = 0; j < 3; j++) {
                    HitCount = HitCount + 1;
                    for (int k = 0; k < 5; k++) {
                        VasaHealth = VasaHealth - AttackSim(acc, max);
                    }


                }

                if (VasaHealth <= 0) {
                    NoCrystal++;
                    Success++;
                    TotalTime = TotalTime + 30;
                    continue;
                }

                //Method which calculates odds of Crystal Dying in x hits
                CrystalHits = clawsCrystalSim.DragonClaws(3, 2, 2);
                //Vasa heals 13 HP per 2 ticks, heals twice before you get your first hit off.
                //1 in 4 Chance that Vasa goes to southwest, aka gets an extra heal
                if (4 < (int) ((Math.random() * 4) + 1)) {
                    VasaHealth = VasaHealth + (CrystalHits * 26) + 13;
                } else {
                    VasaHealth = VasaHealth + (CrystalHits * 26);
                }
                //7 Volleys of arrows to kill vasa in time.
                for (int j = 0; j < 7; j++) {
                    HitCount = HitCount + 1;
                    for (int k = 0; k < 5; k++) {
                        VasaHealth = VasaHealth - AttackSim(acc, max);
                    }
                    if (VasaHealth <= 0) {
                        break;
                    }
                }
                //If Vasa dies, success goes up
                if (VasaHealth <= 0) {
                    Success = Success + 1;
                    TotalTime = TotalTime + (15 + (3.0 * HitCount) + (CrystalHits * 2.4));
                } else {
                    failure++;
                }

            }

            System.out.println("Average Time = " + df.format((TotalTime / Success)));
            System.out.println("Success Count = " + (double)Success/attempts);
            System.out.println("0 Crystals = " + NoCrystal);
            System.out.println("Fail Count = " + failure);


        }

    }

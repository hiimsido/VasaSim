package org.example;

import javax.swing.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

public class PostCrystalSim {




        private static int Success = 0;
        private static int Success2 = 0;
        private static int Failure = 0;
        public static int CrystalHits = 0;
        private static int TotalCount = 0;

        private static int PostCrystalHits = 0;
        private static final int attempts = 1000000;
        private static double Sum = 0.000;


        //bow accuracy
        private static final double BowAccA = 66.87;
        private static final double BowAccB = 60.66;

        //zcb accuracy
        private static final double SpecAccA = 80.03;
        private static final double SpecAccB = 76.28;

        // ZCB max hit and Twisted Bow Max hit
        private static final int Spec = 110;
        private static final int Max = 96;
        private static final int Min = 0;
        public static int vasaHealth = 1350;
        private static final DecimalFormat df = new DecimalFormat("0.0");


    public static void main(String[] args) {
            System.out.println("Vasa coding simulator begins.");
        TreeSet<Integer> HitResults = new TreeSet<>();
        TreeSet<Integer> HPResults = new TreeSet<>();
        ArrayList<Integer> HitStorage = new ArrayList<>();
        ArrayList<Integer> HPStorage = new ArrayList<>();

        int voidwakerhits = 0;
        int bowhits = 0;


            for (int i = 0; i < attempts; i++) {
                vasaHealth = 1350;
                int ZCBCount = 5;
                vasaHealth = vasaHealth - (52 * 5);

                for (int j = 0; j < ZCBCount - 2; j++) {
                    boolean AccCheck = (SpecAccB >= (Math.random() * (100.00) + 0.00));

                    if (AccCheck) {
                        vasaHealth = vasaHealth - Spec;
                    }


                }

                for (int j = 0; j < ZCBCount - 3; j++) {
                    boolean AccCheck = (SpecAccA >= (Math.random() * (100.00) + 0.00));

                    if (AccCheck) {
                        vasaHealth = vasaHealth - Spec;
                    }


                }
                for (int z = 0; z < (15); z++) {
                    boolean AccCheckB = (BowAccA >= (Math.random() * (100.00) + 0.00));

                    if (AccCheckB) {
                        vasaHealth = vasaHealth - (int) Math.floor(Math.random() * (Max - Min + 1.00) + Min);
                    }
                }

                if (vasaHealth <= 0) {
                    Success = Success + 1;
                    HitStorage.add(0);
                    HitResults.add(0);
                    Sum = Sum + 30.0;
                }

                if (vasaHealth > 0) {

                    int RemainingHealth = ((vasaHealth+49)/50) * 50;
                    HPStorage.add(RemainingHealth);
                    HPResults.add(RemainingHealth);
                    //make a case statement for different health values to print out
                    int TotalHits = 4;
                    PostCrystalHits = 0;
                    VoidwakerKillOdds Sim = new VoidwakerKillOdds();
                    Sim.BeginSim();
                  CrystalHits = VoidwakerKillOdds.TotalHits;
                    vasaHealth += VoidwakerKillOdds.HealAmount;
                    for (int j = 0; j < 7 ; j++) {
                     vasaHealth = vasaHealth -  DifferentAttackRules.BowA(5,1, .6687, 96);
                     TotalHits++;
                     PostCrystalHits++;
                     if (vasaHealth<=0)
                     {
                         HitStorage.add(TotalHits-4);
                         HitResults.add(TotalHits-4);
                         Sum = Sum + (15.0+(TotalHits*3.0)+(CrystalHits*2.4));
                         Success2++;
                         break;
                     }


                    }

                    if (vasaHealth>0)
                    {
                        Failure++;

                    }




                }




            }
/*
        for (int each:HPResults.descendingSet()
             ) {
            int count = Collections.frequency(HPStorage,each);
            System.out.println("Chance of " + each + " health remaining (rounded up to nearest 50th): " + (double)(count*100)/attempts);
        }
*/      System.out.println("- - With the Assumption Vasa Doesn't get 0 Crystaled - -");
        for (int each:HitResults
        ) {
            int count = Collections.frequency(HitStorage,each);
            TotalCount = TotalCount + count;

            System.out.println("Chance of Vasa dying after " + each + " hits post crystal: " + (double)(TotalCount*100)/attempts);
            System.out.println();
        }


        Sum = Sum/attempts;
        System.out.println("Average combat duration (not including death animation/room end on 4t cycle) = " + df.format(Sum));

        System.out.println();

        System.out.println("Successful 0 Crystals: " + Success + " out of " + attempts);
        System.out.println("Success Rate = " + (double) Success / attempts);
        System.out.println("Killed before 2 crystal rate = " + (double) (attempts-Failure)/attempts);
        System.out.println("Amount of two crystals = " + Failure);
        }

    }



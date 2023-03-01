package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class voidwakerv2 {



    public static int attempts = 100000000;

    public static int HealAmount = 0;
    public static int TotalCount = 0;

    public static boolean AccRoll(double acc)
    {
        return (acc>Math.random());
    }


    public static int AttackRoll(int Max)
    {
        return (int)(Math.random()*Max + 1);
    }




    public static int VoidwakerSim() {




        int  VasaCrystalHealth = 360;
        int TotalHits = 0;




        while (VasaCrystalHealth>=0)
        {

            int Torva = 3;
            int Inq = 2;
            int PlayerCount = Torva + Inq;
            int Max = 0;
            double acc = 0;
            TotalHits++;
            for (int j = 0; j < PlayerCount; j++) {

                if (Torva>0)
                {
                    Max = 50;
                    acc = .8448;
                    Torva--;
                }

                else
                {
                    Max = 49;
                    acc = .8351;
                    Inq--;
                }
                    if (AccRoll(acc))
                    {
                        VasaCrystalHealth = VasaCrystalHealth - AttackRoll(Max);
                    }


            }


        }

        if (4<(Math.random()*(4)) + 1)
        {
            HealAmount = (TotalHits * 26) + 13 ;
        }
        else {
            HealAmount = TotalHits * 26;
        }

        return TotalHits;

    }

    public static void main(String[] args) {

        HashSet<Integer> Variation = new HashSet<>();
        ArrayList<Integer> StackValue = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
          int TotalHits = VoidwakerSim();
            Variation.add(TotalHits);
            StackValue.add(TotalHits);




        }

        for (int each:Variation
        ) {

            int count = Collections.frequency(StackValue,each);
            TotalCount = TotalCount + count;
            System.out.println("Odds of killing the Crystal with " + each + " hits: " + (double)TotalCount*100/attempts);

        }



    }


}


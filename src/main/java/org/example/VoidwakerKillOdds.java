package org.example;

import java.util.Random;

public class VoidwakerKillOdds {


    public static int TotalHits;

    public static int HealAmount = 0;
    public static class VasaStats
    {

        boolean AtkRole = (.8351>Math.random());
        boolean AtkRoleB = (.8448>Math.random());

        int DmgA = (int)(Math.random()*(51+1));
        int DmgB = (int)(Math.random()*(49+1));
    }



    public void BeginSim() {



        HealAmount = 0;
        TotalHits = 0;
        int   VasaCrystalHealth = 360;





            while (VasaCrystalHealth>=0)
            {
                TotalHits++;
                for (int j = 0; j < 3; j++) {
                    VasaStats Stats = new VasaStats();
                    if (Stats.AtkRoleB)
                    {
                        VasaCrystalHealth = VasaCrystalHealth - Stats.DmgB;
                    }

                }

                for (int j = 0; j < 2; j++) {
                    VasaStats Stats = new VasaStats();
                    if (Stats.AtkRole)
                    {
                        VasaCrystalHealth = VasaCrystalHealth - Stats.DmgA;
                    }
                }
            }

            if (4<(int)(Math.random()*(4)) + 1)
            {
                HealAmount = (TotalHits * 26) + 13 ;
            }
            else {
                HealAmount = TotalHits * 26;
            }

        }


    }


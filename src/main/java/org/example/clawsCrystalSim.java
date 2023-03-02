package org.example;

public class clawsCrystalSim {



    public static boolean Odds(double acc)
    {
        return (acc >= Math.random());
    }






        public static int DragonClaws(int Torva, int Inq, int Specs) {
            int VasaCrystalHealth = 360;
            int TotalHits = 0;
            int T = 0;
            int I = 0;
            int TotalClawDamage = 0;
            int players = Torva + Inq;

        while (Specs >0) {
            T = Torva;
            I = Inq;
            Specs--;
            TotalHits++;
            for (int i = 0; i < players; i++) {


                int max = 43;
                double maxTwo = 43.000;
                double acc = .4217;


                if (T > 0) {
                    T--;

                } else {
                    I--;
                    max = 41;
                    acc = .3997;
                    maxTwo = 41.000;
                }


                for (int j = 0; j < 4; j++) {
                    if ((j == 0) && Odds(acc)) {
                        int TotalSpecDMG = (int) (Math.random() * (max * .5)) + (max / 2);
                        TotalClawDamage = (TotalSpecDMG + (TotalSpecDMG / 2) + (TotalSpecDMG / 4) + (TotalSpecDMG / 4));
                        VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                        break;

                    } else if ((j == 1) && Odds(acc)) {
                        int TotalSpecDMG = (int) (Math.random() * (maxTwo * .5)) + (int) (maxTwo * (.375));
                        TotalClawDamage = ((TotalSpecDMG) + (TotalSpecDMG / 2) + (TotalSpecDMG / 2));
                        VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                        break;

                    } else if ((j == 2) && Odds(acc)) {
                        int TotalSpecDMG = (int) (Math.random() * (maxTwo * .5)) + (int) (maxTwo * .25);
                        TotalClawDamage = (TotalSpecDMG * 2);
                        VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                        break;

                    } else if ((j == 3) && Odds(acc)) {
                        TotalClawDamage = (int) (Math.random() * (int) maxTwo) + (int) (maxTwo / 4);
                        VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                        break;

                    }


                }


            }

        }

        while (VasaCrystalHealth>0) {
            T = Torva;
            I = Inq;
            TotalHits++;
            for (int i = 0; i < players; i++) {
                double acc = .8651;
                int max = 43;

                if (T> 0) {

                    T--;
                }

                else
                {
                    acc = .8442;
                    max = 41;
                    I--;
                }

                if (Odds(acc)) {
                    int ClawDamage = (int) (Math.random() * (max + 1));
                    VasaCrystalHealth = VasaCrystalHealth - ClawDamage;

                    if (VasaCrystalHealth<=0) {
                        break;
                    }

                }
            }






        }
            return TotalHits;
        }




    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(DragonClaws(3,2,2));
        }




    }
}

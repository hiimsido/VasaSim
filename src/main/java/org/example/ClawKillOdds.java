package org.example;

public class ClawKillOdds {


    private static int Success = 0;
    private static int Failure = 0;
    private static int attempts = 10000;
    private static int VasaCrystalHealth = 360;

    public boolean Odds(double acc)
    {
        double a = Math.random();
        boolean b = acc >= a;



        return (b);
    }

    public static class VasaStats
    {

        boolean AtkRole = (.8351>Math.random());
        boolean AtkRoleB = (.8448>Math.random());

        int DmgA = (int)(Math.random()*(51+1));
        int DmgB = (int)(Math.random()*(49+1));


        public static void DragonClaws(int Torva, int Inq) {

            ClawKillOdds Claw = new ClawKillOdds();
            for (int d = 0; d < 2; d++) {


                for (int i = 0; i < Torva; i++) {


                    int max = 43;
                    double maxTwo = 43.000;
                    double acc = .4217;
                    boolean initiate = false;
                    for (int j = 0; ((j < 4) && (!initiate)); j++) {
                        if ((j == 0) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (max * .5)) + (max / 2);
                            VasaCrystalHealth = VasaCrystalHealth - (TotalSpecDMG + (TotalSpecDMG / 2) + (TotalSpecDMG / 4) + (TotalSpecDMG / 4));
                            initiate = true;

                        }

                        else if ((j == 1) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (maxTwo * .5)) + (int) (maxTwo * (.375));
                            VasaCrystalHealth = VasaCrystalHealth - ((TotalSpecDMG ) + (TotalSpecDMG / 2) + (TotalSpecDMG / 2));
                            initiate = true;

                        }

                        else if ((j == 2) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (maxTwo * .5)) + (int) (maxTwo * .25);
                            VasaCrystalHealth = VasaCrystalHealth - (TotalSpecDMG * 2);
                            initiate = true;

                        }

                        else if ((j == 3) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (int) maxTwo ) + (int)(maxTwo / 4);
                            VasaCrystalHealth = VasaCrystalHealth - TotalSpecDMG;
                            initiate = true;

                        }
                    }


                }

                for (int i = 0; i < Inq; i++) {

                    int max = 41;
                    double acc = .3997;
                    double maxTwo = 41.000;
                    boolean initiate = false;
                    for (int j = 0; ((j < 4) && (!initiate)); j++) {
                        if ((j == 0) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * max - (max / 2)) + (max / 2);
                            VasaCrystalHealth = VasaCrystalHealth - (TotalSpecDMG + (TotalSpecDMG / 2) + (TotalSpecDMG / 4) + (TotalSpecDMG / 4));
                            initiate = true;

                        }

                        else if ((j == 1) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (int) (maxTwo * (.875)) - (int) (maxTwo * (.375))) + (int) (maxTwo * (.375));
                            VasaCrystalHealth = VasaCrystalHealth - (0 + (TotalSpecDMG / 2) + (TotalSpecDMG / 4) + (TotalSpecDMG / 4));
                            initiate = true;

                        }

                        else if ((j == 2) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (int) ((maxTwo * (.75)) - (int) (maxTwo / 4))) + (int) (maxTwo / 4);
                            VasaCrystalHealth = VasaCrystalHealth - (TotalSpecDMG + TotalSpecDMG);
                            initiate = true;

                        }

                        else if ((j == 3) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (int) (maxTwo * 1.25) - (int) (maxTwo / 4)) + (int) (maxTwo / 4);
                            VasaCrystalHealth = VasaCrystalHealth - TotalSpecDMG;
                            initiate = true;

                        }
                    }


                }

            }
        }
    }


    public static void main(String[] args) {





        for (int i = 0; i < attempts; i++) {
            VasaCrystalHealth = 360;






            ClawKillOdds.VasaStats Stats = new ClawKillOdds.VasaStats();
            VasaStats.DragonClaws(3,2);
            if (VasaCrystalHealth>=0)
            {
                Failure = Failure + 1;
            }

            if (VasaCrystalHealth<=0)
            {
                Success = Success + 1;
            }






        }

        System.out.println("Success rate of killing Vasa Crystal: " + ((float)Success/attempts));

    }
}

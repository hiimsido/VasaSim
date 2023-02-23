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




        public static void DragonClaws(int Torva, int Inq) {

            ClawKillOdds Claw = new ClawKillOdds();
            int TotalClawDamage = 0;



                for (int i = 0; i < 5; i++) {


                    int max = 43;
                    double maxTwo = 43.000;
                    double acc = .4217;


                    if(Torva>0){
                        Torva--;

                    }
                    else{
                        Inq--;
                        max = 41;
                        acc = .3997;
                        maxTwo = 41.000;
                    }


                    for (int j = 0; j < 4; j++) {
                        if ((j == 0) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (max * .5)) + (max / 2);
                            TotalClawDamage = (TotalSpecDMG + (TotalSpecDMG / 2) + (TotalSpecDMG / 4) + (TotalSpecDMG / 4));
                            VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                            break;

                        }

                        else if ((j == 1) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (maxTwo * .5)) + (int) (maxTwo * (.375));
                            TotalClawDamage = ((TotalSpecDMG ) + (TotalSpecDMG / 2) + (TotalSpecDMG / 2));
                            VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                            break;

                        }

                        else if ((j == 2) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (maxTwo * .5)) + (int) (maxTwo * .25);
                            TotalClawDamage = (TotalSpecDMG * 2);
                            VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                            break;

                        }

                        else if ((j == 3) && Claw.Odds(acc)) {
                            int TotalSpecDMG = (int) (Math.random() * (int) maxTwo ) + (int)(maxTwo / 4);
                            TotalClawDamage = TotalSpecDMG;
                            VasaCrystalHealth = VasaCrystalHealth - TotalClawDamage;
                            break;

                        }
                    }


                }



            }
        }



    public static void main(String[] args) {





        for (int i = 0; i < attempts; i++) {
            VasaCrystalHealth = 360;



            for (int j = 0; j < 2; j++) {
                VasaStats.DragonClaws(3,2);
            }


            if (VasaCrystalHealth>0)
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

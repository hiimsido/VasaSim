package org.example;

public class DifferentAttackRules {

    public static boolean Odds(double acc)
    {
        return (acc >= Math.random());
    }

    public static int BowA(int players, int attacks, double acc, int max) {
        int TotalDamage = 0;
        for (int i = 0; i < (players * attacks); i++) {
            if (Odds(acc)) {
                TotalDamage = TotalDamage + (int)((Math.random() * max) + 1);
            }
        }
        return TotalDamage;
    }






    public static void main(String[] args) {
        int BossHealth = 2000;
        for (int i = 0; i <= BossHealth; i++) {

            BossHealth = BossHealth - BowA(5,4, .6687, 96);
            System.out.println("Remaining Health = " + BossHealth);
        }

    }
}

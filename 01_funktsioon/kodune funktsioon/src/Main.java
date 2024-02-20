//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //kolm funktsiooni - kasutatud nelja erinevat tüüpi: int, string, char, long, double, float
        //vahet pole kas sisse või välja, igast funktsioonist 2 väljakutset


        // BMI arvutus

        double tulemus1= getBmi(75,182);
        System.out.println("Su BMI on:"+tulemus1);

        double tulemus2= getBmi(125,165);
        System.out.println("Su BMI on:"+tulemus2);

        // BMI hinnang
        String hinnang1 = BMI_hinnang(tulemus1);
        System.out.println(hinnang1);

        String hinnang2 = BMI_hinnang(tulemus2);
        System.out.println(hinnang2);


        // kalorite testid, aktiivsusaste 1.2 kuni 2.2 (1.2 = istuv, 2.2= väga aktiivne)

        double kalor1=getCalories(100,182,50, 'M',1.5);
        System.out.println("Sinu päevane kalorivajadus on: "+kalor1+" kalorit.");

        double kalor2=getCalories(55,162,21,'n',1.2);
        System.out.println("Sinu päevane kalorivajadus on: "+kalor2+" kalorit.");

    }
    public static double getCalories(int kaal, double pikkus, int vanus, char sugu, double aktiivsusaste) {
        double kalorid;

        if (sugu == 'M' || sugu == 'm') {
            kalorid = ((10 * kaal) + (6.25 * pikkus) - (5 * vanus)) * aktiivsusaste;
        } else if (sugu == 'N' || sugu == 'n') {
            kalorid = ((10 * kaal) + (6.25 * pikkus) - (5 * vanus)-161) * aktiivsusaste;
        } else {
            throw new IllegalArgumentException("Valitud sugu ei sobi: " + sugu+" vali M või N.");
        }

        return Math.round(kalorid);
    }


    private static int getBmi(double kehakaal, double pikkus_cm) {
        double pikkus_m=pikkus_cm/100;
        double tulemus= kehakaal/(pikkus_m * pikkus_m);
        return (int) tulemus;
    }

    private static String BMI_hinnang(double BMI) {
        if (BMI <18.5) {
            return "BMI:"+BMI+", oled alakaalus.";
        } else if (BMI <24.9) {
            return "BMI:"+BMI+", oled normaalkaalus.";
        } else if (BMI <29.9) {
            return "BMI:"+BMI+", oled ülekaalus.";
        } else {
            return "BMI:"+BMI+", oled tugevalt ülekaalus.";
        }

    }
}

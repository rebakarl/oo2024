// * Koosta klass toiduaine tarbeks (nimetus, valkude, rasvade ja süsivesikute protsent ehk int tüüpi muutuja). -ok
// Loo "main funktsioonis" mõni toiduaine -ok
// (nt. kartul, hapukoor, vorst). Koosta uus klass toidukomponendi tarbeks (kogus, viit toiduainele). -ok
// Loo mõned toidukomponendid (nt. 100 g kartuleid, 30 g hapukoort, 50 g vorsti). -ok
// Lisa toidukomponendile käsklus selle sees leiduva rasvakoguse arvutamiseks.- ok

//  * Koosta klass toidu jaoks (nimetus, viit toidukomponendile). Lisa toidule käsklused küsimaks sisalduvate valkude, rasvade ja süsivesikute kogust. - ok
//  Loo "main funktsioonis" toit (nt. kartulisalat), küsi salatis leiduvate toitainete kogused. - ok

//  * Võimalda toidu andmeid kirjutada tekstifaili(desse) ja lugeda tagasi. +
//  Võib eeldada, et toiduaine, toidukomponendi ning toidu nimetus on unikaalne, et ei tekiks failide juures üle kirjutamist. +


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) throws IOException {
        // loome toiduained
        Toiduaine kartul = new Toiduaine("leib", 3.0, 0.15, 25.0);
        Toiduaine hapukoor = new Toiduaine("Hapukoor", 2.0, 20.0, 3.0);
        Toiduaine vorst = new Toiduaine("Vorst", 25.0, 15.0, 5.0);

        // loome toiukomponendid
        Toidukomponent kartulikomponent = new Toidukomponent(750,kartul, "leib");
        Toidukomponent hapukoorkomponent = new Toidukomponent(275,hapukoor, "Hapukoor");
        Toidukomponent vorstikomponent = new Toidukomponent(150, vorst, "Vorst");

        // arvutame toidukomponendi sees leiduva rasvakoguse
        String rasv1 = hapukoorkomponent.arvutaRasvakogus();
        System.out.println(rasv1);
        String rasv2 = kartulikomponent.arvutaRasvakogus();
        System.out.println(rasv2);
        String rasv3 = vorstikomponent.arvutaRasvakogus();
        System.out.println(rasv3);

        // loome uue toidu
        Toit salat = new Toit("võileib");
        salat.lisaKomponent(kartulikomponent);
        salat.lisaKomponent(hapukoorkomponent);
        salat.lisaKomponent(vorstikomponent);


        //salati valkude, rasvade ja süsivesikute kogus
        double valkudeKogus = salat.arvutaValkudeKogus();
        double rasvadeKogus = salat.arvutaRasvadeKogus();
        double sysivesikuteKogus = salat.arvutaSysivesikuteKogus();
        System.out.println("Salati valgud: " + valkudeKogus);
        System.out.println("Salati rasvad: " + rasvadeKogus);
        System.out.println("Salati süsivesikud: " + sysivesikuteKogus);

        // salati koguse arvutus
        double toiduKogus= salat.arvutaKogused();
        System.out.println("Salati kogus: "+toiduKogus+" grammi.");

        // tekstifaili lisamine
        String test2= salat.tekstiPanek2();
        System.out.println(test2);

        // failist lugemine
        BufferedReader br = new BufferedReader(new FileReader("test2.txt"));
        String rida = br.readLine();
        while (rida != null) {
            System.out.println(rida);
            rida = br.readLine();
        }
    }

    }


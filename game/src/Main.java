import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // saab enda terve hunniku funktsioone ja muutujaid
        Random random = new Random();

        Maailm maailm =new Maailm(5,10);
        Mangija mangija = new Mangija(random, maailm);
        Draakon draakon = new Draakon(random, maailm);
        Ork ork = new Ork(random, maailm);

        // klass
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt

        maailm.prindiKaart(maailm, mangija, draakon, ork);
        String sisend = scanner.nextLine();

        mangija.liigu(sisend);
        maailm.prindiKaart(maailm, mangija, draakon, ork);


        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(maailm, mangija, draakon, ork);
            sisend = scanner.nextLine();
            mangija.liigu(sisend);
        }

    } // main (args[])

} // Main ()
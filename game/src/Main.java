import java.util.ArrayList;
import java.util.List;
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
        List<Tegelane> tegelased =new ArrayList<>();
        tegelased.add(ork);
        tegelased.add(draakon);
        tegelased.add(mangija);

        Ese m66k = new Ese("Mõõk", 10, 1, maailm, random);
        Ese haamer = new Ese("Haamer", 5, 3, maailm, random);
        Ese saabas = new Ese("Saabas", 1, 5, maailm, random);
        List<Ese> esemed = new ArrayList<>();

        Soiduk lada = new Soiduk("Lada", 5, random, maailm);
        Soiduk opel = new Soiduk("Opel Astra", 10, random, maailm);
        List<Soiduk> soidukid=new ArrayList<>();

        soidukid.add(lada);
        soidukid.add(opel);

        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        // klass
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt
        maailm.prindiKaart(maailm, mangija, draakon, ork, esemed, soidukid, tegelased);

        String sisend = scanner.nextLine();
        mangija.liigu(sisend,maailm);


        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(maailm, mangija, draakon, ork, esemed, soidukid, tegelased);
            sisend = scanner.nextLine();
            mangija.liigu(sisend,maailm);
            for(Ese e : esemed) {
                if (mangija.xCoord ==e.xCoord && mangija.yCoord ==e.yCoord){
                  mangija.ese=e;
                    System.out.println("Korjasid üles eseme: "+e.nimetus);
                  break;
                }//if
            }//for
            for(Soiduk s : soidukid) {
                if (mangija.xCoord ==s.xCoord && mangija.yCoord ==s.yCoord){
                    mangija.soiduk=s;
                    System.out.println("Said endale auto: "+s.nimetus);
                    break;
                }//if
            }
        } // while

    } // main (args[])

} // Main ()
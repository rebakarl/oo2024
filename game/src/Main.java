import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //näited muutujatest
      /*  String sona="Karl"; // sõna = string
        char esitaht='M'; //üks täht = char
        int taisarv=3223232;
        long andmebaas=23321123;
        byte pilt=126;*/


        Random random=new Random();
        int kaardiKorgus=5;
        int kaardiLaius=10;

        int mangijaXCoord= saaKoordinaat(random, kaardiLaius);
        int mangijaYCoord= saaKoordinaat(random, kaardiKorgus);
        char mangijaSymbol='x';

        int draakonXCoord= saaKoordinaat(random, kaardiLaius);
        int draakonYCoord= saaKoordinaat(random, kaardiKorgus);
        char draakonSymbol='d';

        int orkXCoord= saaKoordinaat(random, kaardiLaius);
        int orkYCoord= saaKoordinaat(random, kaardiKorgus);
        char orkSymbol='o';

        Scanner scanner = new Scanner(System.in); //järgmise tunni teema



         // siia korrektne for tsükkel alt // joon all, siis muutuv muutuja
        prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
        String sisend = scanner.nextLine();

        switch(sisend){
            case"w" ->mangijaYCoord--;
            case"s" ->mangijaYCoord++;
            case"a" ->mangijaXCoord--;
            case"d" ->mangijaXCoord++;
        }

        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
            sisend = scanner.nextLine();
            switch (sisend) {
                case "w" -> mangijaYCoord--;
                case "s" -> mangijaYCoord++;
                case "a" -> mangijaXCoord--;
                case "d" -> mangijaXCoord++;
            }
        }
/*      if (boolean || andmebaasiküsimine())
        if (boolean && andmebaasiküsimine()) -> andmebaasiküsimine resursimahukas, jätta teiseks!*/


    } //main args

    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, int mangijaXCoord, int mangijaYCoord, char mangijaSymbol, int draakonXCoord, int draakonYCoord, char draakonSymbol, int orkXCoord, int orkYCoord, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangijaXCoord && y == mangijaYCoord) {
                        symbol = mangijaSymbol;
                    } else if (x == draakonXCoord && y == draakonYCoord) {
                        symbol = draakonSymbol;
                    } else if (x == orkXCoord && y == orkYCoord) {
                        symbol = orkSymbol;
                    } else  {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
} //main
public class Maailm {

    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius){
        kaardiKorgus=korgus;
        kaardiLaius=laius;
    }

    public void prindiKaart(Maailm maailm, Mangija mangija , Draakon draakon, Ork ork) {
        for (int y = 0; y < maailm.kaardiKorgus; y++) {
            for (int x = 0; x < maailm.kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == maailm.kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == maailm.kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangija.xCoord && y == mangija.yCoord) {
                        symbol = mangija.symbol;
                    } else if (x == draakon.xCoord && y == draakon.yCoord) {
                        symbol = draakon.symbol;
                    } else if (x == ork.xCoord && y == ork.yCoord) {
                        symbol = ork.symbol;
                    } else  {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}

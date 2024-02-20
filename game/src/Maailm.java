import java.util.List;

public class Maailm {

    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius){
        kaardiKorgus=korgus;
        kaardiLaius=laius;
    }

    public void prindiKaart(Maailm maailm, Mangija mangija , Draakon draakon, Ork ork, List<Ese> esemed, List<Soiduk> soidukid, List<Tegelane> tegelased) {
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
                        symbol=' ';
                        for (Ese e: esemed){
                            if (e.xCoord == x && e.yCoord == y){
                                symbol=e.symbol;
                            }
                        }
                        for (Tegelane t: tegelased){
                            if (t.xCoord == x && t.yCoord == y){
                                symbol=t.symbol;
                            }
                        }

                        for (Soiduk s: soidukid){
                            if (s.xCoord == x && s.yCoord == y){
                                symbol=s.symbol;
                            }
                        }
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}

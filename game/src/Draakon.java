import java.util.Random;

public class Draakon {
    int xCoord;
    int yCoord;
    char symbol;


    public Draakon(Random random, Maailm maailm) {
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        symbol = 'd';
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }


} //draakon sulgemine

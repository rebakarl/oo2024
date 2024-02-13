import java.util.Random;

public class Ork {
    int xCoord;
    int yCoord;
    char symbol = 'O';

    public Ork(Random random, Maailm maailm) {
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        symbol = '0';
    }
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}

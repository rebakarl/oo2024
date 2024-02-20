import java.util.Random;

public class Soiduk {
    String nimetus;
    int kiirus;
    int xCoord;
    int yCoord;
    char symbol;

    public Soiduk(String nimetus, int kiirus, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.kiirus = kiirus;
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'S';
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}

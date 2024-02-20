import java.util.Random;

public class Ork extends Tegelane implements JuhuslikKoordinaat{


    public Ork(Random random, Maailm maailm) {
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        symbol = '0';
    }
    public int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}

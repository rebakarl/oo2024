import java.util.Random;

public class Draakon extends Tegelane implements JuhuslikKoordinaat{


    public Draakon(Random random, Maailm maailm) {
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        symbol = 'd';
    }

    public int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }


} //draakon sulgemine

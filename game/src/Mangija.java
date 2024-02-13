import java.util.Random;

public class Mangija {
    int xCoord; // deklareerin (loob + mälukoht)
    int yCoord; // parem klõps tema peal -> refactor -> rename
    char symbol;
    Suund suund;

    public Mangija(Random random, Maailm maailm) {
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        symbol = 'x';
        suund= Suund.YLES;
    }

    public void liigu(String sisend) {
        switch (sisend) {
            case "w" -> suund = Suund.YLES;
            case "s" -> suund= Suund.ALLA;
            case "a" -> suund= Suund.VASAKULE;
            case "d" -> suund= Suund.PAREMALE;
        } // switch() kinniminek
        switch (suund) {
            case YLES -> yCoord--;
            case ALLA -> yCoord++;
            case VASAKULE -> xCoord--;
            case PAREMALE -> xCoord++;
        } // switch() kinniminek
    } // liigu() kinniminek

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // <-- Mangija kinniminek
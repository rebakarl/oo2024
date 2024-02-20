import java.util.Random;

public class Ese {

    String nimetus;
    double tugevus;
    int kasutuskorrad;
    boolean aktiivne;
    int xCoord;
    int yCoord;
    char symbol;

    public Ese(String nimetus, double tugevus, int kasutuskorrad, Maailm maailm, Random random) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskorrad = kasutuskorrad;
        this.aktiivne = true;
        xCoord = saaKoordinaat(random, maailm.kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol='I';
    }//ese
    public void hit(){
        System.out.println("Lõid vastast!");
    }//hit
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}//klass

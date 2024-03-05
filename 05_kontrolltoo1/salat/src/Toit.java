import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class Toit {
    public String nimetus;
    public List<Toidukomponent> toidukomponendid;

    public Toit(String nimetus) {
        this.nimetus = nimetus;
        this.toidukomponendid = new ArrayList<>();
    }


    // listi lisamiseks/eemaldamiseks
    public void lisaKomponent(Toidukomponent toidukomponent) {
        toidukomponendid.add(toidukomponent);
    }
    public void eemaldakomponent(Toidukomponent toidukomponent) {
        toidukomponendid.remove(toidukomponent);
    }

    // arvutuste funktsioonid - valk, rasv, sysivesik
    public double arvutaValkudeKogus() {
        double valkudeKogus = 0;
        for (Toidukomponent toidukomponent : toidukomponendid) {
            valkudeKogus += (toidukomponent.getKogus() / 100) * toidukomponent.getToiduaine().getValguProtsent();
        }
        return valkudeKogus;
    }

    public double arvutaRasvadeKogus() {
        double rasvadeKogus = 0;
        for (Toidukomponent toidukomponent : toidukomponendid) {
            rasvadeKogus += (toidukomponent.getKogus() / 100) * toidukomponent.getToiduaine().getRasvaProtsent();
        }
        return rasvadeKogus;
    }
    public double arvutaSysivesikuteKogus() {
        double valkudeKogus = 0;
        for (Toidukomponent toidukomponent : toidukomponendid) {
            valkudeKogus += (toidukomponent.getKogus() / 100) * toidukomponent.getToiduaine().getSysivesikuProtsent();
        }
        return valkudeKogus;
    }
    public double arvutaKogused(){
        double toiduKogus=0;
        for (Toidukomponent toidukomponent : toidukomponendid){
            toiduKogus+=(toidukomponent.getKogus());
        }
        return toiduKogus;
    }

    //tekstifaili kirjtuamine
    public String tekstiPanek2() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("test2.txt"));
        for (Toidukomponent toidukomponent : toidukomponendid){

            String toiduNimetus=(toidukomponent.getNimetus());
            pw.println("Toidukomponent nimetus: "+toiduNimetus);
            double toiduKogus=(toidukomponent.getKogus());
            pw.println("Kogus: "+toiduKogus);
            String toiduaine=(toidukomponent.getToiduaine().getNimetus());
            pw.println("Toiduaine: "+toiduaine);
            double valgud=(toidukomponent.getToiduaine().valguProtsent);
            pw.println("Aine valgud: "+valgud);
            double sysiv=(toidukomponent.getToiduaine().sysivesikuProtsent);
            pw.println("Aine süsivesik: "+sysiv);
            double rasv=(toidukomponent.getToiduaine().rasvaProtsent);
            pw.println("Aine rasv: "+rasv);

        }
        pw.close();
        return "Andmed lisatud2";
    }

}
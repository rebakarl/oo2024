import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Email {
        String eesnimi;
        String perenimi;
        String emailiaadress;
        LocalDate liitumisaeg;
        LocalDate lopetamisaeg;


    public Email(String eesnimi, String perenimi,String emailiaadress, LocalDate liitumisaeg) {
        this.eesnimi=eesnimi;
        this.perenimi=perenimi;
        this.emailiaadress=emailiaadress;
        this.liitumisaeg=liitumisaeg;
        this.lopetamisaeg=null;
    }
    public String kauaKasutanud(String eesnimi, String emailiaadress){
        long aeg=ChronoUnit.DAYS.between(liitumisaeg,LocalDate.now());
        return eesnimi+" on kasutanud teenust: "+aeg+" päeva.";
    }

    public String lopetaTellimus(LocalDate lopetamine, String email){
        if(this.emailiaadress.equals(email)){
        this.lopetamisaeg=lopetamine;
        return emailiaadress+" teenus lõpetatakse "+ lopetamisaeg+" kuupäeval.";
    }else{
            return "Email ei ole korrektne.";
        }
    }

    }//lopp


class Omanik {
    String nimi;
    String telefon;
    String email;
    Loom loom;

    //konstruktor
    public Omanik(String nimi, String telefon, String email, Loom loom) {
        this.nimi = nimi;
        this.telefon = telefon;
        this.email = email;
        this.loom=loom;
    }

    // omaniku funktsioonid

    public String getOmanik() {
        return "Nimi: "+ nimi + "; Telefon: "+ telefon + "; Email: "+ email + "; Looma nimi :"+loom.getNimi();
    }

    public void muudaNime(String uusNimi){
        nimi=uusNimi;
    }
}
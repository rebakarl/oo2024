class Loom {
    String nimi;
    int vanus;
    String liik;

    //looma konstruktor
    public Loom(String nimi, int vanus, String liik) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.liik = liik;
    }

    //looma funktsioonid
    public String getNimi() {
        return nimi;
    }

    public int getVanus() {
        return vanus;
    }

    public String getLiik() {
        return liik;
    }

    public void getLoom(){
        System.out.println("__________________________________");
        System.out.println("Looma nimi: "+ getNimi());
        System.out.println("Looma vanus: "+getVanus());
        System.out.println("Looma liik: "+getLiik());
    }

    public void muudaNime(String uusNimi){
        nimi=uusNimi;
    }
}
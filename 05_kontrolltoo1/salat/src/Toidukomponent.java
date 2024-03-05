public class Toidukomponent {
    public double kogus;
    public Toiduaine toiduaine;
    public String nimetus;

    public Toidukomponent(double kogus, Toiduaine toiduaine, String nimetus) {
        this.kogus = kogus;
        this.toiduaine = toiduaine;
        this.nimetus=nimetus;
    }

    public String getNimetus(){return nimetus;}
    public double getKogus() {
        return kogus;
    }

    public Toiduaine getToiduaine() {
        return toiduaine;
    }

    public String arvutaRasvakogus() {
            double rasv = (this.kogus / 100) * 10;
            return this.nimetus +" rasvakogus on: "+ rasv + "g";
    }


}
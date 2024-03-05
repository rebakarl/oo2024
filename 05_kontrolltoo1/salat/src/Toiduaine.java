public class Toiduaine {
    public String nimetus;
    public double valguProtsent;
    public double rasvaProtsent;
    public double sysivesikuProtsent;

    public Toiduaine(String nimetus, double valguProtsent, double rasvaProtsent, double sysivesikuProtsent) {
        this.nimetus = nimetus;
        this.valguProtsent = valguProtsent;
        this.rasvaProtsent = rasvaProtsent;
        this.sysivesikuProtsent = sysivesikuProtsent;
    }

    public String getNimetus() {
        return nimetus;
    }

    public double getValguProtsent() {
        return valguProtsent;
    }

    public double getRasvaProtsent() {
        return rasvaProtsent;
    }

    public double getSysivesikuProtsent() {
        return sysivesikuProtsent;
    }
}
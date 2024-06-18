package ee.tlu.Kodutoo04;

import lombok.Getter;

@Getter
public class Mang{
    int id;
    String nimi;
    int mangijateArv;
    int kestus;
    int punktiskoor;

    public Mang(int id, String nimi, int mangijateArv, int kestus, int punktiskoor) {
        this.id =id;
        this.nimi = nimi;
        this.mangijateArv = mangijateArv;
        this.kestus = kestus;
        this.punktiskoor = punktiskoor;
    }
}
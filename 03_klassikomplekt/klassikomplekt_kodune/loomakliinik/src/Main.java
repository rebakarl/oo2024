public class Main {
    public static void main(String[] args) {
        Loom koer = new Loom("Basse", 6, "Labrador");
        Omanik omanik = new Omanik("Juhan", "55556666", "juhanj@tlu.ee", koer);

        String omanik1 = omanik.getOmanik();
        System.out.println(omanik1);

        omanik.muudaNime("Jarmo");
        String omanik2 = omanik.getOmanik();
        System.out.println(omanik2);

        omanik.loom.getLoom();
        omanik.loom.muudaNime("Roki");
        omanik.loom.getLoom();
    }
}
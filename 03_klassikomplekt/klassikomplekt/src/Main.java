public class Main {
    public static void main(String[] args) {

        Info info = new Info("MacBook", 16, "Intel");
        Arvuti arvuti = new Arvuti(info, 1000, "Kristiine");
        arvuti.muudaPoodi("Mustamäe");
        arvuti.info.muudaNimetus("Mac Pro");

        Arvuti arvuti2 = new Arvuti(
                new Info("Dell", 32, "Intel"),
                1100, "Ülemiste");
        arvuti2.paneAllahindlus(200);
    }
}

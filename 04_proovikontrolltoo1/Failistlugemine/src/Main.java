import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
//import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("lugemine.txt"));
        String rida = br.readLine();
        //System.out.println(rida);
        while (rida != null) {
            System.out.println(rida);

            //võtab U välja
            String[] tykeldus = rida.split("u");
            System.out.println(Arrays.toString(tykeldus));
            System.out.println(tykeldus.length);

            //ruutu panemine
            double ruut = Math.pow(tykeldus.length, 2);
            System.out.println(ruut);

            //ruutjuur
            double ruutjuur = Math.sqrt(tykeldus.length);
            System.out.println(ruutjuur);
            rida = br.readLine();
        }
    }
}
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("valjund1.txt"));
        pw.println(("Tereteretere"));
        pw.print("Juku");
        pw.print("Malle");
        pw.print(" Mari");
        pw.println(" Malle");
        pw.print("Uus rida");
        pw.close();
    }
}
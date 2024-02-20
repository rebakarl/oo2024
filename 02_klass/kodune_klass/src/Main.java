import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Main class + Enda tehtud class
        // Classis constructor
        // vähemalt 2 omadust
        // vähemalt 2 funktsiooni

        // Mainis vähemalt kaks instantsi temast
        // Mainis vähemalt 2 funktsiooni väljakutset
        // vähemalt 2 System.out.println()

Email email1= new Email("Karl", "Kaalikas", "kkaalikas@tlu.ee", LocalDate.of(2023,1,1));
Email email2= new Email("Joonas", "Juurikas", "jjuurikas@tlu.ee", LocalDate.of(2024,2,1));

       String kasutanud1= email1.kauaKasutanud("Karl","kkaalikas@tlu.ee");
        System.out.println(kasutanud1);

        String kasutanud2=email2.kauaKasutanud("Joonas", "jjuurikas@tlu.ee");
        System.out.println(kasutanud2);

        String lopeta1= email1.lopetaTellimus(LocalDate.now(), "kkaalikas@tlu.ee");
        System.out.println(lopeta1);

        String lopeta2= email2.lopetaTellimus(LocalDate.of(2024,3,1),"jkaro@tlu.ee");
        System.out.println(lopeta2);


    }//main public
}//main class
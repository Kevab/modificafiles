import java.io.File;
import java.util.Scanner;

public class Main {

// Leggo Nomi File
// Filtro per estensione
// Filtro i nomi togliendo i char
// Modifico i nomi nella stessa cartella

    private static Services services = new Services();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Cartella file da modificare
        // String pathIN = "C:\\Users\\Daniel\\Desktop\\Testing\\a\\";
        System.out.println("C:\\Users\\Daniel\\Desktop\\Testing\\a\\");

        System.out.println("\nDove sono i file da rinominare? (Path)");
        String pathIN = input.nextLine();

        File tmpe = new File(pathIN);
        if (!tmpe.isDirectory()) {
            System.out.println("Non è una directory");
        } else {
            // File[] listFiles() : Returns an array of abstract pathnames denoting the files in the directory.
            File dir = new File(pathIN);
            File[] listaFile = dir.listFiles();
            services.stampaListaFiles(listaFile);

            // String[] list() : Returns an array of strings naming the files and directories in the directory .
            String[] listaFileS = dir.list();
            services.stampaListaFiles(listaFileS);

            //Decido l'estensione dei file che voglio modificare
            // (.txt ; .jpg ; .avi ; .mp4 ...)
            System.out.println("Inserisci l'estensione da filtrare, se non c'è premi invio");
            String extension = input.nextLine();

            if (extension.length() <= 0) {
                System.out.println("No extension, modifico tutto");
                services.filtraSeparatori(listaFileS, listaFile, pathIN);
            } else {
                System.out.println("Hai inserito l'estensione: " + extension);
                services.filtraSeparatori(listaFileS, listaFile, pathIN, extension);
            }


            File new_dir = new File(pathIN);
            String[] listaFileNuova = new_dir.list();
            services.stampaListaFiles(listaFileNuova);
        }
    }
}

import java.io.File;
import java.util.ArrayList;

public class Services {

    final String[] separator = new String[]{"-", "_", "}", "\\{", "\\[", "]"};

    // Stampa la lista dei Files (Tipizzato: File)
    public void stampaListaFiles(File[] lista_F) {
        System.out.println("\n---> Files List <---");
        for (File f : lista_F)
            System.out.println(f.toString());
        System.out.println("-----------------------");
    }

    // Stampa la lista dei nomi dei Files (Tipizzato: String)
    public void stampaListaFiles(String[] lista_S) {
        System.out.println("\n---> String List <---");
        for (String s : lista_S)
            System.out.println(s);
        System.out.println("-----------------------");
    }

    // Filtro i valori che non voglio nel nome dei miei file
    public void filtraSeparatori(String[] listaFileS, File[] listaFile, String pathIN) {
        ArrayList<String> tmp = rinominaConSeparatori(listaFileS);

        for (File tmpF : listaFile)
            for (String tmpS : tmp)
                tmpF.renameTo(new File(pathIN + tmpS));
    }

    // Filtro i valori che non voglio nel nome dei miei file
    public void filtraSeparatori(String[] listaFileS, File[] listaFile, String pathIN, String exte) {
        ArrayList<String> cisiamo = new ArrayList<>();
        for (String str : listaFileS) {
            if (str.endsWith(exte)) {
                cisiamo.add(rinominaConSeparatori(str));
            }
            else
                cisiamo.add(str);
        }
        for (File tmpF : listaFile)
            for (String tmpS : cisiamo)
                tmpF.renameTo(new File(pathIN + tmpS));
    }

    // Rinomina i file togliendo i separator impostati
    public ArrayList<String> rinominaConSeparatori(String[] fileS) {

        ArrayList<String> tmp = new ArrayList<>();

        for (String s : fileS) {
            for (String sep : separator)
                s = s.replaceAll(sep, "");
            tmp.add(s);
        }
        return tmp;
    }

    // Rinomina i file togliendo i separator impostati
    public String rinominaConSeparatori(String fileS) {
        for (String sep : separator)
            fileS = fileS.replaceAll(sep, "");
        return fileS;
    }
}

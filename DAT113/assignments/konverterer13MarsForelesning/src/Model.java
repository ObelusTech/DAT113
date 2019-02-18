import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {
    public String hentFilData() {
        String s = "";
        try {

            FileReader f = new FileReader("Vitser.txt"); // Her skriver du navnet poo filen du skal lese
            BufferedReader b = new BufferedReader(f);
            String linje = b.readLine();
            while (linje != null) {

                s += linje + "\n";
                linje = b.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


}

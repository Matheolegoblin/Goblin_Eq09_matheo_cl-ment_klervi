import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/*public class ReadCSVData {
	private static final String CSV_FILE_CUSTOM_SEPARATOR 
    = "Jeux_de_donnees"+File.separator+"petit"+File.separator+"init-clients-30-10-Carre.csv"; 
@@ -20,4 +16,25 @@ public static void main(String[] args)
	}
}*/

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;	
import java.io.IOException;	
import java.util.List;

public class ReadCSVData {
    public static void main(String[] args) {
        String fileName = "Jeux_de_donnees/petit/init-clients-30-10-Carre.csv";

        try (FileReader reader = new FileReader(fileName)) {
            CsvToBean<Client> csvToBean = new CsvToBeanBuilder<Client>(reader)
                .withType(Client.class)
                .withSeparator(';')
                .build();

            List<Client> beans = csvToBean.parse();
            beans.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
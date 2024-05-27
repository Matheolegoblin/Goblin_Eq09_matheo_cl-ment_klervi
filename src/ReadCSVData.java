import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/*public class ReadCSVData {

	private static final String CSV_FILE_CUSTOM_SEPARATOR 
    = "Jeux_de_donnees"+File.separator+"petit"+File.separator+"init-clients-30-10-Carre.csv"; 
	
	public static void main(String[] args) 
	{ 
		List<Client> beans = new CsvToBeanBuilder(new FileReader(CSV_FILE_CUSTOM_SEPARATOR ))
				.withType(Client.class).withSeparator(';').build().parse();
		System.out.println(beans);


	}

}*/

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
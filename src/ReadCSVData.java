import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.util.List;


import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCSVData {

	private static final String CSV_FILE_CUSTOM_SEPARATOR 
    = "Jeux_de_donnees"+File.separator+"petit"+File.separator+"init-clients-30-10-Carre.csv"; 
	
	public static void main(String[] args) 
	{ 
		List<Client> beans = new CsvToBeanBuilder(new FileReader(CSV_FILE_CUSTOM_SEPARATOR ))
				.withType(Client.class).withSeparator(';').build().parse();
		System.out.println(beans);


	}

}
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

public class Client {
	
	 @CsvBindByName (column = "nom", required = true)
	    private String Nom;

	    @CsvBindByName (column = "mail", required = true)
	    private String Mail;

	    @CsvBindByName (column = "id site", required = true)
	    private int idWebsite;

	    /*List<Client> beans = new CsvToBeanBuilder(new FileReader("Jeux_de_donnees"+File.separator+"petit"+File.separator+"init-clients-30-10-Carre.csv"))
	    		.withType(Client.class).build().parse();*/
	    // Getters and setters go here.
	    
}


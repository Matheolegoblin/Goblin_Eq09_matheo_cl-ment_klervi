import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*public class CSVToDatabase{

	try { 
	    // Create an object of file reader 
	    // class with CSV file as a parameter. 
	    FileReader filereader = new FileReader("Jeux_de_donnees"+File.separator+"petit"+File.separator+"init-clients-30-10-Carre.csv");
	    
	    // create csvParser object with 
	    // custom separator semi-colon 
	    CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); 
	
	    // create csvReader object and skip first Line 
	    CSVReader csvReader = new CSVReaderBuilder(filereader) 
	    						.withCSVParser(parser) 
	    						.build();
	    List<String[]> allData = csvReader.readAll(); 
	
	    // Print Data. 
	    for (String[] row : allData) { 
	        for (String cell : row) { 
	            System.out.print(cell + "\t"); 
	        } 
	        System.out.println(); 
	    }
	} 
	catch (Exception e) { 
	    e.printStackTrace(); 
	} 
}
}*/

public class Main 
{
  //Délimiteurs qui doivent être dans le fichier CSV
  private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
    
    //En-tête de fichier
    private static final String HEADER = "Nom,Email,Idsite";
    
    public static void main(String args[])
    {
      //Création des objets
      Book book1 = new Book("Darkness to Light", "Lamar Odam", 1992);
      Book book2 = new Book("We Are Displaced", "Malala Yousafzai", 1981);
      Book book3 = new Book("I Am Malala", "Christina Lamb", 1978);
      Book book4 = new Book("Girl Women", "Satyarth Nayak", 1966);
      Book book5 = new Book("Forgotten Past", "Peter Baker", 1971);
      //Ajouter les objets à la liste
      List bookList = new ArrayList();
      bookList.add(book1);
      bookList.add(book2);
      bookList.add(book3);
      bookList.add(book4);
      bookList.add(book5);
      
      FileWriter file = null;
      
      try
      {
        file = new FileWriter("Book.csv");
        //Ajouter l'en-tête
        file.append(HEADER);
        //Ajouter une nouvelle ligne après l'en-tête
        file.append(SEPARATOR);
        //Itérer bookList
        Iterator it = bookList.iterator();
        while(it.hasNext())
        {
          Book b = (Book)it.next();
          file.append(b.getTitle());
          file.append(DELIMITER);
          file.append(b.getAuthor());
          file.append(DELIMITER);
          file.append(String.valueOf(b.getYear()));
          file.append(SEPARATOR);
        }
      
        file.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
}



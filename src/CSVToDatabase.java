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

public class CSVToDatabase{

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
}



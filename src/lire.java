
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class lire {
	public static void main(String[] args) {
		String cheminFichier = "csv"+File.separator+"bordereautest.csv";

		try (CSVReader csvReader = new CSVReader(new FileReader(cheminFichier))) {
			String[] ligne;
			while ((ligne = csvReader.readNext()) != null) {
				// Afficher chaque ligne du fichier CSV
				//Pour chaque ligne, une boucle for est utilisée pour afficher chaque cellule.
				for (String cellule : ligne) {
					System.out.print(cellule + " ");
				}
				System.out.println();
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}System.out.println("Validez-vous cette livraison?(oui/ non)");
		Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        if (reponse == "oui") {
        	
        }
	}
	
	

} 

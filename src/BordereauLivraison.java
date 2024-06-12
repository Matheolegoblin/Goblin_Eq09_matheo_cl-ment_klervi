import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;

public class BordereauLivraison extends ReadJsonData{

	BordereauLivraison(){

	}



	public static void writeAllLines(List<String[]> lines, Path path) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
			writer.writeAll(lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public static void main(String [] args) {

		JsonObject jsonObject = readJson();

		if (jsonObject != null) {
			// Extraction des données
			JsonArray deliveriesForCustomer = jsonObject.getAsJsonArray("deliveriesfor_customer");

			// Conversion des données en format CSV
			List<String[]> data = new ArrayList<>();
			data.add(new String[]{"deliveriesfor_customer"});

			for (int i = 0; i < deliveriesForCustomer.size(); i++) {
				data.add(new String[]{"Le client " + (i + 1) + " est livré par entrepot " + deliveriesForCustomer.get(i).getAsInt()});
			}

			//Chemin du fichier CSV enregistrer
			Path path = Paths.get("csv"+ File.separator +"bordereautest.csv");

			// Écriture des données dans le fichier CSV
			writeAllLines(data, path);


			System.out.println("CSV file created successfully at: " + path.toString());
		} else {
			System.out.println("Failed to read JSON data.");
		}
	}
}
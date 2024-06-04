import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.opencsv.CSVWriter;

public class ReadJasonData {
	public static void main(String args[]) {

		//Lecture du fichier Json
		String url = File.separator+"Users"+File.separator+"clementcardona"+File.separator+"Documents"+File.separator+"Cours"+File.separator+"Informatique"+File.separator+"Gobelin"+File.separator+"Exemples de fichiers json-20240515"+File.separator+"solution-mini.json";
		JsonReader reader = null;
		try {
			reader = new JsonReader(new InputStreamReader(new FileInputStream(url)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = jsonParser.parse(reader).getAsJsonObject();

		//Extraction des données
		String status = jsonObject.get("status").getAsString();
		JsonArray openFacilities = jsonObject.getAsJsonArray("openfacilities");
		JsonArray deliveriesForCustomer = jsonObject.getAsJsonArray("deliveriesfor_customer");
		double objective = jsonObject.get("objective").getAsDouble();

		//Conversion des données en format CSV
		List<String[]> data = new ArrayList<>();
		data.add(new String[]{"status", "openfacilities", "deliveriesfor_customer", "objective"});
		data.add(new String[]{status, openFacilities.toString(), deliveriesForCustomer.toString(), String.valueOf(objective)});

		//Chemin du fichier CSV enregistrer
		Path path = Paths.get("csv"+ File.separator +"bordereautest.csv");

		// Écriture des données dans le fichier CSV
		writeAllLines(data, path);

		System.out.println("CSV file created successfully at: " + path.toString());

	}
	
	public static void writeAllLines(List<String[]> lines, Path path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(lines);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

}


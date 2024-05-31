import java.io.*;

import org.apache.commons.collections4.bloomfilter.LayerManager;
import org.apache.commons.collections4.bloomfilter.LayerManager.Builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class ReadJasonData {
	public static void main(String args[]) {
		/*JsonParser jsonP = new JsonParser();
	      try {
	         JsonObject jsonO = (JsonObject)jsonP.parse(new FileReader(File.separator+"Users"+File.separator+"clementcardona"+File.separator+"Documents"+File.separator+"Cours"+File.separator+"Informatique"+File.separator+"Gobelin"+File.separator+"Exemples de fichiers json-20240515"+File.separator+"solution-mini.json"));

	         JsonElement name = (JsonElement) jsonO.get("capacity_facility");
	         JsonElement age = (JsonElement) jsonO.get("fixed_cost_facility");
	         JsonElement address = (JsonElement) jsonO.get("demand_customer");

	         System.out.println("capacity_facility :"+ name);
	         System.out.println("fixed_cost_facility : "+ age);
	         System.out.println("demand_customer :"+ address);

	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (JsonParseException e) {
	         e.printStackTrace();
	      }*/

		String url = File.separator+"Users"+File.separator+"clementcardona"+File.separator+"Documents"+File.separator+"Cours"+File.separator+"Informatique"+File.separator+"Gobelin"+File.separator+"Exemples de fichiers json-20240515"+File.separator+"solution-mini.json";
		JsonReader reader = new JsonReader(new InputStreamReader(
				new FileInputStream(url)));
		JsonParser jsonParser = new JsonParser();
		JsonObject userArray = jsonParser.parse(reader).getAsJsonObject();
		System.out.println(userArray);
		JsonArray objets = userArray.getAsJsonArray("Objets ");
		System.out.println(objets);
		
		LayerManager CsvSchema;
		Builder csvSchemaBuilder = CsvSchema.builder();
		JsonObject firstObject = jsonTree.elements().next();
		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
	}

}

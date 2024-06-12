import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.opencsv.CSVWriter;

public class ReadJsonData {

	private static final String url = "Jeux_de_donnees"+File.separator+"solution-mini.json";

	ReadJsonData(){

	}


	public static JsonObject readJson() {
		Gson gson = new Gson();
		JsonObject jsonObject = null;
		JsonParser jsonParser = new JsonParser();

		// Lecture du fichier Json
		try (FileReader reader = new FileReader(url)) {
			jsonObject = jsonParser.parse(reader).getAsJsonObject();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	public static void main(String [] args) {

	}

}


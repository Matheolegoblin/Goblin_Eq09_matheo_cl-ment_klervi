import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.JsonObject;



public class JsonDataWriter {
	    public static void main(String[] args) {
	        JsonObject jsonObject = new JsonObject();
	        String filePath = "json"+File.separator+"fichier.json";
	        try (FileWriter file = new FileWriter(filePath)) {
	            file.write(jsonObject.toString());
	            file.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Fichier JSON créé avec succès !");
	    }
	}

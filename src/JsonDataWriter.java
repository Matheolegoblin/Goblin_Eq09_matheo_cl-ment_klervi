import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.JsonObject;



public class JsonDataWriter {
	    public static void main(String[] args) {
	        JsonObject jsonObject = new JsonObject();
	        try (FileWriter file = new FileWriter("C:\\Users\\mathe\\Downloads\\MdrcaMarche.json")) {
	            file.write(jsonObject.toString());
	            file.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Fichier JSON créé avec succès !");
	    }
	}

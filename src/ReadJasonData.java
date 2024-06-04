	import java.io.*;

	import com.google.gson.JsonElement;
	import com.google.gson.JsonObject;
	import com.google.gson.JsonParseException;
	import com.google.gson.JsonParser;

	public class ReadJasonData {
	   public static void main(String args[]) {
	      JsonParser jsonP = new JsonParser();
	      try {
	         JsonObject jsonO = (JsonObject)jsonP.parse(new FileReader("json"+file.seperator+"fichier.json"));
	    	  
	         JsonElement name = (JsonElement) jsonO.get("capacity_facility");
	         JsonElement cout = (JsonElement) jsonO.get("fixed_cost_facility");
	         JsonElement address = (JsonElement) jsonO.get("demand_customer");

	         System.out.println("capacity_facility :"+ name);
	         System.out.println("fixed_cost_facility : "+ cout);
	         System.out.println("demand_customer :"+ address);
	         
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (JsonParseException e) {
	         e.printStackTrace();
	      }
	   }
	}

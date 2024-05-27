import com.opencsv.bean.CsvBindByName;

public class Routes {

	@CsvBindByName (column = "origine", required = true)
	private int Origine;

	@CsvBindByName (column = "destination", required = true)
	private int Destination;

	
	public Routes( int origine, int destination) {
		this.Origine = origine;
		this.Destination = destination;
	}
	
	/**
	 * @return the origine
	 */
	public int getOrigine() {
		return Origine;
	}

	/**
	 * @return the destination
	 */
	public int getDestination() {
		return Destination;
	}

	/**
	 * @param origine the origine to set
	 */
	public void setOrigine(int origine) {
		Origine = origine;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(int destination) {
		Destination = destination;
	}
}


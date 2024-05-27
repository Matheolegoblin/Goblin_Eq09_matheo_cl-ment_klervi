import com.opencsv.bean.CsvBindByName;

public class Sites {

	@CsvBindByName (column = "id site", required = true)
	private int IdSite;

	@CsvBindByName (column = "x", required = true)
	private int X;
	
	@CsvBindByName (column = "y", required = true)
	private int Y;

	
	public Sites( int idsite, int x, int y) {
		this.IdSite = idsite;
		this.X = x;
		this.Y = y;
	}
	
	/**
	 * @return the idsite
	 */
	public int getIdSite() {
		return IdSite;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return X;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * @param idsite the idsite to set
	 */
	public void setIdSite(int idsite) {
		IdSite = idsite;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		X = x;
	}
	
	/**
	 * @param x the x to set
	 */
	public void setY(int y) {
		Y = y;
	}
	
}

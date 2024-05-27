import com.opencsv.bean.CsvBindByName;

public class Entrepots {

	@CsvBindByName (column = "id entrepot", required = true)
    private int IdEntrepot;

    @CsvBindByName (column = "id site", required = true)
    private int IdSite;

    @CsvBindByName (column = "cout fixe", required = true)
    private int CoutFixe;
    
    @CsvBindByName (column = "stock", required = true)
    private int Stock;
    
    
    public Entrepots( int identrepot, int idsite, int cout, int stock) {
    	this.IdEntrepot = identrepot;
    	this.IdSite = idsite;
    	this.CoutFixe = cout;
    	this.Stock = stock;
    }
    
    /**
	 * @return the identrepot
	 */
	public int getIdEntrepot() {
		return IdEntrepot;
	}

	/**
	 * @return the idsite
	 */
	public int getIdSite() {
		return IdSite;
	}

	/**
	 * @return the cout fixe
	 */
	public int getCoutFixe() {
		return CoutFixe;
	}
	
	/**
	 * @return the stock
	 */
	public int getStock() {
		return Stock;
	}

	/**
	 * @param identrepot the identrepot to set
	 */
	public void setIdEntrepot(int identrepot) {
		IdEntrepot = identrepot;
	}

	/**
	 * @param idsite the idsite to set
	 */
	public void setIdSite(int idsite) {
		IdSite = idsite;
	}

	/**
	 * @param cout fixe the cout fixe to set
	 */
	public void setCoutFixe(int coutfixe) {
		this.CoutFixe = coutfixe;
	}
	
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.Stock = stock;
	}
    
    
}

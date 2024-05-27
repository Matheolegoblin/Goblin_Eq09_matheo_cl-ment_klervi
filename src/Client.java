import com.opencsv.bean.CsvBindByName;

public class Client {
	
	 @CsvBindByName (column = "nom", required = true)
	    private String Nom;

	    @CsvBindByName (column = "mail", required = true)
	    private String Mail;

	    @CsvBindByName (column = "id site", required = true)
	    private int idWebsite;

	    /*List<Client> beans = new CsvToBeanBuilder(new FileReader("Jeux_de_donnees"+File.separator+"petit"+File.separator+"init-clients-30-10-Carre.csv"))
	    		.withType(Client.class).build().parse();*/
	    public Client( String nom, String mail, int Id) {
	    	this.Nom = nom;
	    	this.Mail = mail;
	    	this.idWebsite = Id;
	    }

		/**
		 * @return the nom
		 */
		public String getNom() {
			return Nom;
		}

		/**
		 * @return the mail
		 */
		public String getMail() {
			return Mail;
		}

		/**
		 * @return the idWebsite
		 */
		public int getIdWebsite() {
			return idWebsite;
		}

		/**
		 * @param nom the nom to set
		 */
		public void setNom(String nom) {
			Nom = nom;
		}

		/**
		 * @param mail the mail to set
		 */
		public void setMail(String mail) {
			Mail = mail;
		}

		/**
		 * @param idWebsite the idWebsite to set
		 */
		public void setIdWebsite(int idWebsite) {
			this.idWebsite = idWebsite;
		}
	    
	    
	    
}


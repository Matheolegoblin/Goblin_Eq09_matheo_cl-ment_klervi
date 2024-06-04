import com.opencsv.bean.CsvBindByName;

public class Client {
    @CsvBindByName(column = "id site", required = true)
    private String idSite;

    @CsvBindByName(column = "mail", required = true)
    private String mail;

    @CsvBindByName(column = "nom", required = true)
    private String nom;

	public String getIdSite() {
        return idSite;
    }

    public void setIdSite(String idSite) {
        this.idSite = idSite;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasesJDBC {

	private static String url = "jdbc:hsqldb:file:database"+File.separator+"basic;shutdown=true";
	private static String login = "sa";
	private static String password = "";

	public static void MaJBdD() {

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			String requete = "UPDATE ENTREPOTS SET stock = '" +;
			try ( Statement statement = connection.createStatement() ) {
				try (ResultSet resultSet = statement.executeQuery( requete ) ) {	
				}

			}

			requete = "SELECT stock FROM ENTREPOTS";
			try ( Statement statement = connection.createStatement() ) {
				try (ResultSet resultSet = statement.executeQuery( requete ) ) {

					System.out.println("Stock mise a jour !");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Class.forName( "org.hsqldb.jdbcDriver" );
		try (Connection connection = DriverManager.getConnection( url, login, password )){

			String requete = "DROP TABLE COMMANDE IF EXISTS;" 
					+ "DROP TABLE ENTREPOTS IF EXISTS;"
					+"DROP TABLE ROUTES IF EXISTS;"
					+"DROP TABLE CLIENTS IF EXISTS;"
					+"DROP TABLE SITE IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}

			requete = "CREATE TABLE SITE ("
					+"id_site int,"
					+"x int,"
					+"y int,"
					+ "PRIMARY KEY(id_site))";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "CREATE TABLE CLIENTS ("
					+ "id_site int,"
					+ "mail varchar(50),"
					+ "nom varchar(20),"
					+ "PRIMARY KEY(mail),"
					+ "FOREIGN KEY(id_site) REFERENCES SITE(id_site))";

			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}

			requete = "CREATE TABLE ROUTES ("
					+"origine int,"
					+"destination int,"
					+"PRIMARY KEY(origine, destination))";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "CREATE TABLE ENTREPOTS ("
					+ "id_entrepot int,"
					+ "id_site int,"
					+ "cout_fixe int,"
					+ "stock int,"
					+ "PRIMARY KEY(id_entrepot),"
					+ "FOREIGN KEY(id_site) REFERENCES SITE(id_site))";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "CREATE TABLE COMMANDE ("
					+ "date int,"
					+ "mail varchar(50),"
					+ "quantite_demande int,"
					+ "entrepots_dispo int,"
					+ "id_entrepot int,"
					+ "PRIMARY KEY (date),"
					+ "FOREIGN KEY (mail) REFERENCES CLIENTS(mail),"
					+ "FOREIGN KEY (id_entrepot) REFERENCES ENTREPOTS(id_entrepot))";

			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}


			requete = "SELECT stock FROM ENTREPOTS";
			try ( Statement statement = connection.createStatement() ) {
				try (ResultSet resultSet = statement.executeQuery( requete ) ) {

					System.out.println("Table créer avec succés !");
				}
			}
		}
	}
}
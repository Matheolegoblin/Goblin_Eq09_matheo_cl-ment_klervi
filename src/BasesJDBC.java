import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BasesJDBC {
	public static void main(String[] args) throws Exception {
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:database"+File.separator+"basic;shutdown=true";
		String login = "sa";
		String password = "";
		try (Connection connection = DriverManager.getConnection( url, login, password )){

			String requete = "DROP TABLE CLIENTS IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "DROP TABLE SITES IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "DROP TABLE ROUTES IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "DROP TABLE ENTREPOTS IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "DROP TABLE COMMANDE IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "CREATE TABLE CLIENTS ("
					+"id site int,"
					+"mail varchar(50),"
					+"nom varchar(20),"
					+"PRIMARY KEY(mail)"
					+"FOREIGN KEY(id site) reference SITES(id site))";

			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}

			requete = "CREATE TABLE SITES ("
					+"id site int,"
					+"x int,"
					+"y int,"
					+ "PRIMARY KEY(id site))";
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
					+" id entrepot int,"
					+"id site int,"
					+ "cout fixe int,"
					+ " stock int,"
					+ "PRIMARY KEY (id entrepot)"
					+ " FOREIGN KEY (id site) reference SITES(id site))";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "CREATE TABLE COMMANDE ("
					+" date int,"
					+"mail varchar(50),"
					+ "quantite demande int,"
					+ "entrepots dispo int,"
					+"id entrepot int"
					+ "PRIMARY KEY (date)"
					+ "FOREIGN KEY (mail) reference CLIENTS(mail)"
					+ "FOREIGN KEY (id entrepot) reference ENTREPOTS(id entrepot))";

			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}

		}
	}
}
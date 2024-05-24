import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//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
public class BasesJDBC {
	public static void main(String[] args) throws Exception {
		Class.forName( "org.hsqldb.jdbcDriver" );
		String url = "jdbc:hsqldb:file:database"+File.separator+"basic;shutdown=true";
		String login = "sa";
		String password = "";
		
		try (Connection connection = DriverManager.getConnection( url, login, password )){
			String requete = "DROP TABLE client IF EXISTS;"+"DROP TABLE entrepot IF EXISTS;"
							  + "DROP TABLE site IF EXISTS;" + "DROP TABLE route IF EXISTS;" +"DROP TABLE demande IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
			statement.executeUpdate( requete );
			}	
			requete = "CREATE TABLE entrepot ("
					+"IDentrepot int,"
					+"Stock disponible int,"
					+"IDlocalisation int,";
					try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
					}
					
			requete = "CREATE TABLE client ("
							+"nom varchat(20),"
							+"IDgeo int,"
							+"Email varchar(50),";
							 
							try ( Statement statement = connection.createStatement() ) {
							statement.executeUpdate( requete );
							}
							
			requete = "CREATE TABLE  site("
							+"X int,"
							+"Y int,"
							+"IDsite int,";
							try ( Statement statement = connection.createStatement() ) {
							statement.executeUpdate( requete );
							}
							
			requete = "CREATE TABLE route ("
							+"IDorigine int,"
							+"IDarrive int,";
							try ( Statement statement = connection.createStatement() ) {
							statement.executeUpdate( requete );
							}
							
			requete = "CREATE TABLE demande ("
							+"IDclient,"
							+"Quantite demande int,";
							try ( Statement statement = connection.createStatement() ) {
							statement.executeUpdate( requete );
							}
			
			
				
			/*requete = "INSERT INTO citation (annee, citation, auteur) VALUES"
					+"(1947, 'La simplicite est la reussite absolue', 'Frederic Chopin'),"
					+"(1979, 'Le bonheur, tu sauras que c''est la simplicite', 'Jacques Brillant'),"
					+"(1986, 'La simplicite est la cle de la reussite','Andre Rochette')";
					try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
					}*/
		
			requete = "SELECT * FROM entrepot";
					try ( Statement statement = connection.createStatement() ) {
					try (ResultSet resultSet = statement.executeQuery( requete ) ) {
					while( resultSet.next() ) {
					int annee = resultSet.getInt( "annee" );
					String auteur = resultSet.getString( "auteur" );
					String citation = resultSet.getString( "citation" );
					System.out.println(String.format("%-5d %-20s %s", annee,auteur,citation));
					}
					}
					}
		}
		}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCSVData {

    private static final String CSV_FILE_CUSTOM_SEPARATOR1
        = "Jeux_de_donnees" + File.separator + "petit" + File.separator + "init-clients-30-10-Carre.csv";
    
    private static final String CSV_FILE_CUSTOM_SEPARATOR2
    = "Jeux_de_donnees" + File.separator + "petit" + File.separator + "init-routes-30-45-Carre.csv"; 
    
    private static final String CSV_FILE_CUSTOM_SEPARATOR3
    = "Jeux_de_donnees" + File.separator + "petit" + File.separator + "init-entrepots-30-5-Carre.csv"; 
    
    private static final String CSV_FILE_CUSTOM_SEPARATOR4
    = "Jeux_de_donnees" + File.separator + "petit" + File.separator + "init-sites-30-Carre.csv"; 
    
    public static void main(String[] args) { 
        List<Client> beans = null;
        List<Routes> RT = null;
        List<Entrepot> ENT = null;
        List<Sites> ST = null;
        try {
            beans = new CsvToBeanBuilder<Client>(new FileReader(CSV_FILE_CUSTOM_SEPARATOR1))
                    .withType(Client.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            
            RT = new CsvToBeanBuilder<Routes>(new FileReader(CSV_FILE_CUSTOM_SEPARATOR2))
                    .withType(Routes.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            
            ENT = new CsvToBeanBuilder<Entrepot>(new FileReader(CSV_FILE_CUSTOM_SEPARATOR3))
                    .withType(Entrepot.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            
            ST = new CsvToBeanBuilder<Sites>(new FileReader(CSV_FILE_CUSTOM_SEPARATOR4))
                    .withType(Sites.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            
        } catch (IllegalStateException | FileNotFoundException e) {
            e.printStackTrace();
        }

        insertClientsIntoDatabase(beans);
        insertRoutesIntoDatabase(RT);
        insertEntrepotIntoDatabase(ENT);
        insertSitesIntoDatabase(ST);
        
    }

////////////////////////////////CLIENTS///////////////////////////////////////////////
    private static void insertClientsIntoDatabase(List<Client> clients) {
        String url = "jdbc:hsqldb:file:database" + File.separator + "basic;shutdown=true";
        String login = "sa";
        String password = "";
        
        String checkSiteSQL = "SELECT COUNT(*) FROM SITE WHERE id_site = ?";
        String insertSiteSQL = "INSERT INTO SITE (id_site, x, y) VALUES (?, 0, 0)";
        String insertClientSQL = "INSERT INTO CLIENTS (id_site, mail, nom) VALUES (?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            connection.setAutoCommit(false);

            try (PreparedStatement checkSiteStmt = connection.prepareStatement(checkSiteSQL);
                 PreparedStatement insertSiteStmt = connection.prepareStatement(insertSiteSQL);
                 PreparedStatement insertClientStmt = connection.prepareStatement(insertClientSQL)) {
                
                for (Client client : clients) {
                   
                    checkSiteStmt.setString(1, client.getIdSite());
                    ResultSet rs = checkSiteStmt.executeQuery();
                    rs.next();
                    if (rs.getInt(1) == 0) {
                   
                        insertSiteStmt.setString(1, client.getIdSite());
                        insertSiteStmt.executeUpdate();
                    }
                    
                    insertClientStmt.setString(1, client.getIdSite());
                    insertClientStmt.setString(2, client.getMail());
                    insertClientStmt.setString(3, client.getNom());
                    insertClientStmt.addBatch();
                }
                
                insertClientStmt.executeBatch();
                connection.commit();
                System.out.println("Les données clients ont été inséré avec succées ! GG ");
                
            } catch (SQLException e) {
                connection.rollback(); 
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
////////////////////////////////////////////////ROUTES//////////////////////////////////////////
    private static void insertRoutesIntoDatabase(List<Routes> routes) {
        String url = "jdbc:hsqldb:file:database" + File.separator + "basic;shutdown=true";
        String login = "sa";
        String password = "";
        
        String insertRouteSQL = "INSERT INTO ROUTES(origine, destination) VALUES (?,?)";
        
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            connection.setAutoCommit(false);
            try (
                 PreparedStatement insertRouteStmt = connection.prepareStatement(insertRouteSQL)) {
                
                for (Routes R : routes) {
                    
                    insertRouteStmt.setLong(1, R.getOrigine());
                    insertRouteStmt.setLong(2, R.getDestination());
                    insertRouteStmt.addBatch();
                }
                
                insertRouteStmt.executeBatch();
                connection.commit();
                System.out.println("Les données routes ont été inséré avec succées ! GG ");
                
            } catch (SQLException e) {
                connection.rollback(); 
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    
////////////////////////////////////////////////SITES///////////////////////////////////////////

private static void insertRoutesIntoDatabase(List<Sites> sites) {
    String url = "jdbc:hsqldb:file:database" + File.separator + "basic;shutdown=true";
    String login = "sa";
    String password = "";
    
    String insertSitesSQL = "INSERT INTO SITES(id_sites,x,y) VALUES (?,?,?)";
    
    try (Connection connection = DriverManager.getConnection(url, login, password)) {
        connection.setAutoCommit(false);
        try (
             PreparedStatement insertSitesStmt = connection.prepareStatement(insertSitesSQL)) {
            
            for (Sites S : sites) {
                
                insertSitesStmt.setLong(1, S.getOrigine());
                insertSitesStmt.setLong(2, S.getDestination());
                insertSitesStmt.setLong(2, S.getDestination());
                insertSitesStmt.addBatch();
            }
            
            insertSitesStmt.executeBatch();
            connection.commit();
            System.out.println("Les données sites ont été inséré avec succées ! GG ");
            
        } catch (SQLException e) {
            connection.rollback(); 
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
    
////////////////////////////////////////////////ENTREPOS///////////////////////////////////////////
    

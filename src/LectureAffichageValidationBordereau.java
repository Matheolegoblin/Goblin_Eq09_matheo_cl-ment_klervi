import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LectureAffichageValidationBordereau {

    public static void main(String[] args) {
        String cheminFichierBordereau = "delivery_order.csv";  // Chemin du fichier CSV de bordereau de livraison

        // Lire les commandes à partir du fichier CSV
        List<String[]> commandes = lireBordereau(cheminFichierBordereau);
        if (commandes == null) {
            System.out.println("Erreur lors de la lecture du fichier de bordereau.");
            return;
        }

        // Affichage des informations des commandes
        for (String[] commande : commandes) {
            System.out.println("ID Client: " + commande[0] + ", ID Entrepôt: " + commande[1] + ", Quantité: " + commande[2]);
        }

        // Demande de validation au client 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous valider ces commandes ? (oui/non)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("oui")) {
            System.out.println("Commandes validées.");
        } else {
            System.out.println("Commandes non validées.");
        }
    }

    // Méthode pour lire le fichier CSV de bordereau de livraison
    public static List<String[]> lireBordereau(String cheminFichier) {
        try (CSVReader lecteur = new CSVReader(new FileReader(cheminFichier))) {
            return lecteur.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
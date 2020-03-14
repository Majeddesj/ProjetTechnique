package org.uqam.banque.commande;

import org.uqam.banque.baseDeDonnees.BaseDeDonnees;
import org.uqam.banque.objets.Client;
import org.uqam.banque.objets.Produit;

public class CommandeEmp {

    public static int listeClientParNom(BaseDeDonnees donnees, String nomClient) {

        final Client client = donnees.rechercheClientParNom(nomClient);

        if (client != null) {
            System.out.println("Informations du Client: ");
            System.out.println("   - ID: " + client.getId());
            System.out.println("      - Nom: " + client.getNom());
            System.out.println("      - Prenom: " + client.getPrenom());
            System.out.println("      - Adresse: " + client.getAdresse());
            System.out.println("      - Produits: ");
            for (Produit produit : client.getProduits()) {
                System.out.println("         - ID: " + produit.getId());
                System.out.println("            - Nom: " + produit.getNom());
            }
        } else {
            System.out.println("Aucun client correspondant a ce nom " + nomClient);
        }

        // tout est beau :)
        return 0;
    }
}
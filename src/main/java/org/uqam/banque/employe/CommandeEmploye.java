package org.uqam.banque.employe;

import org.uqam.banque.commun.BaseDeDonnees;
import org.uqam.banque.client.Client;
import org.uqam.banque.banque.Produit;

public class CommandeEmploye {

    BaseDeDonnees donnees = new BaseDeDonnees();

    public void execute(String[] args) {

        if (args.length < 2) {
            System.out.println("Il faut mettre 2 arguments, de la sorte. \nExemple: ./employee --list CLIENT_NAME");
            System.exit(1);
        }

        String typeCommande = args[0]; // --add, --list, --accept, --reject par exemple
        String nomClient = args[1]; // nom du client

        if (typeCommande.equals("--list")) {
            final int codeRetour = listeClientParNom(donnees, nomClient);

            System.exit(codeRetour);
        } else {

            System.out.println("Commande incorrecte");

        }

    }

    public int listeClientParNom(BaseDeDonnees donnees, String nomClient) {

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
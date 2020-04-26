package org.uqam.banque.client;

import org.uqam.banque.commun.BaseDeDonnees;
import org.uqam.banque.banque.Produit;

public class CommandeClient {

    BaseDeDonnees donnees = new BaseDeDonnees();

    public void execute(String[] args) {

        if (args.length < 3) {
            System.out.println("Il faut mettre 3 arguments, de la sorte. \nExemple: ./client -n CLIENT_NAME --status\nExemple: ./client -n CLIENT_NAME --subscribe PRODUCT_ID\nExemple: ./client -n CLIENT_NAME --unsubscribe PRODUCT_ID");
            System.exit(1);
        }

        if (!args[0].equals("-n")) {
            System.out.println("Il faut que le premier argument soit = '-n'. \nExemple: ./client -n CLIENT_NAME --status\nExemple: ./client -n CLIENT_NAME --subscribe PRODUCT_ID\nExemple: ./client -n CLIENT_NAME --unsubscribe PRODUCT_ID");
            System.exit(2);
        }

        String nomClient = args[1]; // nom du client
        String typeCommande = args[2]; // --status, --subscribe, --Unsubscribe par exemple

        if (typeCommande.equals("--status")) {
            final int codeRetour = statutClientParNom(donnees, nomClient);

            System.exit(codeRetour);
        } else if (typeCommande.equals("--subscribe")) {
            if (args.length < 4) {
                System.out.println("Il faut mettre 4 arguments, de la sorte. \nExemple: ./client -n CLIENT_NAME --subscribe PRODUCT_ID");
                System.exit(3);
            }

            String idProduit = args[3]; // nom du client

            final int codeRetourSouscription = souscriptionProduitAuClientParNom(donnees,
                    nomClient,
                    idProduit);

            if (codeRetourSouscription != 0) {
                System.exit(codeRetourSouscription);
            }

            // affichage du statut du client
            final int codeRetourStatut = statutClientParNom(donnees, nomClient);

            System.exit(codeRetourStatut);

        } else if (typeCommande.equals("--unsubscribe")) {
            if (args.length < 4) {
                System.out.println("Il faut mettre 4 arguments, de la sorte. \nExemple: ./client -n CLIENT_NAME --subscribe PRODUCT_ID");
                System.exit(3);
            }

            String idProduit = args[3]; // nom du client

            final int codeRetourunsubscribe = unsubscribeProduitAuClientParNom(donnees,
                    nomClient,
                    idProduit);

            if (codeRetourunsubscribe != 0) {
                System.exit(codeRetourunsubscribe);
            }

            // affichage du statut du client
            final int codeRetourStatut = statutClientParNom(donnees, nomClient);

            System.exit(codeRetourStatut);
        } else {
            System.out.println("Seul --status, --subscribe et Unsubscribe sont autorises pour les commandes.");
            System.exit(10);
        }

    }

    public int statutClientParNom(BaseDeDonnees donnees, String nomClient) {

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
            System.out.println("Aucun client correspondant à ce nom " + nomClient);
        }

        // tout est beau :)
        return 0;
    }

    public int souscriptionProduitAuClientParNom(BaseDeDonnees donnees, String nomClient, String idProduit) {

        final Client client = donnees.rechercheClientParNom(nomClient);
        final Produit produit = donnees.rechercheProduitParId(idProduit);

        if (client == null) {
            System.out.println("Erreur: Aucun client correspondant à ce nom " + nomClient);
            return 1;
        }

        if (produit == null) {
            System.out.println("Erreur: Aucun produit correspondant à cet identifiant " + idProduit);
            return 2;
        }

        System.out.println("Souscription du produit " + idProduit + " pour le client " + nomClient);

        // on ajoute le produit au client
        client.getProduits().add(produit);

        // tout est beau :)

        donnees.sauvegardeBd();

        return 0;
    }
    
    public int unsubscribeProduitAuClientParNom(BaseDeDonnees donnees, String nomClient, String idProduit) {

        final Client client = donnees.rechercheClientParNom(nomClient);
        final Produit produit = donnees.rechercheProduitParId(idProduit);

        if (client == null) {
            System.out.println("Erreur: Aucun client correspondant à ce nom " + nomClient);
            return 1;
        }

        if (produit == null) {
            System.out.println("Erreur: Aucun produit correspondant à cet identifiant " + idProduit);
            return 2;
        }

        System.out.println("Dé-souscription du produit " + idProduit + " pour le client " + nomClient);

        // on ajoute le produit au client
        client.getProduits().remove(produit);

        // tout est beau :)

        donnees.sauvegardeBd();

        return 0;
	}

}

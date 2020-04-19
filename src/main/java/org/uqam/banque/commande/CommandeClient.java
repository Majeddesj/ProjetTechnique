package org.uqam.banque.commande;

import org.uqam.banque.baseDeDonnees.BaseDeDonnees;
import org.uqam.banque.objets.Client;
import org.uqam.banque.objets.Produit;

public class CommandeClient {

    public static int statutClientParNom(BaseDeDonnees donnees, String nomClient) {

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

    public static int souscriptionProduitAuClientParNom(BaseDeDonnees donnees, String nomClient, String idProduit) {

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
        return 0;
    }
    
    public static int unsubscribeProduitAuClientParNom(BaseDeDonnees donnees, String nomClient, String idProduit) {
		return 0;
	}

}

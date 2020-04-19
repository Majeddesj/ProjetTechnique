package org.uqam.banque.baseDeDonnees;

import java.util.ArrayList;
import java.util.List;

import org.uqam.banque.objets.Client;
import org.uqam.banque.objets.Produit;

public class BaseDeDonnees {

    private List<Produit> produits = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public BaseDeDonnees() {
        alimenterDesProduits();
        alimenterDesClients();
    }

    public Client rechercheClientParNom(String nomClient) {
        for (Client client : clients) {
            if (client.getNom().equals(nomClient)) {
                return client;
            }
        }
        return null;
    }

    public Produit rechercheProduitParId(String idProduit) {
        for (Produit produit : produits) {
            if (produit.getId().equals(idProduit)) {
                return produit;
            }
        }
        return null;
    }

    private void alimenterDesProduits() {
        // Creation de produits Bidons
        Produit produit1 = new Produit();
        produit1.setId("ID_PRODUIT_001");
        produit1.setNom("Produit 01");

        Produit produit2 = new Produit();
        produit2.setId("ID_PRODUIT_002");
        produit2.setNom("Produit 02");

        Produit produit3 = new Produit();
        produit3.setId("ID_PRODUIT_003");
        produit3.setNom("Produit 03");

        produits.add(produit1);
        produits.add(produit2);
        produits.add(produit3);
    }

    private void alimenterDesClients() {
        // Creation de donnees d'un client Bidon
        Client client1 = new Client();
        client1.setId("ID_CLIENT_001");
        client1.setNom("Abidi");
        client1.setPrenom("Majed");
        client1.setAdresse("Mon adresse");

        List<Produit> produitsDuClient1 = new ArrayList<>();
        produitsDuClient1.add(produits.get(0));
        produitsDuClient1.add(produits.get(1));

        client1.setProduits(produitsDuClient1);

        clients.add(client1);
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public List<Client> getClients() {
        return clients;
    }

}

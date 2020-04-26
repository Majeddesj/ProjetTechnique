package org.uqam.banque.commun;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.uqam.banque.client.Client;
import org.uqam.banque.banque.Produit;

public class BaseDeDonnees {

    static final String FICHIER_BD = "./bd_banque.bd";

    private Donnees donnees = new Donnees();
    private String fichier;

    public BaseDeDonnees() {
        this.fichier = FICHIER_BD;
        chargementBd();
    }

    /**
     * Juste pour les tests
     */
    BaseDeDonnees(String fichier) {
        this.fichier = fichier;
        chargementBd();
    }

    public void sauvegardeBd() {
        FileOutputStream file = null;
        ObjectOutputStream out = null;

        // Serialization
        try {
            //Saving of object in a file
            file = new FileOutputStream(fichier);
            out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(donnees);

            System.out.println("--> BD sauvegardée");
            System.out.println();
            System.out.println();
        } catch(IOException ex) {
            ex.printStackTrace();
            throw  new  IllegalStateException("Un problème inattendu est survenu lors de la sauvegarde de la BD.");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {

            }
        }
    }

    private void chargementBd() {
        if (!Files.exists(Paths.get(fichier))) {
            System.out.println("--> BD vide - alimentation de la BD avec des données bidon pour le test...");
            alimenterDesProduits();
            alimenterDesClients();
            sauvegardeBd();
            System.out.println("--> BD chargée et sauvegardée avec les données bidon.");
            System.out.println();
            System.out.println();
            return;
        }

        FileInputStream file = null;
        ObjectInputStream in = null;

        // Deserialization
        try {
            // Reading the object from a file
            file = new FileInputStream(fichier);
            in = new ObjectInputStream(file);

            // Method for deserialization of object
            Donnees donneesStockees = (Donnees) in.readObject();
            donnees.setProduits(donneesStockees.getProduits());
            donnees.setClients(donneesStockees.getClients());

            System.out.println("--> BD chargée");
            System.out.println();
            System.out.println();
        } catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw  new  IllegalStateException("Un problème inattendu est survenu lors du chargement de la BD.");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {

            }
        }
    }

    public Client rechercheClientParNom(String nomClient) {
        for (Client client : donnees.getClients()) {
            if (client.getNom().equals(nomClient)) {
                return client;
            }
        }
        return null;
    }

    public Produit rechercheProduitParId(String idProduit) {
        for (Produit produit : donnees.getProduits()) {
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

        donnees.getProduits().add(produit1);
        donnees.getProduits().add(produit2);
        donnees.getProduits().add(produit3);
    }

    private void alimenterDesClients() {
        // Creation de donnees d'un client Bidon
        Client client1 = new Client();
        client1.setId("ID_CLIENT_001");
        client1.setNom("Abidi");
        client1.setPrenom("Majed");
        client1.setAdresse("Mon adresse");

        List<Produit> produitsDuClient1 = new ArrayList<>();
        produitsDuClient1.add(donnees.getProduits().get(0));
        produitsDuClient1.add(donnees.getProduits().get(1));

        client1.setProduits(produitsDuClient1);

        donnees.getClients().add(client1);
    }

    public List<Produit> getProduits() {
        return donnees.getProduits();
    }

    public List<Client> getClients() {
        return donnees.getClients();
    }

}

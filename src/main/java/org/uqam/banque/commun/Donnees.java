package org.uqam.banque.commun;

import org.uqam.banque.banque.Produit;
import org.uqam.banque.client.Client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Donnees implements Serializable {

    static final long serialVersionUID = 753141985043715114L;

    private List<Produit> produits = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public List<Produit> getProduits() {
        return produits;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

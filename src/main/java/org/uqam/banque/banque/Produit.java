package org.uqam.banque.banque;

import java.io.Serializable;

public class Produit implements Serializable {

    static final long serialVersionUID = 9025505294791625277L;

    private String id;
    private String nom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

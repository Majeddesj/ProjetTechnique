package org.technique.baseDeDonnees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.technique.objets.Client;
import org.technique.objets.Produit;

public class BaseDeDonneesTest {

    @Test
    public void givenBaseDeDonnees_whenFabriqueObjet_thenOk() {
        BaseDeDonnees baseDeDonnees = new BaseDeDonnees();

        Assert.assertNotNull(baseDeDonnees);

        final List<Produit> produits = baseDeDonnees.getProduits();

        Assert.assertNotNull(produits);
        Assert.assertFalse(produits.isEmpty());
        Assert.assertEquals(3, produits.size());

        Produit produit1 = produits.get(0);
        Assert.assertEquals("ID_PRODUIT_001", produit1.getId());
        Assert.assertEquals("Produit 01", produit1.getNom());

        Produit produit2 = produits.get(1);
        Assert.assertEquals("ID_PRODUIT_002", produit2.getId());
        Assert.assertEquals("Produit 02", produit2.getNom());

        Produit produit3 = produits.get(2);
        Assert.assertEquals("ID_PRODUIT_003", produit3.getId());
        Assert.assertEquals("Produit 03", produit3.getNom());

        final List<Client> clients = baseDeDonnees.getClients();

        Assert.assertNotNull(clients);
        Assert.assertFalse(clients.isEmpty());
        Assert.assertEquals(1, clients.size());

        Client client1 = clients.get(0);
        Assert.assertEquals("ID_CLIENT_001", client1.getId());
        Assert.assertEquals("Abidi", client1.getNom());
        Assert.assertEquals("Majed", client1.getPrenom());
        Assert.assertEquals("Mon adresse", client1.getAdresse());
        Assert.assertNotNull(client1.getProduits());
        Assert.assertFalse(client1.getProduits().isEmpty());
        Assert.assertEquals(2, client1.getProduits().size());
        Assert.assertEquals(produit1, client1.getProduits().get(0));
        Assert.assertEquals(produit2, client1.getProduits().get(1));
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourAbidi_thenClientAbidiRetourne() {
        BaseDeDonnees baseDeDonnees = new BaseDeDonnees();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom("Abidi");

        Assert.assertNotNull(client1);
        Assert.assertEquals("ID_CLIENT_001", client1.getId());
        Assert.assertEquals("Abidi", client1.getNom());
        Assert.assertEquals("Majed", client1.getPrenom());
        Assert.assertEquals("Mon adresse", client1.getAdresse());
        Assert.assertNotNull(client1.getProduits());
        Assert.assertFalse(client1.getProduits().isEmpty());
        Assert.assertEquals(2, client1.getProduits().size());
        Assert.assertEquals(produits.get(0), client1.getProduits().get(0));
        Assert.assertEquals(produits.get(1), client1.getProduits().get(1));
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourUnInexistant_thenAucunClientRetourne() {
        BaseDeDonnees baseDeDonnees = new BaseDeDonnees();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom("INEXISTANT");

        Assert.assertNull(client1);
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourNull_thenAucunClientRetourne() {
        BaseDeDonnees baseDeDonnees = new BaseDeDonnees();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom(null);

        Assert.assertNull(client1);
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourVide_thenAucunClientRetourne() {
        BaseDeDonnees baseDeDonnees = new BaseDeDonnees();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom("");

        Assert.assertNull(client1);
    }

}
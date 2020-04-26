package org.uqam.banque.commun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.uqam.banque.client.Client;
import org.uqam.banque.banque.Produit;
import org.uqam.banque.commun.BaseDeDonnees;

public class BaseDeDonneesTest {

    static final String FICHIER_BD_TEST = "./bd_banque_test.bd";

    BaseDeDonnees newBd() {
        try {
            if (Files.exists(Paths.get(FICHIER_BD_TEST))) {
                Files.delete(Paths.get(FICHIER_BD_TEST));
            }
            return new BaseDeDonnees(FICHIER_BD_TEST);
        } catch(IOException e) {
            Assertions.fail("Problème avec la BD de test.");
        }
        return null;
    }

    @Test
    public void givenBaseDeDonnees_whenFabriqueObjet_thenOk() {
        BaseDeDonnees baseDeDonnees = newBd();

        Assertions.assertNotNull(baseDeDonnees);

        final List<Produit> produits = baseDeDonnees.getProduits();

        Assertions.assertNotNull(produits);
        Assertions.assertFalse(produits.isEmpty());
        Assertions.assertEquals(3, produits.size());

        Produit produit1 = produits.get(0);
        Assertions.assertEquals("ID_PRODUIT_001", produit1.getId());
        Assertions.assertEquals("Produit 01", produit1.getNom());

        Produit produit2 = produits.get(1);
        Assertions.assertEquals("ID_PRODUIT_002", produit2.getId());
        Assertions.assertEquals("Produit 02", produit2.getNom());

        Produit produit3 = produits.get(2);
        Assertions.assertEquals("ID_PRODUIT_003", produit3.getId());
        Assertions.assertEquals("Produit 03", produit3.getNom());

        final List<Client> clients = baseDeDonnees.getClients();

        Assertions.assertNotNull(clients);
        Assertions.assertFalse(clients.isEmpty());
        Assertions.assertEquals(1, clients.size());

        Client client1 = clients.get(0);
        Assertions.assertEquals("ID_CLIENT_001", client1.getId());
        Assertions.assertEquals("Abidi", client1.getNom());
        Assertions.assertEquals("Majed", client1.getPrenom());
        Assertions.assertEquals("Mon adresse", client1.getAdresse());
        Assertions.assertNotNull(client1.getProduits());
        Assertions.assertFalse(client1.getProduits().isEmpty());
        Assertions.assertEquals(2, client1.getProduits().size());
        Assertions.assertEquals(produit1, client1.getProduits().get(0));
        Assertions.assertEquals(produit2, client1.getProduits().get(1));
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourAbidi_thenClientAbidiRetourne() {
        BaseDeDonnees baseDeDonnees = newBd();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom("Abidi");

        Assertions.assertNotNull(client1);
        Assertions.assertEquals("ID_CLIENT_001", client1.getId());
        Assertions.assertEquals("Abidi", client1.getNom());
        Assertions.assertEquals("Majed", client1.getPrenom());
        Assertions.assertEquals("Mon adresse", client1.getAdresse());
        Assertions.assertNotNull(client1.getProduits());
        Assertions.assertFalse(client1.getProduits().isEmpty());
        Assertions.assertEquals(2, client1.getProduits().size());
        Assertions.assertEquals(produits.get(0), client1.getProduits().get(0));
        Assertions.assertEquals(produits.get(1), client1.getProduits().get(1));
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourUnInexistant_thenAucunClientRetourne() {
        BaseDeDonnees baseDeDonnees = newBd();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom("INEXISTANT");

        Assertions.assertNull(client1);
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourNull_thenAucunClientRetourne() {
        BaseDeDonnees baseDeDonnees = newBd();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom(null);

        Assertions.assertNull(client1);
    }

    @Test
    public void givenBaseDeDonnees_whenRechercheClientParNomPourVide_thenAucunClientRetourne() {
        BaseDeDonnees baseDeDonnees = newBd();

        final List<Produit> produits = baseDeDonnees.getProduits();

        final Client client1 = baseDeDonnees.rechercheClientParNom("");

        Assertions.assertNull(client1);
    }

}
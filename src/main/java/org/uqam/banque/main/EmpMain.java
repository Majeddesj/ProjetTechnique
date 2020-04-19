package org.uqam.banque.main;

import org.uqam.banque.baseDeDonnees.BaseDeDonnees;
import org.uqam.banque.commande.CommandeClient;
import org.uqam.banque.commande.CommandeEmp;

public class EmpMain {

    public static void main(String[] args) {

        BaseDeDonnees donnees = new BaseDeDonnees();

        if (args.length < 2) {
            System.out.println("Il faut mettre 2 arguments, de la sorte. \nExemple: ./employee --list CLIENT_NAME");
            System.exit(1);
        }

        

        String typeCommande = args[0]; // --add, --list, --accept, --reject par exemple
        String nomClient = args[1]; // nom du client

        if (typeCommande.equals("--list")) {
            final int codeRetour = CommandeEmp.listeClientParNom(donnees, nomClient);

            System.exit(codeRetour);
        } else {
        	
        	System.out.println("Commande incorrecte");
        
    } 
  
        }
}
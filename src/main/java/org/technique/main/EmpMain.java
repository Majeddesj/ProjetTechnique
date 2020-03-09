package org.technique.main;

import org.technique.baseDeDonnees.BaseDeDonnees;
import org.technique.commande.CommandeClient;
import org.technique.commande.CommandeEmp;

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
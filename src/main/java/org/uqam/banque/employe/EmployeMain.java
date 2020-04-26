package org.uqam.banque.employe;

import org.uqam.banque.commun.BaseDeDonnees;

public class EmployeMain {

    public static void main(String[] args) {
        new CommandeEmploye().execute(args);
    }
}
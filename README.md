# 0. Veuillez vous connecter sur la branche Feature-add-commands-for-employes

# 1. Compilation du projet
Nécessite JDK 8 et Maven, puis exécuter:
```
mvn clean install
```
# 2. Permissions pour les scripts
Penser à mettre les droits d'exécution sur le script:
```
chmod +x scripts/banque.sh
```

# 3. Exécution: client

## Exemples de commandes incorrectes:
```
./client.sh -n Abidi --incorrecte
./client.sh -incorrect Abidi --status
./client.sh -n Abidi --subscribe ID_PRODUIT_003
./client.sh -n Abidi --unsubscribe ID_PRODUIT_003
./client.sh ./client.sh -n Abidi --unsubscribe ID_PRODUIT_fjdie
./client.sh -n Inconnu --unsubscribe ID_PRODUIT_003
```

# 3. Exécution: employe
./Employe.sh --list Abidi


# color.red ( pour mes commits vs Stories J'ai voulu rebase mes Commi pour les linker avec mes stories qui sont sous git projet mais je recevais des message d'erreur donc j'avais peur de perdre ma configuration.) 

# Mes commits doivent ressembler comme suit :
#  Sous la branche Feature-add-commands-for-employes: commit : Ajouter commande liste produit par client EMP [1#card-34319974, 1#card-34321111]



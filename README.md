

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

./client.sh -n Abidi --status
./client.sh -n Abidi --unsubscribe ID_PRODUIT_003
./client.sh -n Abidi --subscribe ID_PRODUIT_003
## Exemples de commandes incorrectes:
```
./client.sh -n Abidi --status
./client.sh -n Abidi --incorrecte
./client.sh -incorrect Abidi --status
./client.sh -n Abidi --unsubscribe ID_PRODUIT_fjdie
./client.sh -n Inconnu --unsubscribe ID_PRODUIT_003
```

# 3. Exécution: employe
./Employe.sh --list Abidi




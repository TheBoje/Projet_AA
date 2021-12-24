# Projet_AA

Composition du groupe : 
- Vincent COMMIN
- Louis LEENART

# Utilisation

Le programme se compile et se lance via le Makefile proposé. 

## Compilation

La compilation est assurée par la commande par défaut du makefile

```bash
make
```

## Lancement de Main

### Avec entrée du fichier n°X

```bash
make main ARGS=X
# Exemple
make main ARGS=1
```

Avec `X` le numéro du graphe en question, allant de 0 à 7 (contenu dans le dossier `data`)

### Avec entrée d'un graphe aléatoire

```bash
make gen
```

On note que la génération du graphe est gérée par la librairie `lib/randomdag.jar`. Pour modifier les paramètres de génération du graphe en question, il est nécessaire de modifier le fichier `Makefile`.

### Lancement manuel

Une fois compilés avec `make`, les fichiers `.class` sont déposés dans le dossier `build`. On note que si on ne propose aucun argument au programme, il va lire sur l'entrée standard.

# Organisation des fichiers

```bash
.
├── SUJET.pdf           # Sujet du projet
├── README.md           # Ce fichier
├── Makefile
├── EXEMPLES.pdf        # Description des graphe dans data/
├── lib             
│   └── randomdag.jar   # Libraire de génération de graph 
├── src                 # Fichiers source          
│   ├── Main.java
│   └── graph
│       ├── Node.java   
│       ├── Graph.java
│       └── Color.java
└── data                # Fichiers d'entrée
    └── graph-100.alists
    ├── graph-101.alists
    ├── graph-102.alists
    ├── graph-103.alists
    ├── graph-104.alists
    ├── graph-105.alists
    ├── graph-106.alists
    ├── graph-107.alists
```

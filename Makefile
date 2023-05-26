### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Start.class : Start.java FenetreInit.class Fenetre.class
	${JC} ${JCFLAGS} Start.java

Fenetre.class : Fenetre.java 
	${JC} ${JCFLAGS} Fenetre.java

FenetreInit.class : FenetreInit.java Creer.class Importer.class
	${JC} ${JCFLAGS} FenetreInit.java

### ========================================================================

Importer.class : Importer.java Lecture.class FenetreImpGrille.class FileImport.class
	${JC} ${JCFLAGS} Importer.java

FileImport.class : FileImport.java
	${JC} ${JCFLAGS} FileImport.java

Lecture.class : Lecture.java outils.class
	${JC} ${JCFLAGS} Lecture.java

outils.class : outils.java
	${JC} ${JCFLAGS} outils.java

FenetreImpGrille.class : FenetreImpGrille.java Cellules.class ChoixAlgo.class
	${JC} ${JCFLAGS} FenetreImpGrille.java

### ========================================================================

Creer.class : Creer.java FenetreDefSize.class
	${JC} ${JCFLAGS} Creer.java

FenetreDefSize.class : FenetreDefSize.java ChoixEtTaille.class
	${JC} ${JCFLAGS} FenetreDefSize.java

ChoixEtTaille.class : ChoixEtTaille.java FenetreRndmGrille.class FenetreVideGrille.class 
	${JC} ${JCFLAGS} ChoixEtTaille.java

# == 
FenetreRndmGrille.class : FenetreRndmGrille.java Cellules.class PanneauModification.class Modifications.class
	${JC} ${JCFLAGS} FenetreRndmGrille.java

FenetreVideGrille.class : FenetreVideGrille.java Cellules.class PanneauModification.class Modifications.class
	${JC} ${JCFLAGS} FenetreVideGrille.java

Cellules.class : Cellules.java
	${JC} ${JCFLAGS} Cellules.java

PanneauModification.class : PanneauModification.java GestionModif.class
	${JC} ${JCFLAGS} PanneauModification.java

Modifications.class : Modifications.java ModificationsTab.class
	${JC} ${JCFLAGS} Modifications.java

ModificationsTab.class : ModificationsTab.java Affichage.class
	${JC} ${JCFLAGS} ModificationsTab.java

GestionModif.class : GestionModif.java Exporter.class 
	${JC} ${JCFLAGS} GestionModif.java

Affichage.class : Affichage.java outils.class
	${JC} ${JCFLAGS} Affichage.java

Exporter.class : Exporter.java GestionExporter.class
	${JC} ${JCFLAGS} Exporter.java

GestionExporter.class : GestionExporter.java PreEcriture.class ChoixAlgo.class
	${JC} ${JCFLAGS} GestionExporter.java

PreEcriture.class : PreEcriture.java Ecriture.class
	${JC} ${JCFLAGS} PreEcriture.java

Ecriture.class : Ecriture.java
	${JC} ${JCFLAGS} Ecriture.java

ChoixAlgo.class : ChoixAlgo.java GestionChoixAlgo.class
	${JC} ${JCFLAGS} ChoixAlgo.java

GestionChoixAlgo.class : GestionChoixAlgo.java AlgoAlea.class AlgoDeter.class
	${JC} ${JCFLAGS} GestionChoixAlgo.java

AlgoAlea.class : AlgoAlea.java These.class Attente.class
	${JC} ${JCFLAGS} AlgoAlea.java

These.class : These.java
	${JC} ${JCFLAGS} These.java

Attente.class : Attente.java
	${JC} ${JCFLAGS} Attente.java

AlgoDeter.class : AlgoDeter.java Parcours.class ParcoursManuel.class
	${JC} ${JCFLAGS} AlgoDeter.java

Parcours.class : Parcours.java
	${JC} ${JCFLAGS} Parcours.java

ParcoursManuel.class : ParcoursManuel.java
	${JC} ${JCFLAGS} ParcoursManuel.java

# ================================

### REGLES OPTIONNELLES ###

run : Start.class
	${JVM} ${JVMFLAGS} Start

clean :
	-rm -f *.class

nettoyer :
	rm .\*.class

mrproper : clean Start.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###
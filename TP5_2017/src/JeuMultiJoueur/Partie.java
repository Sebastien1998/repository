package JeuMultiJoueur;

import java.util.ArrayList;

import JeuSimpleMonoJoueur.Joueur;
import JeuSimpleMonoJoueur.NbMystere;

/**
 * Classe permetant de cr�er et manipuler des parties
 * @author Desideri S�bastien
 * @version 0.1
 * @since 16/11/2017
 */
public class Partie {
	/**
	 * Le gagnant de la partie
	 */
	private JeuMultiJoueur.Joueur gagnant;
	/**
	 * Le nombre de joueurs
	 */
	private int nbJoueurs;
	/**
	 * Le nombre de coups jou�s avant d'avoir trouv� le nombre myst�re
	 */
	private int nbCoups;
	/**
	 * Liste des joueurs
	 */
	private ArrayList<JeuMultiJoueur.Joueur> joueurs;
	/**
	 * La variable contenant le nombre myst�re
	 */
	private JeuMultiJoueur.NbMystere nombre;
	/**
	 * Constructeur cr�ant une partie avec une liste joueurs, le nombre de joueurs et un nombre myst�re
	 * @param leJoueur Joueur Le joueur
	 * @param valeurMax Entier(int) La valeur du num�ro myst�re
	 */
	public Partie(int nbJoueurs, int valeurMax) {
		this.nombre=new JeuMultiJoueur.NbMystere(valeurMax);
		this.nbJoueurs=nbJoueurs;
		nbCoups=1;
		System.out.println("Enregistrement des joueurs");
		System.out.println("**********************************************************************");
		saisieJoueurs();
		System.out.println("**********************************************************************");
	}
	/**
	 *  Constructeur cr�ant une partie avec une liste joueurs, le nombre de joueurs et un nombre myst�re
	 */
	public Partie() {
		System.out.println("Debut du jeu");
		joueurs=new ArrayList<>();
		this.nombre=new JeuMultiJoueur.NbMystere();
		this.nbJoueurs=Clavier.lireInt("Donner le nombre de participants : ");
		nbCoups=1;
		System.out.println("Enregistrement des joueurs");
		System.out.println("**********************************************************************");
		saisieJoueurs();
		System.out.println("**********************************************************************");
	}
	/**
	 * M�thode permetant de saisir les noms des joueurs d'une partie
	 */
	private void saisieJoueurs() {
		for(int i=0;i<nbJoueurs;i++) {
			joueurs.add(new JeuMultiJoueur.Joueur());
		}
	}
	/**
	 * M�thode retournant le nombre de coups du joueur
	 * @return Entier(int) Le nombre de coups du joueur
	 */
	public int getNbCoups() {
		return nbCoups;
	}
	/**
	 * M�thode affichant le r�sultat de la partie
	 */
	public void afficherResultat() {
		System.out.println("\nPartie gagn�e en "+getNbCoups()+" coups\nLe gagnant est :\n"+gagnant);
	}
	/**
	 * M�thode permetant au joueur de faire une proposition puis de v�rifier celle-ci
	 * @return Bool�en(boolean) Vrai si le joueur a trouv� le num�ro myst�re
	 */
	public boolean faireJouer(int numJoueur) {
		return (nombre.testProp(joueurs.get(numJoueur).nouvelleProp(getNbCoups())));
	}
	/**
	 * M�thode permetant de lancer la partie
	 */
	public void lancerMulti() {
		boolean victoire=false;
		while (victoire==false) {
			for (int i=0; i<nbJoueurs; i++) {
				if (faireJouer(i)) {
					victoire=true;
					gagnant=joueurs.get(i);
					break;
				}
			}
			nbCoups++;
		}
		afficherResultat();
	}
}

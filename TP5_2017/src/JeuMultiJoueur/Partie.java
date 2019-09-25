package JeuMultiJoueur;

import java.util.ArrayList;

import JeuSimpleMonoJoueur.Joueur;
import JeuSimpleMonoJoueur.NbMystere;

/**
 * Classe permetant de créer et manipuler des parties
 * @author Desideri Sébastien
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
	 * Le nombre de coups joués avant d'avoir trouvé le nombre mystère
	 */
	private int nbCoups;
	/**
	 * Liste des joueurs
	 */
	private ArrayList<JeuMultiJoueur.Joueur> joueurs;
	/**
	 * La variable contenant le nombre mystère
	 */
	private JeuMultiJoueur.NbMystere nombre;
	/**
	 * Constructeur créant une partie avec une liste joueurs, le nombre de joueurs et un nombre mystère
	 * @param leJoueur Joueur Le joueur
	 * @param valeurMax Entier(int) La valeur du numéro mystère
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
	 *  Constructeur créant une partie avec une liste joueurs, le nombre de joueurs et un nombre mystère
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
	 * Méthode permetant de saisir les noms des joueurs d'une partie
	 */
	private void saisieJoueurs() {
		for(int i=0;i<nbJoueurs;i++) {
			joueurs.add(new JeuMultiJoueur.Joueur());
		}
	}
	/**
	 * Méthode retournant le nombre de coups du joueur
	 * @return Entier(int) Le nombre de coups du joueur
	 */
	public int getNbCoups() {
		return nbCoups;
	}
	/**
	 * Méthode affichant le résultat de la partie
	 */
	public void afficherResultat() {
		System.out.println("\nPartie gagnée en "+getNbCoups()+" coups\nLe gagnant est :\n"+gagnant);
	}
	/**
	 * Méthode permetant au joueur de faire une proposition puis de vérifier celle-ci
	 * @return Booléen(boolean) Vrai si le joueur a trouvé le numéro mystère
	 */
	public boolean faireJouer(int numJoueur) {
		return (nombre.testProp(joueurs.get(numJoueur).nouvelleProp(getNbCoups())));
	}
	/**
	 * Méthode permetant de lancer la partie
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

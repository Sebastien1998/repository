package JeuSimpleMonoJoueur;
/**
 * Classe permetant de cr�er et manipuler des parties
 * @author Desideri S�bastien
 * @version 0.1
 * @since 13/11/2017
 */
public class PartieSolitaire {
	/**
	 * Le nombre de coups jou�s avant d'avoir trouv� le nombre myst�re
	 */
	private int nbCoups=1;
	/**
	 * Le joueur
	 */
	private Joueur leJoueur;
	/**
	 * La variable contenant le nombre myst�re
	 */
	private NbMystere nombre;
	/**
	 * Constructeur cr�ant une partie avec un joueur et un nombre myst�re
	 * @param leJoueur Joueur Le joueur
	 * @param valeurMax Entier(int) La valeur du num�ro myst�re
	 */
	public PartieSolitaire(Joueur leJoueur, int valeurMax) {
		this.nombre=new NbMystere(valeurMax);
		this.leJoueur=leJoueur;
	}
	/**
	 *  Constructeur cr�ant une partie avec un joueur et un nombre myst�re
	 */
	public PartieSolitaire() {
		System.out.println("Debut du jeu");
		this.nombre=new NbMystere();
		this.leJoueur=new Joueur();
		System.out.println("***************************************************************************");
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
		System.out.println("Partie gagn�e par "+leJoueur.getNom()+" en "+getNbCoups()+" coups");
	}
	/**
	 * M�thode permetant au joueur de faire une proposition puis de v�rifier celle-ci
	 * @return Bool�en(boolean) Vrai si le joueur a trouv� le num�ro myst�re
	 */
	public boolean faireJouer() {
		return (nombre.testProp(leJoueur.nouvelleProp(getNbCoups())));
	}
	/**
	 * M�thode permetant de lancer la partie
	 */
	public void lancer() {
		while (!(faireJouer())) {
			nbCoups++;
		}
		afficherResultat();
	}
}
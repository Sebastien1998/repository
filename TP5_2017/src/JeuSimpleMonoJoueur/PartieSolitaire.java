package JeuSimpleMonoJoueur;
/**
 * Classe permetant de créer et manipuler des parties
 * @author Desideri Sébastien
 * @version 0.1
 * @since 13/11/2017
 */
public class PartieSolitaire {
	/**
	 * Le nombre de coups joués avant d'avoir trouvé le nombre mystère
	 */
	private int nbCoups=1;
	/**
	 * Le joueur
	 */
	private Joueur leJoueur;
	/**
	 * La variable contenant le nombre mystère
	 */
	private NbMystere nombre;
	/**
	 * Constructeur créant une partie avec un joueur et un nombre mystère
	 * @param leJoueur Joueur Le joueur
	 * @param valeurMax Entier(int) La valeur du numéro mystère
	 */
	public PartieSolitaire(Joueur leJoueur, int valeurMax) {
		this.nombre=new NbMystere(valeurMax);
		this.leJoueur=leJoueur;
	}
	/**
	 *  Constructeur créant une partie avec un joueur et un nombre mystère
	 */
	public PartieSolitaire() {
		System.out.println("Debut du jeu");
		this.nombre=new NbMystere();
		this.leJoueur=new Joueur();
		System.out.println("***************************************************************************");
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
		System.out.println("Partie gagnée par "+leJoueur.getNom()+" en "+getNbCoups()+" coups");
	}
	/**
	 * Méthode permetant au joueur de faire une proposition puis de vérifier celle-ci
	 * @return Booléen(boolean) Vrai si le joueur a trouvé le numéro mystère
	 */
	public boolean faireJouer() {
		return (nombre.testProp(leJoueur.nouvelleProp(getNbCoups())));
	}
	/**
	 * Méthode permetant de lancer la partie
	 */
	public void lancer() {
		while (!(faireJouer())) {
			nbCoups++;
		}
		afficherResultat();
	}
}
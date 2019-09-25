package JeuSimpleMonoJoueur;
/**
 * Classe permetant de créer des joueurs
 * @author Desideri Sébastien
 * @version 0.1
 * @since 13/11/2017
 */
public class Joueur {
	/**
	 * Le nom du joueur
	 */
	private String nom;
	/**
	 * Constructeur créant un joueur avec un nom
	 */
	public Joueur() {
		nom=Clavier.lireString("Donner le nom du joueur : ");
	}
	/**
	 * Méthode retournant le nom du joueur
	 * @return Chaine de caractères(String) Le nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Méthode permetant au joueur de proposer un entier
	 * @return Entier(in) L'entier proposé par le joueur
	 */
	public int nouvelleProp(int numero) {
		return (Clavier.lireInt("Proposition n°"+numero+" de "+getNom()+" : "));
	}
	/**
	 * Méthode retournant une chaine de caractères avec le nom du joueur
	 * @return Chaine de caractères(String) Méssage contenant le nom du joueur
	 */
	public String toString() {
		return ("Nom : "+getNom());
	}
}
package JeuSimpleMonoJoueur;
/**
 * Classe permetant de cr�er des joueurs
 * @author Desideri S�bastien
 * @version 0.1
 * @since 13/11/2017
 */
public class Joueur {
	/**
	 * Le nom du joueur
	 */
	private String nom;
	/**
	 * Constructeur cr�ant un joueur avec un nom
	 */
	public Joueur() {
		nom=Clavier.lireString("Donner le nom du joueur : ");
	}
	/**
	 * M�thode retournant le nom du joueur
	 * @return Chaine de caract�res(String) Le nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * M�thode permetant au joueur de proposer un entier
	 * @return Entier(in) L'entier propos� par le joueur
	 */
	public int nouvelleProp(int numero) {
		return (Clavier.lireInt("Proposition n�"+numero+" de "+getNom()+" : "));
	}
	/**
	 * M�thode retournant une chaine de caract�res avec le nom du joueur
	 * @return Chaine de caract�res(String) M�ssage contenant le nom du joueur
	 */
	public String toString() {
		return ("Nom : "+getNom());
	}
}
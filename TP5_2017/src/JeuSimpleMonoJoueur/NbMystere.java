package JeuSimpleMonoJoueur;
/**
 * Classe permetant de créer des nombres mystères
 * @author Desideri Sébastien
 * @version 0.1
 * @since 13/11/2017
 */
public class NbMystere {
	/**
	 * Valeur du nombre mystère
	 */
	private int valeur;
	/**
	 * Valeur maximal du nombre mystère
	 */
	private int valeurMax;
	/**
	 * Méthode générant un entier aléatoire superieur à 0 et strictement inférieur à la valeur maximal du nombre mystère
	 */
	private void genere() {
		double valeurReel=valeurMax*Math.random();
		valeur = (int) valeurReel;
	}
	/**
	 * Méthode retournant vrai si le nombre proposé est égal au nombre mystère, sinon retourne faux et écrit dans la console si le nombre mystère est inférieur ou supérieur au nombre proposé en parametre
	 * @param prop Entier(int) Le nombre proposé par le joueur
	 * @return Booléen(boolean) Vrai si le nombre proposé est égal au nombre mystères sinon faux
	 */
	public boolean testProp(int prop) {
		if(valeur!=prop) {
			if(valeur<prop)
				System.out.println("Le nombre mystère est plus petit");
			else
				System.out.println("Le nombre mystère est plus grand");
		}
		return (valeur==prop);
	}
	/**
	 * Constructeur permetant d'implémenter la valeur maximal du nombre mystère et de générer ce dernier
	 * @param valeurMax Entier(int) La valeur maximal du nombre mystère
	 */
	public NbMystere(int valeurMax) {
		this.valeurMax=valeurMax;
		genere();
	}
	/**
	 * Constructeur permetant d'implémenter la valeur maximal du nombre mystère et de générer ce dernier
	 */
	public NbMystere() {
		this(Clavier.lireInt("Donner la valeur maximum du nombre mystère : "));
		genere();
	}
}
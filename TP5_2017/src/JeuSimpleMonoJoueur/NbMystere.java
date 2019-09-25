package JeuSimpleMonoJoueur;
/**
 * Classe permetant de cr�er des nombres myst�res
 * @author Desideri S�bastien
 * @version 0.1
 * @since 13/11/2017
 */
public class NbMystere {
	/**
	 * Valeur du nombre myst�re
	 */
	private int valeur;
	/**
	 * Valeur maximal du nombre myst�re
	 */
	private int valeurMax;
	/**
	 * M�thode g�n�rant un entier al�atoire superieur � 0 et strictement inf�rieur � la valeur maximal du nombre myst�re
	 */
	private void genere() {
		double valeurReel=valeurMax*Math.random();
		valeur = (int) valeurReel;
	}
	/**
	 * M�thode retournant vrai si le nombre propos� est �gal au nombre myst�re, sinon retourne faux et �crit dans la console si le nombre myst�re est inf�rieur ou sup�rieur au nombre propos� en parametre
	 * @param prop Entier(int) Le nombre propos� par le joueur
	 * @return Bool�en(boolean) Vrai si le nombre propos� est �gal au nombre myst�res sinon faux
	 */
	public boolean testProp(int prop) {
		if(valeur!=prop) {
			if(valeur<prop)
				System.out.println("Le nombre myst�re est plus petit");
			else
				System.out.println("Le nombre myst�re est plus grand");
		}
		return (valeur==prop);
	}
	/**
	 * Constructeur permetant d'impl�menter la valeur maximal du nombre myst�re et de g�n�rer ce dernier
	 * @param valeurMax Entier(int) La valeur maximal du nombre myst�re
	 */
	public NbMystere(int valeurMax) {
		this.valeurMax=valeurMax;
		genere();
	}
	/**
	 * Constructeur permetant d'impl�menter la valeur maximal du nombre myst�re et de g�n�rer ce dernier
	 */
	public NbMystere() {
		this(Clavier.lireInt("Donner la valeur maximum du nombre myst�re : "));
		genere();
	}
}
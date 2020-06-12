package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Magasin {
	private int argentDuDebut = 70;
	private IntegerProperty argentProperty = new SimpleIntegerProperty();
	public final static int prixSavonneuse = 7;
	public final static int avastirus = 5;
	public final static int gelHydroClaque = 9;
	public final static int siliteBang = 12;
	public final static int drPingoLimbo = 12;


	/**
	* constructeur de la classe magasin
	*/
	public Magasin() {
		this.argentProperty.set(argentDuDebut);
	}

	/**
	* m�thode incr�mentant l'argent du magasin de 1
	*/
	public void incrementerArgent() {
		this.argentProperty.setValue(argentProperty.getValue() + 1);

	}

	/**
	*  accesseur de la property argent
	* @return la property argent
	*/
	public IntegerProperty getArgentProperty() {
		return this.argentProperty;
	}

	/**
	* accesseur de la property argent
	* @return valeur de la property argent
	*/
	public int getArgent() {
		return this.argentProperty.getValue();
	}

	/**
	* m�thode permettant de soustraire à la sommet la valeur en param�tre
	*/
	public void enleverArgent(int somme) {
		try {
			this.argentProperty.setValue(argentProperty.getValue() - somme);
		} catch (Exception e) {
			System.out.println("Vous n'avez pas assez d'argent");
		}
		
	}

	/**
	* m�thode permettant d'ajouter au sommet la valeur en param�tre
	*/
	public void ajouterArgent(int somme) {
		this.argentProperty.setValue(argentProperty.getValue() + somme);
		
	}

}


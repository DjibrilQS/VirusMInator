package application.modele.virus;

import java.util.Arrays;
import java.util.List;

import application.modele.Environnement;
import application.modele.Hopital;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Virus {
	private IntegerProperty xProperty = new SimpleIntegerProperty();
	private IntegerProperty yProperty = new SimpleIntegerProperty();
	private int dx, dy; // direction
	private int atq, vie, pvMax;
	private double vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;
	public static int compteur;
	private int tpsPerso;
	private static int tpsSuivant = 200;
	protected Environnement env;
	private Hopital h1;
	/* 1 = basirus
	 * 2 = divirus
	 * 3 = healrus
	 * 4 = boomirus
	 * 5 = viterus
	 */
	public static List<Integer> listeVirusAttente = Arrays.asList(4, 4);/*liste des viruses a ajouter*/
	public static List<Integer> listeVirusAttente2 = Arrays.asList(2,2,3,4,5);
	public Virus(int vie, int atq, double vitesse, String nom, int x, int y, int tpsSpawn,Environnement env) { /* Constructeur Virus */
		this.ID = "v" + compteur;
		this.vie = vie;
		this.pvMax = vie;
		this.atq = atq;
		this.setVitesse(vitesse);
		this.nom = nom;
		this.setX(x);
		this.setY(y);
		compteur++;
		this.env = env;
		this.tpsPerso = tpsSuivant+tpsSpawn;
		System.out.println("v" + compteur);
		tpsSuivant += 300;
		
	}

	@Override
	public String toString() {
		return "Virus [xProperty=" + xProperty + ", yProperty=" + yProperty + ", dx=" + dx + ", dy=" + dy + ", atq="
				+ atq + ", vie=" + vie + ", vitesse=" + vitesse + ", nom=" + nom + ", ID=" + ID + ", tpsPerso="
				+ tpsPerso + "]";
	}

	public int getTempsSpawn() {
		return tpsPerso;
	}

	public String getNom() {
		return nom;
	}

	public String getId() {
		return ID;

	}

	public final int getX() {
		return this.xProperty.getValue();
	}

	public final IntegerProperty getXproperty() {
		return this.xProperty;
	}

	public final void setX(int n) {
		this.xProperty.setValue(n);

	}

	public final int getY() {
		return this.yProperty.getValue();
	}

	public final IntegerProperty getYproperty() {
		return this.yProperty;
	}

	public final void setY(int n) {
		this.yProperty.setValue(n);

	}

	public final int getVie() {
		return vie;

	}
	public final int getPvMax() {
		return this.pvMax;
	}

	public boolean estVivant() {
		return this.vie > 0;
	}

	/* Changer les 1, 2, et 0 en vitesse des virus */
	public void agit(Virus v) { /*Disparaitra quand on ajoute le BFS*/
		if (v instanceof VirusViterus) {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() +(int) (v.getVitesse());
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 808
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() >  288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
				this.setX(1235);
				this.setY(288);

			}
		
		if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue() >= 1104) {
			v.meurt();
			v.infligerDegats(v.getAtq());
			

		}
//			System.out.println(this.getId() + "x : " + this.getX());
//			System.out.println(this.getId() + "y : " + this.getY() + "\n");
		} else if (v instanceof VirusViboomrus) {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 808
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
				this.setX(1235);
				this.setY(288);

			}
		
		if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue() >= 1104) {
			v.meurt();
			v.infligerDegats(v.getAtq());
			

		}
//			System.out.println(this.getId() + "x : " + this.getX());
//			System.out.println(this.getId() + "y : " + this.getY() + "\n");
		} else {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 838
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 838 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235
					&& (this.getYproperty().getValue() == 288 || this.getYproperty().getValue() < 290)) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue() >= 1104) {/*Infliger
			des d�gats � l'hopital*/
				/* Tout ce qui est du d�placement = m�thode se d�placer.
				 * M�thode agir = seD�placer + appliquerEffets 
				 * supprimer le instance of de seD�placer et le coder dans chaque Viruses diff�rents des autres*/
				v.meurt();
				v.infligerDegats(v.getAtq());
				/* cr�er methode creer tir en abstraite pour factoriser le code (Public Tir creerTir(){}
				 * */

			}
		}/* On aurait pu faire une classe effet avec des sous classes et les ajouter en tant qu'attribut*/
//		System.out.println(this.getId() + "x : " + this.getX());
//		System.out.println(this.getId() + "y : " + this.getY() + "\n");
		v.appliquerEffets();
	}

	protected abstract void appliquerEffets();

	private void infligerDegats(int atq2) {
		this.h1.setVie(this.h1.getVie() - atq2);	
	}

	private int getAtq() {
		return this.atq;
	}

	private void meurt() {
		this.vie = 0;
		
	}

	/**
	 * @return the vitesse
	 */
	public double getVitesse() {
		return vitesse;
	}
//	public void slowVirus(double slow) {
//		
//		this.setVitesse(this.vitesse/slow);
//		
//	}

	public void setVitesse(double vitesse) {
		if(vitesse<1) {
			this.vitesse = 1.0;
		} else {
		this.vitesse = vitesse;
		}
	}

	public void setVie(double newVie) {
		this.vie = (int) newVie;

	}

}
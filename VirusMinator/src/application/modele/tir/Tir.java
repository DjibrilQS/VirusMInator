package application.modele.tir;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public class Tir {
	private int atq;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private int destinationX;
	private int destinationY;
	private String ID;
	private int portee;
	protected Environnement env;
	private static int compteur;
	
	public Tir (int atq, int x, int y, int portee, int destinationX, int destinationY) {
		this.atq = atq;
		this.xProperty.set(x);
		this.yProperty.set(y);
		this.destinationX = destinationX;
		this.destinationY = destinationY;
		this.portee = portee;
		this.ID = "tir"+compteur;
		compteur++;
	}


	public String getId() {

		return ID;

	}

	public final int getX() {
		return xProperty.getValue();
	}

	public final IntegerProperty getXProperty() {
		return xProperty;
	}

	public final int getY() {
		return yProperty.getValue();
	}

	public final IntegerProperty getYProperty() {
		return yProperty;
	}

	public final void setX(int n) {
		xProperty.setValue(n);
	}

	public final void setY(int n) {
		yProperty.setValue(n);
	}

	public double getAtq() {
		return atq;
	}

	public void setAtq(int atq2) {
		this.atq = atq2;
	}/*
	public void seDeplace() {
		for (int i = 0; i < env.getViruses().size(); i++) {
//			System.out.println(env.getViruses());
			if (env.getViruses().get(i).estVivant()) {
				if ((this.getY() - this.portee <= env.getViruses().get(i).getY()
						&& env.getViruses().get(i).getY() <= this.getY() + this.portee)
						&& (this.getX() - this.portee <= env.getViruses().get(i).getX()
								&& env.getViruses().get(i).getX() <= this.getX() + this.portee)) {
					return env.getViruses().get(i);
				}
			}
		}
		return null;
	}
public void agit() {
		
		if (temps % this.atqSpeed ==0  && this.VirusAPorteeDeTir() != null) // tentative d'evittement du null pointer exception
		{
			double newVie = (VirusAPorteeDeTir().getVie() - this.getAtq());
			VirusAPorteeDeTir().setVie(newVie);
			//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
			//code pour tirer / apelle de la m�thode tir
		}
	}*/
}

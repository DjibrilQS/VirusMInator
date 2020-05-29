package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleDocteurPingoLimbo extends Tourelles{
	// si il est plac� proche de 2 tourelle les tourelles adjacentes prennent une am�lioration de vitesse d�attaque

	private double  boostAtqSpeed;
	
	public TourelleDocteurPingoLimbo(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);
		
		this.boostAtqSpeed=1.2;
	}

	public void setBoostatqSpeed(double boostAtqSpeed2) {
		this.boostAtqSpeed = boostAtqSpeed2;
		}
	

	@Override
	public void amelioration() {

		this.setBoostatqSpeed(boostAtqSpeed+2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);		
	}



	@Override
	public void tirer() {
			
		TourelleAPorteeDeTir().boostAttaqueSpeed(boostAtqSpeed);


}
}

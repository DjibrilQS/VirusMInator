package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.virus.Virus;

public class TourelleSilliteBang extends TourellesAvecDegats {

	

	// puissante tourelle qui balance des rockets de super loin mais prend du temps
	// � recharger.
	
	
	
	public TourelleSilliteBang(int x, int y, Environnement env) {
		super(250, 500, "TourelleSilliteBang", x, y, env);		
		this.setAtq(1000);

	}


	@Override
	public void amelioration() {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

	}

	@Override
	public void tirer() {

		Virus v = VirusAPorteeDeTir();
		double newVie = (v.getVie() - this.getAtq());
		v.setVie(newVie);
		Tir t1 = new TirAvecDegats(this.getX(), this.getY(), v, this.env,this.getAtq(), this.getPortee());
		this.env.ajouterListeTirs(t1);
		//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		//code pour tirer / apelle de la m�thode tir
			}


	

}

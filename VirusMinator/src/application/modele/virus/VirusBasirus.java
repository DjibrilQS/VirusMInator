package application.modele.virus;

import application.modele.Environnement;

public class VirusBasirus extends Virus {

	public VirusBasirus(int vie, int atq, double vitesse, String nom, int x, int y, int tps,Environnement env) {
		super(vie, atq, vitesse, nom, x, y, tps, env);
	}

	@Override
	protected void agit() {
		
	}

}

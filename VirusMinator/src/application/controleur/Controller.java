package application.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Config;
import application.modele.Environnement;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.tourelles.TourelleDocteurPingoLimbo;
import application.modele.tourelles.TourelleHydroClaque;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.tourelles.TourelleSilliteBang;
import application.modele.tourelles.Tourelles;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.virus.VirusDivirus;
import application.modele.virus.VirusVhealrus;
import application.modele.virus.VirusViboomrus;
import application.modele.virus.VirusViterus;

public class Controller implements Initializable {

	@FXML
	private Button seDeplace;

	@FXML
	private Button Reinit;

	@FXML
	private Button placerEnnemis;

	@FXML
	private Button Start;
	@FXML
	private HBox shopTFT;

	@FXML
	private VBox teteVilain;

	@FXML
	private HBox shopSavon;

	@FXML
	private HBox shopGelHydro;

	@FXML
	private HBox shopSlow;

	@FXML
	private HBox shopMask;

	@FXML
	private HBox shopPingoLimbo;

	@FXML
	private VBox teteHero;

	@FXML
	private TilePane map;

	@FXML
	private Pane panneauEnnemis;
	@FXML
	private Button restart;

	private Environnement e1;

	private Timeline gameLoop;

	public static int temps;

	@FXML
	private Button bouttonVendre;
	@FXML
	private ImageView savonneuse;
	@FXML
	private ImageView avastirus;
	@FXML
	private ImageView siliteBang;
	@FXML
	private ImageView drPingoLimbo;
	@FXML
	private ImageView gelHydroClaque;
	@FXML
	private Label money;
	@FXML
	private Pane panneauTourelles;

	public void creerTerrainVue() {
		System.out.println(Config.listeMap.size());
		savonneuse.setImage((Image) (getImgg("/src/ressources/magasin/gelHydro.png")));
		avastirus.setImage((Image) (getImgg("/src/ressources/magasin/Avast.png")));
		gelHydroClaque.setImage((Image) (getImgg("/src/ressources/magasin/gel-hydoralcoolique.png")));
		siliteBang.setImage((Image) (getImgg("/src/ressources/magasin/javel.png")));
		drPingoLimbo.setImage((Image) (getImgg("/src/ressources/magasin/drPingoLimbo.png")));

		/*
		 * ImageView shopSavonSolid =
		 * Config.getImg("/src/ressources/tourelles/solidSavon.png");
		 * shopSavon.getChildren().add(shopSavonSolid); ImageView shopHydroGel =
		 * Config.getImg("/src/ressources/tourelles/gelHydro.png");
		 */

		for (int i = 0; i < Config.listeMap.size(); i++) {
			ImageView blancHopital = Config.getImg("/src/ressources/tiles/blancHopital");
			ImageView herbe = Config.getImg("/src/ressources/tiles/herbe.png");
			ImageView BordTerrain = Config.getImg("/src/ressources/tiles/BordTerrain.png");
			ImageView hitBoxHosto = Config.getImg("/src/ressources/tiles/hitBoxHosto.png");
			ImageView rougeHopital = Config.getImg("/src/ressources/tiles/rougeHopital.png");
			ImageView sableChemin = Config.getImg("/src/ressources/tiles/sableChemin.png");
			ImageView sableTerrain = Config.getImg("/src/ressources/tiles/sableTerrain.png");
			ImageView spawnMob = Config.getImg("/src/ressources/tiles/spawnMob.png");
			ImageView spawnTourelles = Config.getImg("/src/ressources/tiles/spawnTourelles.png");
			ImageView vertEnnemi = Config.getImg("/src/ressources/tiles/vertEnnemi.png");
			ImageView violetEnnemi = Config.getImg("/src/ressources/tiles/violetEnnemi.png");
			String retour = Config.imageDe(Config.listeMap.get(i));
			switch (retour) {
			case "blancHopital":
				blancHopital.setId("blancHosto");
				map.getChildren().add(blancHopital);
				break;
			case "herbe":
				herbe.setId("herbe");
				map.getChildren().add(herbe);
				break;
			case "BordTerrain":
				BordTerrain.setId("BordTerrain");
				map.getChildren().add(BordTerrain);
				break;
			case "hitBoxHosto":
				hitBoxHosto.setId("hitBoxHosto");
				map.getChildren().add(hitBoxHosto);
				break;
			case "rougeHopital":
				rougeHopital.setId("rougeHospital");
				map.getChildren().add(rougeHopital);
				break;
			case "sableChemin":
				sableChemin.setId("sableChemin");
				map.getChildren().add(sableChemin);
				break;
			case "sable":
				sableTerrain.setId("sableTerrain");
				map.getChildren().add(sableTerrain);
				break;
			case "spawnMob":
				spawnMob.setId("spawnMob");
				map.getChildren().add(spawnMob);
				break;
			case "spawnTourelles":
				spawnTourelles.setId("spawnTourelles");
				map.getChildren().add(spawnTourelles);
				System.out.println(spawnTourelles);
				spawnTourelles.setOnMouseClicked(e -> clicTourelle(e));
				break;
			case "vertEnnemi":
				vertEnnemi.setId("vertEnnemi");
				map.getChildren().add(vertEnnemi);
				break;
			case "violetEnnemi":
				violetEnnemi.setId("violetEnnemi");
				map.getChildren().add(violetEnnemi);
				break;
			}

		}
		/*
		 * teteHero.getChildren().add(Config.getImg("/src/ressources/tete.png"));
		 * teteVilain.getChildren().add(Config.getImg("/src/ressources/tete.png"));
		 */

	}

	/*
	 * @FXML void creerSprite(ActionEvent event) { Circle r = new Circle(10);
	 * r.setFill(Color.RED); r.setTranslateX(10); r.setTranslateY(10);
	 * panneauEnnemis.getChildren().add(r); }
	 */

	public void ajouter() {
		this.e1.initVirus(7);
	}

	/*
	 * void supprimer(ActionEvent event) { for (int i = 0; i <
	 * map.getChildren().size(); i++) { ImageView spawnTourelles =
	 * Config.getImg("/src/ressources/tiles/spawnTourelles.png"); String retour =
	 * Config.imageDe(Config.listeMap.get(i)); if
	 * (map.getChildren().contains(tourelleGel)) { map.getChildren().remove(i); } }
	 * // for (int i = 0; i < e1.getTourelles().size(); i++) { // // } // for (int i
	 * = 0; i < panneauEnnemis.getChildren().size(); i++) { //
	 * if(panneauEnnemis.getChildren().get(i).contains(tourelleGel)) { // // } // }
	 * }
	 * 
	 * //>>>>>>> branch 'develop' of https:github.com/vakter23/VirusMInator.git
	 * /*public void dessinEnnemi() { ImageView Virus =
	 * Config.getImg("/src/ressources/Virus/base_Virus.png");
	 * Virus.setTranslateX(720); Virus.setTranslateY(720);
	 * getPanneauEnnemis().getChildren().add(Virus); }
	 */
	
	void supprimer(ActionEvent event) {
//		for (int i = 0; i < map.getChildren().size(); i++) {
//			ImageView spawnTourelles = Config.getImg("/src/ressources/tiles/spawnTourelles.png");
//			String retour = Config.imageDe(Config.listeMap.get(i));
//			if (map.getChildren().contains()) {
//				map.getChildren().remove(i);
//			}
//		}
//    	for (int i = 0; i < e1.getTourelles().size(); i++) {
//			
//		}
//    	for (int i = 0; i < panneauEnnemis.getChildren().size(); i++) {
//			if(panneauEnnemis.getChildren().get(i).contains(tourelleGel)) {
//				
//			}
//		}
	}

//>>>>>>> branch 'develop' of https:github.com/vakter23/VirusMInator.git
	/*public void dessinEnnemi() {
		ImageView Virus = Config.getImg("/src/ressources/Virus/base_Virus.png");
		Virus.setTranslateX(720);
		Virus.setTranslateY(720);
		getPanneauEnnemis().getChildren().add(Virus);
	}
*/
	/*
	 * public void dessinEnnemi() { ImageView Virus =
	 * Config.getImg("/src/ressources/Virus/base_Virus.png");
	 * Virus.setTranslateX(720); Virus.setTranslateY(720);
	 * getPanneauEnnemis().getChildren().add(Virus); }
	 */

	/*
	 * Lorsqu'on clique sur un spawnTourelle puis sur une tourelle du shop la
	 * tourelle est automatiquement ajout�e a la liste
	 */
	void clicTourelle(MouseEvent event) {
//		ImageView sourc = (ImageView) event.getSource();
//		Image spawnTourellesR = getImgg("/src/ressources/tiles/spawnTourelleRouge.png");
//		sourc.setImage(spawnTourellesR);
		event.getTarget();
		Node test = (Node) event.getSource();
		System.out.println("x=" + test.getLayoutX() + "y = " + test.getLayoutY());
//		System.out.println("clic tourelle" + event.getSceneX()() + event.getSceneY() + event.getSource().);
		if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {
			savonneuse.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {
					Tourelles t1 = new TourelleSavonneuse(20, 128, "0", (int) test.getLayoutX(),
							(int) test.getLayoutY(), e1);
					System.out.println(t1);
					this.e1.ajouterTourelles(t1);
				}
			});
			avastirus.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(
							new TourelleMousseuse(0, 0, "", (int) test.getLayoutX(), (int) test.getLayoutY(), e1));
				}
			});
			gelHydroClaque.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(
							new TourelleHydroClaque(0, 0, "", (int) test.getLayoutX(), (int) test.getLayoutY(), e1));
				}
			});
			siliteBang.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(
							new TourelleSilliteBang( 0, 0, "", (int) test.getLayoutX(), (int) test.getLayoutY(), e1));
				}
			});
			drPingoLimbo.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(new TourelleDocteurPingoLimbo(0, 0, "", (int) test.getLayoutX(),
							(int) test.getLayoutY(), e1));
				}
			});
		} else {
			System.out.println("taille avant boucle" + e1.getTourelles().size());
			System.out.println("l id de la tuile " + test.getId());
			bouttonVendre.setOnMouseClicked((e) -> {
				for (int i = 0; i < this.e1.getTourelles().size(); i++) {
					if (this.e1.getTourelles().get(i).getX() == test.getLayoutX()
							&& this.e1.getTourelles().get(i).getY() == test.getLayoutY()) {
						this.e1.getTourelles().remove(e1.getTourelles().get(i));
						System.out.println("xx=" + e1.getTourelles().get(0).getX());
						System.out.println("yy=" + e1.getTourelles().get(0).getY());
						System.out.println("taille apres boucle" + e1.getTourelles().size());


					}
				}
			});
		}
	}


	public boolean verifiePlaceLibre(double d, double e) {
		for (int i = 0; i < this.e1.getTourelles().size(); i++) {
			if (this.e1.getTourelles().get(i).getX() == d && this.e1.getTourelles().get(i).getY() == e) {
				return false;
			}
		}
		return true;
	}

	private static Image getImgg(String... paths) {
		return new Image(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
	}

	public void tir() {
		
	}
	/*
	 * @FXML void placerEnnemis(ActionEvent event) {
	 * System.out.println("lancement"); dessinEnnemi(); }
	 */
	/*@FXML
	void placerEnnemis(ActionEvent event) {
		System.out.println("lancement");
		dessinEnnemi();
	}*/
//	void placerEnnemis(ActionEvent event) {
//		Circle r = new Circle(3);
//		r.setFill(Color.RED);
//		r.setId("rond");
//		r.setTranslateX(0);
//		r.setTranslateY(0);
//		r.setOnMouseClicked(e-> System.out.println("clic sur acteur"+e.getSource()));
//		map.getChildren().add(r);
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		 * Appeler lvl1 qui appelera la methode de cr�ation de map, et apr�s utiliser un
		 * switch pour afficher Victoire ou d�faite, et niveau suivant.
		 */
		this.e1 = new Environnement(1600, 800);
		this.panneauEnnemis.setMaxWidth(1632);
		this.panneauEnnemis.setMaxHeight(832);
		this.e1.getViruses().addListener(new MonObservateurViruses(panneauEnnemis));
		creerTerrainVue();
		System.out.println(this.e1.getViruses().size());
		ajouter();
		System.out.println("Viruses initialis�s");
		initAnimation();
		System.out.println("fait");
//		initAnimation(this.e1.getViruses().get(0));

		// demarre l'animation
		this.e1.getTourelles().addListener(new ecouteurTourelle(panneauEnnemis));
		gameLoop.play();
//		System.out.println(e1.getViruses().get(0).getX());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}

	private void initAnimation() {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kf = new KeyFrame(
				// on d�finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.0955),

				// on d�finit ce qui se passe � chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 8000) {
						System.out.println("fini");
						gameLoop.stop();
					} else if (temps % 5 == 0) {
						System.out.println("tour" + temps);
						unTour();
						// rafraichirPanneauEnnemis(/* v */);
					}

					temps++;
				}));
		gameLoop.getKeyFrames().add(kf);
		/* A MODIFIER */

//		
	}


	@FXML
	void reinit(ActionEvent event) {
		gameLoop.stop();
		System.out.println(this.e1.getViruses().size());
		//for (Virus v : this.e1.getViruses()) {
			this.e1.getViruses().clear();
			//}
//		for (int j = 0; j < this.e1.getTourelles().size(); j++) {
//			this.e1.getTourelles().remove(j);
//		}
		for (int i = 0; i < this.e1.getViruses().size(); i++) {
			System.out.println(this.e1.getViruses().get(i).getId());
		}
	
		this.temps = 0;
		System.out.println(this.e1.getViruses().size());

	}

	@FXML
	void Start(ActionEvent event) {
		ajouter();
		initAnimation();
		gameLoop.play();
	}
	private void initAnimation(Virus v) {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		double vitesse;
		if (true) {
			vitesse = v.getVitesse();
		} else {
			vitesse = v.getVitesse();
		}

		KeyFrame kf = new KeyFrame(
				// on d�finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.0009),

				// on d�finit ce qui se passe � chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 8032) {
//						System.out.println("fini");
						gameLoop.stop();
					} else if (temps % 5 == 0) {
//						System.out.println("un tour");
						unTour();
						// rafraichirPanneauEnnemis(/* v */);
					}
					temps++;
				}));
		gameLoop.getKeyFrames().add(kf);
		/* A MODIFIER */

//		
	}
	
	void unTour() {
		this.e1.unTour();

	}

	public void creerSpriteVirus(Virus v) {
		Circle r;
		ImageView VirusActuel;
		/*
		 * { Demander � la prof pour la gameloop, et pour la facon d'afficher un ennemi
		 * en fonction de sa sous classe
		 * 
		 *
		 */

		// this.e1.getViruses().addListener()
		if (v instanceof VirusBasirus) {
			/*
			 * VirusActuel = Config.getImg("/src/ressources/virus/base_Virus.png");
			 * VirusActuel.setId(v.getId());
			 * VirusActuel.translateXProperty().bind(v.getXproperty());
			 * VirusActuel.translateXProperty().bind(v.getYproperty());
			 * panneauEnnemis.getChildren().add(VirusActuel);
			 */

			r = new Circle(3);
			r.setFill(Color.RED);
			r.setId(v.getId());
			r.translateXProperty().bind(v.getXproperty());
			r.translateYProperty().bind(v.getYproperty());
			panneauEnnemis.getChildren().add(r);
		} /*
			 * else if (v instanceof VirusDivirus) { ajouter(v); ImageView VirusDivirus =
			 * Config.getImg("/src/ressources/virus/divisible_Virus.png");
			 * VirusDivirus.setId(v.getId()); VirusDivirus.setTranslateX(v.getX());
			 * VirusDivirus.setTranslateY(v.getY());
			 * panneauEnnemis.getChildren().add(VirusDivirus); } else if (v instanceof
			 * VirusVhealrus) { ajouter(v); ImageView VirusVhealrus =
			 * Config.getImg("/src/ressources/virus/healing_Virus.png");
			 * VirusVhealrus.setId(v.getId()); VirusVhealrus.setTranslateX(v.getX());
			 * VirusVhealrus.setTranslateY(v.getY());
			 * panneauEnnemis.getChildren().add(VirusVhealrus); } else if (v instanceof
			 * VirusViboomrus) { ajouter(v); ImageView VirusViboomrus =
			 * Config.getImg("/src/ressources/virus/impact_Virus.png");
			 * VirusViboomrus.setId(v.getId()); VirusViboomrus.setTranslateX(v.getX());
			 * VirusViboomrus.setTranslateY(v.getY());
			 * panneauEnnemis.getChildren().add(VirusViboomrus); } else if (v instanceof
			 * VirusViterus) { ajouter(v); ImageView VirusViterus =
			 * Config.getImg("/src/ressources/virus/rapid_Virus.png");
			 * VirusViterus.setId(v.getId()); VirusViterus.setTranslateX(v.getX());
			 * VirusViterus.setTranslateY(v.getY());
			 * panneauEnnemis.getChildren().add(VirusViterus); }
			 */

	}

	public String lvl1() {
		return null;
		/*
		 * faire retourner "Victoire" si on survit, "Defaite" sinon. Faire pareil pour
		 * tout les niveaux
		 */
	}

	public Pane getPanneauEnnemis() {
		return panneauEnnemis;
	}

	public void setPanneauEnnemis(Pane panneauEnnemis) {
		this.panneauEnnemis = panneauEnnemis;
	}
}

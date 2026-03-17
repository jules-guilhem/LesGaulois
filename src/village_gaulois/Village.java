package village_gaulois;

import personnage.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;

	public Village(String nom, int nbVillageoisMax, Gaulois chef) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (nbVillageois >= numVillageois) {
			return villageois[numVillageois - 1];
		}
		System.out.println("Il n’y a pas autant d’habitants dans notre village !");
		return null;
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + getNom() + "\" du chef " + getChef() + " vivent les légendaires gaulois :");
		for (Gaulois gaulois : villageois) {
			if (gaulois != null) {
				System.out.println("- " + gaulois.getNom());
			}
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", 30, abraracourcix);
		village.trouverVillageois(30);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		village.afficherVillageois();

	}

}

package personnage;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village = null;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
		effetPotion -= 1;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter(Gaulois gaulois) {
		if (gaulois == gaulois.village.getChef()) {
			parler("Bonjour, je m'appelle " + getNom() + ". Je suis le chef du village : " + gaulois.village.getNom());
		} else if (gaulois.village != null) {
			parler("Bonjour, je m'appelle " + getNom() + ". J'habite le village : " + gaulois.village.getNom());
		} else {
			parler("Bonjour, je m'appelle " + getNom() + ". Je voyage de village en village.");
		}
	}

}

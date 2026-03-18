package personnage;

import objet.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup >= 0 : "la force du coup reçu doit être positive";
		int a = force;
		force -= forceCoup;
		if (force<1) {
			force = 0;
			parler("J'abandonne !");
		}
		else {
			parler("Aïe");
		}
		assert a>=force : "la force du Romain ne peut pas augmenter";
	}
	
	
	private boolean isInvariantVerified() {
		if (this.force < 0) {
			return false;
		} 
		return true;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 -> System.out.println("Le soldat "+ this.getNom() +" est déjà bien protégé !");		
		case 1 -> this.possedeDeja(equipement);
		default -> 
		
		throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		}
		
	}
	
	private void possedeDeja(Equipement equipement) {
		if (equipement == this.equipements[nbEquipement]) {
			System.out.println("Le soldat "+ this.getNom() +" possède déjà un "+ this.equipements[nbEquipement] +" !");
		}
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		assert minus.isInvariantVerified() : "la force d’un Romain est toujours positive" ;
		
		System.out.println(Equipement.BOUCLIER + " " + Equipement.CASQUE);
	}
	
	
	
	
	
}

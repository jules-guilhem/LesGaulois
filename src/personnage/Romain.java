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

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup >= 0 : "la force du coup reçu doit être positive";
//		int a = force;
//		force -= forceCoup;
//		if (force<1) {
//			force = 0;
//			parler("J'abandonne !");
//		}
//		else {
//			parler("Aïe");
//		}
//		assert a>=force : "la force du Romain ne peut pas augmenter";
//	}

	private boolean isInvariantVerified() {
		if (this.force < 0) {
			return false;
		}
		return true;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
			break;
		case 1:
			this.possedeDeja(equipement);
			break;
		default:
			this.equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + this.getNom() + " s'equipe avec " + equipement + ".");

		}

	}

	private void possedeDeja(Equipement equipement) {
		if (equipement == this.equipements[nbEquipement - 1]) {
			System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equipement + " !");
		} else {
			this.equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + this.getNom() + " s'equipe avec " + equipement + ".");
		}

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		assert minus.isInvariantVerified() : "la force d’un Romain est toujours positive";

		System.out.println(Equipement.BOUCLIER + " " + Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + " , et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			texte += "\n Mais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (resistanceEquipement > forceCoup) {
			forceCoup = 0;
		} else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public int getForce() {
		return force;
	}

}

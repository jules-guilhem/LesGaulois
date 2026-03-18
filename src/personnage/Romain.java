package personnage;

public class Romain {
	private String nom;
	private int force;
	
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
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		assert minus.isInvariantVerified() : "la force d’un Romain est toujours positive" ;
	}
	
	
	
	
	
}

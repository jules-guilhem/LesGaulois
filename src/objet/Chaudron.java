package objet;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	
	public Chaudron() {
		this.quantitePotion = 0;
		this.forcePotion = 0;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public Boolean resterPotion() {
		return (quantitePotion > 0);
	}
	
	public int prendreLouche() {
		if (resterPotion()) {
			quantitePotion -=1;
			return forcePotion;
		} 
		else {
			return 0;
		}
		
	}
	
}

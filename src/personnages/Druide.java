package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le Druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin
				+ " jusqu'à " + effetPotionMax + ".");

	}

	public String getNom() {
		return nom;

	}

	public void parler(String texte) {
		// TODO Auto-generated method stub
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	private String prendreParole() {
		return "le Druide" + nom + ":";
	}

	public void preparerPotion() {
		Random random = new Random();
		forcePotion = effetPotionMin + random.nextInt(effetPotionMax - effetPotionMin + 1);
		if (forcePotion > 7) {
			parler("j'ai fait une potion qui est Mashallah, sa force est de " + forcePotion);
		} else {
			parler("c'est une mauvaise potion mais tkt jte fais un prix d'amis, sa force est de " + forcePotion);

		}
	}

	public void booster(Gaulois gaulois) {
		if ("Obélix".equals(gaulois.getNom())) {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}

}

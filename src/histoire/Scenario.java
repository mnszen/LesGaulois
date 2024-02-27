package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Druide panoramix = new Druide("Panoramix", 5, 10);
	panoramix.parler("je vais aller préparer une petite potion");
	panoramix.preparerPotion();
    Gaulois obelix = new Gaulois("Obélix", 25);
    Gaulois asterix = new Gaulois("Asterix", 8);
    Romain minus = new Romain("Minus", 6);
    panoramix.booster(obelix);
    obelix.parler("c'est pas juste sah");
    panoramix.booster(asterix);
    asterix.parler("bonjour");
    minus.parler("un ara...");
    asterix.frapper(minus);
	}
	

}

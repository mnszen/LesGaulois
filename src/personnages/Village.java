package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois++] = gaulois;
		}
	}

	public Gaulois trouverHabitant(int i) {
		if (i < nbVillageois) {
			return villageois[i];
		}
		return null;
	}

	public void afficherVillageois() {
		System.out.println("Dans le village des " + getNom() + ", ou le chef est "
				+ (chef != null ? chef.getNom() : "inconnu") + ", habitent:");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obélix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obélix);
		village.afficherVillageois();
		System.out.println(Equipement.BOUCLIER);
	}
}

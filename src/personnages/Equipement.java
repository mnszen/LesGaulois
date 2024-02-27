package personnages;


public enum Equipement {
	CASQUE("Casque"), BOUCLIER("Bouclier");

	private final String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}

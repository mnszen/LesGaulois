package personnages;

public class Romain {
	private String nom;
	private int force;

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");

	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	private String prendreParole() {
		return "le romain " + nom;
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");

		} else {
			parler("J'abandonne");
		}

	}

}

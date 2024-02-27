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
		assert force>0;
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
	public static void main(String[] args) {
		Romain minus= new Romain("Minus",-6);
		System.out.println(minus.getNom());
	}
	}

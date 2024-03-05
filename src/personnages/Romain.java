package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");

	}

	public int getForce() {
		return force;
	}

	public Romain(String nom, int force) {
	    if (force <= 0) {
	        throw new IllegalArgumentException("la force doit être positif");
	    }
	    else{this.nom = nom;
		this.force = force;
		}
	}

	private String prendreParole() {
		return "le romain " + nom;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup<0) {
			forceCoup=0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int v_debut = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//
//		} else {
//			parler("J'abandonne");
//		}
//		assert v_debut > force;
//	}

	public void sEquiper(Equipement nouvelEquipement) {
		switch (nbEquipement) {
		case 0:
		case 1:
			if (possedeDejaEquipement(nouvelEquipement)) {
				System.out.println("Le soldat " + nom + " possède déjà un " + nouvelEquipement + " !");
			} else {
				equipements[nbEquipement + 1] = nouvelEquipement;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + nouvelEquipement + ".");
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	private boolean possedeDejaEquipement(Equipement equipement) {
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == equipement) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.getNom());
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}

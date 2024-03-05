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

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
	}

	private String prendreParole() {
		return "le romain " + nom;
	}

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int v_debut=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");

		} else {
			parler("J'abandonne");
		}
		assert v_debut>force;
	}
	
    public void sEquiper(Equipement nouvelEquipement) {
        switch (nbEquipement) {
            case 0:
            case 1:
                if (possedeDejaEquipement(nouvelEquipement)) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + nouvelEquipement + " !");
                } else {
                    equipements[nbEquipement++] = nouvelEquipement;
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
		Romain minus= new Romain("Minus",6);
		System.out.println(minus.getNom());
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE); 
        minus.sEquiper(Equipement.CASQUE);  
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
	}
	}

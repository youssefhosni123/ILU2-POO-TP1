package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private static class  Marche {
		private Etal[] etals;
		
		public Marche (int nbEtals)
		{
			etals= new Etal[nbEtals];
			for (int i=0;i<etals.length;i++ )
			{
				etals[i]=new Etal();
			}
		}
		 void utiliserEtal(int indiceEtal, Gaulois vendeur,String produit, int nbProduit)
		{
			 if (indiceEtal>=0 && indiceEtal<etals.length && !etals[indiceEtal].isEtalOccupe())
			 {
				 etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);	
			 System.out.println(vendeur.getNom() + " s'est installé à l'étal " + indiceEtal + " avec " + nbProduit + " " + produit + "(s).");
        } else {
            System.out.println("Impossible d'utiliser l'étal " + indiceEtal + ". L'étal est déjà occupé ou l'indice est invalide.");
        }
		}
		 int   trouveretatLibre()
		 {
			 for (int i=0;i<etals.length;i++)
			 {
				 if(!etals[i].isEtalOccupe())
				 {
					 return i;
				 }
				 
			 }
			 return -1;
		 }
		 Etal[] trouverEtals(String produit)
		 {
			 
			 
		 }
		
	}

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
}
package enael.eafc;

import java.util.Objects;

public class Chambre implements Comparable<Chambre> {
	private CategorieChambre categorie;
	private int etage, nbrMaxPersonne, nbrPersonnePresentent;
	private String identifiant, description;
	
	public Chambre(String id, CategorieChambre cat, int nbrMax, int etage, String description) {
		identifiant=id;
		categorie=cat;
		nbrMaxPersonne=nbrMax;
		this.etage=etage;
		this.description=description;
	}

	public CategorieChambre getCategorie() {
		return categorie;
	}

	public int getEtage() {
		return etage;
	}

	public int getNbrMaxPersonne() {
		return nbrMaxPersonne;
	}

	public int getNbrPersonnePresentent() {
		return nbrPersonnePresentent;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etage, identifiant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chambre other = (Chambre) obj;
		return etage == other.etage && Objects.equals(identifiant, other.identifiant);
	}

	@Override
	public int compareTo(Chambre o) {
		// TODO Auto-generated method stub
		return this.identifiant.compareTo(o.getIdentifiant());
	}
}
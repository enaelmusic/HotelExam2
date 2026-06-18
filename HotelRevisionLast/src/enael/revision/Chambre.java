package enael.revision;

import java.util.Objects;

public class Chambre implements Comparable<Chambre>{
	private int etage, nbrMax;
	private int nbrPersonnesPresent = 0;
	private String identifiant, description;
	private ChambreCategorie categorie;
	
	public Chambre(String id, ChambreCategorie categorie, int etage, int nbrMax) {
		identifiant=id;
		this.categorie=categorie;
		this.etage=etage;
		description=categorie.getDescription();
		this.nbrMax=nbrMax;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identifiant);
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
		return Objects.equals(identifiant, other.identifiant);
	}

	public int getEtage() {
		return etage;
	}

	public int getNbrMax() {
		return nbrMax;
	}

	public int getNbrPersonnesPresent() {
		return nbrPersonnesPresent;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getDescription() {
		return description;
	}

	public ChambreCategorie getCategorie() {
		return categorie;
	}

	@Override
	public int compareTo(Chambre o) {
		// TODO Auto-generated method stub
		return this.identifiant.compareTo(o.getIdentifiant());
	}
	
	
}

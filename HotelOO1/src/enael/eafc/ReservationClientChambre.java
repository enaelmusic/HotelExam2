package enael.eafc;

import java.util.Objects;

public class ReservationClientChambre implements Comparable<ReservationClientChambre>{
	private Personne personne;
	private Chambre chambre;
	
	public ReservationClientChambre(Personne p, Chambre c) {
		personne=p;
		chambre=c;
	}
	

	public Personne getPersonne() {
		return personne;
	}


	public Chambre getChambre() {
		return chambre;
	}


	@Override
	public int compareTo(ReservationClientChambre o) {
		// DEFAULT: trier par nom
		if(this.personne.getNom().equals(o.getPersonne().getNom())) {
			if(this.personne.getPrenom().equals(o.getPersonne().getPrenom())) {
				return this.personne.getRegistreNational().compareTo(o.getPersonne().getRegistreNational());
			}
			else {
				return this.personne.getPrenom().compareTo(o.getPersonne().getPrenom());
			}
		}
		else {
			return this.personne.getNom().compareTo(o.getPersonne().getNom());
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(chambre, personne);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationClientChambre other = (ReservationClientChambre) obj;
		return Objects.equals(chambre, other.chambre) && Objects.equals(personne, other.personne);
	}

	
}

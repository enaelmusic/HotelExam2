package enael.revision;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation implements Comparable<Reservation>{
	private Personne personne;
	private Chambre chambre;
	private LocalDate reservationDate;
	
	
	public Reservation(Chambre c, Personne p) {
		personne=p;
		chambre=c;
		reservationDate=LocalDate.now();
	}

	public Personne getPersonne() {
		return personne;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chambre, personne, reservationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(chambre, other.chambre) && Objects.equals(personne, other.personne)
				&& Objects.equals(reservationDate, other.reservationDate);
	}

	@Override
	public int compareTo(Reservation o) {
		// TODO Auto-generated method stub
		if(this.personne.getNom().equals(o.getPersonne().getNom())) {
			if(this.personne.getPrenom().equals(o.getPersonne().getPrenom())) {
				return this.personne.getNumeroNational().compareTo(o.getPersonne().getNumeroNational());
			}
			else {
				return this.personne.getPrenom().compareTo(o.getPersonne().getPrenom());
			}
		}
		else {
			return this.personne.getNom().compareTo(o.getPersonne().getNom());
		}
	}
	
	

}

package enael.revision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Objects;

public class Personne implements Comparable<Personne> {
	private String numeroNational, nom, prenom;
	private LocalDate datenaissance;
	
	public Personne(String nn, String nom, String prenom, String dateString) {
		this.nom=nom;
		this.prenom=prenom;
		numeroNational=nn;
		convertirDate(dateString);
	}

	private void convertirDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		try {
			Instant i = sdf.parse(dateString).toInstant();
			ZoneId zid = ZoneId.systemDefault();
			datenaissance=LocalDate.ofInstant(i, zid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int donnerSonAge() {
		Period p = Period.between(datenaissance, LocalDate.now());
		return p.getYears();
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroNational);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return Objects.equals(numeroNational, other.numeroNational);
	}

	public String getNumeroNational() {
		return numeroNational;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	@Override
	public int compareTo(Personne o) {
		// TODO Auto-generated method stub
		if(this.nom.equals(o.getNom())) {
			if(this.prenom.equals(o.getPrenom())) {
				return this.numeroNational.compareTo(o.getNumeroNational());
			}
			else {
				return this.prenom.compareTo(o.getPrenom());
			}
		}
		else {
			return this.nom.compareTo(o.getNom());
		}
	}
	
}

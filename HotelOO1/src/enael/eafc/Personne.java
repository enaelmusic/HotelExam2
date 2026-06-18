package enael.eafc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Objects;

public class Personne implements Comparable<Personne>{
	String nom, prenom, registreNational;
	LocalDate dateNaissance;
	
	public Personne(String nom, String prenom, String registre, String naissance) {
		this.nom=nom;
		this.prenom=prenom;
		registreNational=registre;
		convertirDate(naissance);
	}

	private void convertirDate(String naissance) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		try {
			Instant i = sdf.parse(naissance).toInstant();
			ZoneId zid = ZoneId.systemDefault();
			dateNaissance=LocalDate.ofInstant(i, zid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int donnerSonAge() {
		Period p = Period.between(dateNaissance, LocalDate.now());
		return p.getYears();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getRegistreNational() {
		return registreNational;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(registreNational);
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
		return Objects.equals(registreNational, other.registreNational);
	}

	@Override
	public int compareTo(Personne o) {
		if(this.nom.equals(o.getNom())) {
			if(this.prenom.equals(o.getPrenom())) {
				return this.registreNational.compareTo(o.getRegistreNational());
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

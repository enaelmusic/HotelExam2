package enael.eafc;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hotel {
	private String nom;
	private Map<Chambre, TreeSet<Personne>> collectionHotel = new TreeMap<Chambre, TreeSet<Personne>>();
	public Hotel(String nom) {
		this.nom=nom;
	}
	public void ajouterChambres(Chambre...chambres) {
		for(Chambre chambre : chambres) {
			collectionHotel.put(chambre, new TreeSet<Personne>());
		}
	}
	public void ajouterPersonnesChambre(Chambre chambre, Personne...personnes) throws ChambreFullException {
		if(collectionHotel.containsKey(chambre)) {
			for(Personne personne:personnes) {
				if(chambre.getNbrPersonnePresentent()+1>chambre.getNbrMaxPersonne()) {
					throw new ChambreFullException("La chambre : "+chambre.getIdentifiant()+" est full");
				}
				else {
					collectionHotel.get(chambre).add(personne);
				}
			}
		}
	}
	public int compterNbrPersonne() {
		int resultat=0;
		for(Entry<Chambre, TreeSet<Personne>> ligne:collectionHotel.entrySet()) {
			for(Personne personne:ligne.getValue()) {
				resultat++;
			}
		}
		return resultat;
	}
	public TreeSet<ReservationClientChambre> fournirListePersonneParNom(){
		TreeSet<ReservationClientChambre> nvxSet = new TreeSet<ReservationClientChambre>();
		for(Entry<Chambre, TreeSet<Personne>> ligne:collectionHotel.entrySet()) {
			for(Personne personne:ligne.getValue()) {
				nvxSet.add(new ReservationClientChambre(personne, ligne.getKey()));
			}
		}
		return nvxSet;
	}
	public TreeSet<ReservationClientChambre> fournirPersonneMoin18(){
		TreeSet<ReservationClientChambre> nvxSet = new TreeSet<ReservationClientChambre>();
		for(Entry<Chambre, TreeSet<Personne>> ligne:collectionHotel.entrySet()) {
			for(Personne personne:ligne.getValue()) {
				if(personne.donnerSonAge()<18) {
					nvxSet.add(new ReservationClientChambre(personne, ligne.getKey()));
				}
			}
		}
		return nvxSet;
	}
	public Map<Chambre, TreeSet<Personne>> getCollectionHotel() {
		return collectionHotel;
	}
	public void setCollectionHotel(Map<Chambre, TreeSet<Personne>> collectionHotel) {
		this.collectionHotel = collectionHotel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(collectionHotel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(collectionHotel, other.collectionHotel);
	}
}
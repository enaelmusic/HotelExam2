package enael.revision;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hotel {
	private TreeMap<Chambre, TreeSet<Personne>> collectionHotel = new TreeMap<Chambre, TreeSet<Personne>>();
	
	public void ajouterChambre(Chambre...chambres) {
		for(Chambre chambre : chambres) {
			if(!collectionHotel.containsKey(chambre)) {
				collectionHotel.put(chambre, new TreeSet<Personne>());
			}
		}
	}
	
	public void ajouterPersonne(Chambre chambre, Personne...personnes) throws ChambreFullException {
		for(Personne personne : personnes) {
			if(collectionHotel.containsKey(chambre)) {
				if(1+chambre.getNbrPersonnesPresent()>chambre.getNbrMax()) {
					throw new ChambreFullException("Le nombre de personne maximum est déja atteint pour la chambre : "+chambre.getIdentifiant());
				}
				else {
					collectionHotel.get(chambre).add(personne);
				}
			}
		}
	}
	
	public int fournirNombrePersonne() {
		int resultat=0;
		for(Entry<Chambre, TreeSet<Personne>> ligne : collectionHotel.entrySet()) {
			for(Personne personne : ligne.getValue()) {
				resultat++;
			}
		}
		return resultat;
	}
	
	public Set<Entry<Chambre, TreeSet<Personne>>> fournirPersonneParChambre(){
		return collectionHotel.entrySet();
	}
	
	public TreeSet<Reservation> fournirPersonneParNom(){
		TreeSet<Reservation> reservColl = new TreeSet<Reservation>();
		for(Entry<Chambre, TreeSet<Personne>> ligne : collectionHotel.entrySet()) {
			for(Personne p : ligne.getValue()) {
				reservColl.add(new Reservation(ligne.getKey(), p));
			}
		}
		return reservColl;
	}
	
	public TreeSet<Reservation> fournirPersonneMoin18ParNom(){
		TreeSet<Reservation> reservColl = new TreeSet<Reservation>();
		for(Entry<Chambre, TreeSet<Personne>> ligne : collectionHotel.entrySet()) {
			for(Personne p : ligne.getValue()) {
				if(p.donnerSonAge()<18) {
					reservColl.add(new Reservation(ligne.getKey(), p));
				}
			}
		}
		return reservColl;
	}
	
	
}

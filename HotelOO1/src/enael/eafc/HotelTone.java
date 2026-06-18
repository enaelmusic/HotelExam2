package enael.eafc;

import java.util.Map.Entry;
import java.util.TreeSet;

public class HotelTone {
	private static volatile HotelTone instance;
	private Hotel hotel= new Hotel("Plaza");
	private HotelTone() {}
	
	public static HotelTone getInstance() {
		if(instance==null) {
			synchronized(HotelTone.class) {
				if(instance==null) {
					instance=new HotelTone();
				}
			}
		}
		return instance;
	}
	public void ajouterChambre(Chambre...chambres) {
		hotel.ajouterChambres(chambres);
		for(Chambre chambre : chambres) {
			System.out.println("La chambre : "+chambre.getIdentifiant()+" a été ajouter");
		}
	}
	public void ajouterPersonnesChambre(Chambre chambre, Personne...personnes) {
		for(Personne personne: personnes) {
			try {
				hotel.ajouterPersonnesChambre(chambre, personnes);
			} catch (ChambreFullException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
	}
	public void afficherPersonneParChambre() {
		for(Entry<Chambre, TreeSet<Personne>> ligne : hotel.getCollectionHotel().entrySet()) {
			for(Personne personne : ligne.getValue()) {
				System.out.println("Nom : "+personne.getNom()+", Prenom : "+personne.getPrenom()+",Chambre : "+ligne.getKey().getIdentifiant());
			}
		}
	}
	public void afficherPersonneParNom() {
		for(ReservationClientChambre reservation : hotel.fournirListePersonneParNom()) {
			System.out.println("Nom : "+reservation.getPersonne().getNom()+", Prenom : "+reservation.getPersonne().getPrenom()+",Chambre : "+reservation.getChambre().getIdentifiant());
		}
	}
	public void afficherPersonneMoin18() {
		for(ReservationClientChambre reservation : hotel.fournirPersonneMoin18()) {
			System.out.println("Nom : "+reservation.getPersonne().getNom()+", Prenom : "+reservation.getPersonne().getPrenom()+",Chambre : "+reservation.getChambre().getIdentifiant());
		}
	}

}

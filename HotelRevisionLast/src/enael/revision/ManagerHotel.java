package enael.revision;

public class ManagerHotel {
	private static volatile ManagerHotel instance;
	
	/**
	 * @param hotel : je suppose qu'un hotel poce un manager, et non qu'un manager gere plusieur hotel?
	 */
	private Hotel hotel= new Hotel();
	
	private ManagerHotel(){
		
	}
	
	public static ManagerHotel getInstance() {
		if(instance==null) {
			synchronized(ManagerHotel.class) {
				if(instance==null) {
					instance=new ManagerHotel();
				}
			}
		}
		return instance;
	}
	
	public void creeChambre(Chambre...chambres) {
		hotel.ajouterChambre(chambres);
	}
	
	public void ajouterPersonne(Chambre chambre, Personne...personnes) {
		try {
			hotel.ajouterPersonne(chambre, personnes);
		} catch (ChambreFullException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void afficherPersonneParChambre() {
		
	}

}

package enael.eafc;

public class MainOutHotelAnese {

	public static void main(String[] args) {
		Chambre c1 = new Chambre("CHBR-001",CategorieChambre.LUXE, 3, 2, "Description luxe");
		Chambre c2 = new Chambre("CHBR-002",CategorieChambre.GRAND_LUXE, 3, 4, "Description grand_luxe");
		Chambre c3 = new Chambre("CHBR-003",CategorieChambre.IMPERIAL, 4, 6, "Description imperial");
		
		Personne p1 = new Personne("Eickishi","Onizuka","881229-34142","29/12/1988" );
		Personne p2 = new Personne("Jaeger  ","Einer  ","191198-55155","19/11/1998" );
		Personne p3 = new Personne("Arlette ","Armin  ","001212-55155","12/12/2000" );
		Personne p4 = new Personne("Ackerman","Mikassa","061229-55155","29/12/2006" );
		Personne p5 = new Personne("Zodd    ","Guts   ","180529-55155","29/05/2018" );
		Personne p6 = new Personne("Saturo  ","Gojo   ","181301-55155","13/01/2018" );
		Personne p7 = new Personne("Jackson ","Janette","181014-55155","14/10/2018" );
		HotelTone ht = HotelTone.getInstance();
		
		ht.ajouterChambre(c1,c2,c3);
		ht.ajouterPersonnesChambre(c1, p1,p2 );
		ht.ajouterPersonnesChambre(c2, p3,p4,p5 );
		ht.ajouterPersonnesChambre(c3, p6,p7 );
		System.out.println("/////////////////////////////////////////////");
		ht.afficherPersonneParChambre();
		System.out.println("/////////////////////////////////////////////");
		ht.afficherPersonneParNom();
		System.out.println("/////////////////////////////////////////////");
		ht.afficherPersonneMoin18();
		
	}

}

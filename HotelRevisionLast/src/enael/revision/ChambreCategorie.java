package enael.revision;

public enum ChambreCategorie {
	LUXE("Description chambre de luxe"),
	GRAND_LUXE("Description chambre Grand Luxe"),
	IMPERIAL("Description chambre imperial");
	
	private String description ;
	
	private ChambreCategorie(String description) {
		this.description=description;		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

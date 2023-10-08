package n3exercici1;

public class Basquet extends Noticia{

	private String competicio;
	private String club;

	public Basquet(String titular, String competicio, String club) {
		super(titular);
		this.competicio = competicio;
		this.club = club;
	}

	public String getCompeticio() {
		return this.competicio;
	}
	public String getClub() {
		return this.club;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public float calcularPreuNoticia() {
		super.setPreu(250);

		if(this.getCompeticio().equalsIgnoreCase("Eurolliga")) {
			super.setPreu(super.getPreu() + 75);
		}

		if(this.getClub().equalsIgnoreCase("Barça") || this.getClub().equalsIgnoreCase("Madrid")) {
			super.setPreu(super.getPreu() + 75);
		}
		
		return super.getPreu();
	}

	@Override
	public int calcularPunts() {
		super.setPuntuacio(4);

		if(this.getCompeticio().equalsIgnoreCase("Eurolliga")) {
			super.setPuntuacio(super.getPuntuacio() + 3);
		}
		if(this.getCompeticio().equalsIgnoreCase("ACB")) {
			super.setPuntuacio(super.getPuntuacio() + 2);
		}
		if(this.getClub().equalsIgnoreCase("Barça") || this.getClub().equalsIgnoreCase("Madrid")) {
			super.setPuntuacio(super.getPuntuacio() + 1);
		}
		
		return super.getPuntuacio();
	}

}

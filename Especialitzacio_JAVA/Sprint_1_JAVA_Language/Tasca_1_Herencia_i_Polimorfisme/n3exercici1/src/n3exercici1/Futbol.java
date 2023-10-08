package n3exercici1;

public class Futbol extends Noticia{

	private String competicio;
	private String club;
	private String jugador;

	public Futbol(String titular, String competicio, String club, String jugador) {
		super(titular);
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
	}



	public String getCompeticio() {
		return this.competicio;
	}
	public String getClub() {
		return this.club;
	}
	public String getJugador() {
		return this.jugador;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}


	@Override
	public float calcularPreuNoticia() {
		super.setPreu(300);

		if(this.getCompeticio().equalsIgnoreCase("Lliga de Campions")) {
			super.setPreu(super.getPreu() + 100);
		}

		if(this.getClub().equalsIgnoreCase("Barça") || this.getClub().equalsIgnoreCase("Madrid")) {
			super.setPreu(super.getPreu() + 100);
		}

		if(this.getJugador().equalsIgnoreCase("Ferran Torres") || this.getJugador().equalsIgnoreCase("Benzema")) {
			super.setPreu(super.getPreu() + 50);
		}
		
		return super.getPreu();
	}

	@Override
	public int calcularPunts() {
		super.setPuntuacio(5);

		if(this.getCompeticio().equalsIgnoreCase("Lliga de Campions")) {
			super.setPuntuacio(super.getPuntuacio() + 3);
		}
		if(this.getCompeticio().equalsIgnoreCase("Lliga")) {
			super.setPuntuacio(super.getPuntuacio() + 2);
		}
		if(this.getClub().equalsIgnoreCase("Barça") || this.getClub().equalsIgnoreCase("Madrid")) {
			super.setPuntuacio(super.getPuntuacio() + 1);
		}
		if(this.getJugador().equalsIgnoreCase("Ferran Torres") || this.getJugador().equalsIgnoreCase("Benzema")) {
			super.setPuntuacio(super.getPuntuacio() + 1);
		}
		return super.getPuntuacio();
	}





}


public class MainCotxe {

	public static void main(String[] args) {
		
		CotxeIT vehicle1 = new CotxeIT("Vermell",1.6f,5,"Kia","Ceed","Diesel");//Això és el que rep el constru i que després s'assigna als this
		CotxeIT vehicle2 = new CotxeIT("Verd",1.2f,5,"Renault","Clio","benzina");
		
		vehicle1.setMarca("Nissan");
		System.out.println(vehicle1.getMarca());
		System.out.println(vehicle1.presentarse());
		System.out.println(vehicle2.presentarse());
	}

}

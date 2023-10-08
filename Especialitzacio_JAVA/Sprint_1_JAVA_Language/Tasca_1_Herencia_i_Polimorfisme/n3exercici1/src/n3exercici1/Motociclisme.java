package n3exercici1;

public class Motociclisme extends Noticia{
	
	private String equip;

	public Motociclisme(String titular, String equip) {
		super(titular);
		this.equip = equip;
	}

	public String getEquip() {
		return this.equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	@Override
	public float calcularPreuNoticia() {
		super.setPreu(100);

		if(this.getEquip().equalsIgnoreCase("Honda") || this.getEquip().equalsIgnoreCase("Yamaha")) {
			super.setPreu(super.getPreu() + 50);
		}
		return super.getPreu();
	}

	@Override
	public int calcularPunts() {
		super.setPuntuacio(3);

		if(this.getEquip().equalsIgnoreCase("Honda") || this.getEquip().equalsIgnoreCase("Yamaha")) {
			super.setPuntuacio(super.getPuntuacio() + 3);
		}
		return super.getPuntuacio();
	}

}

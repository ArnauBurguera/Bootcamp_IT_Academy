package s1t7n1ex2;

public class S1T7n1ex2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		TreballadorPresencial.benzina = 40.0;
		
		Treballador trebvallador1 = new Treballador("Joan","Pera",20.70d);
		TreballadorPresencial treballadorPresencial1 = new TreballadorPresencial("Ramón","Sifont",20.70d);
		TreballadorOnline treballadorOnline1 = new TreballadorOnline("Artús","Camallarg",20.70d);
		
		System.out.println("El sou del treballador1 és de " + trebvallador1.calcularSou(160) + ".");  
		System.out.println("El sou del treballadorPresencial1 és de " + treballadorPresencial1.calcularSou(160) + ".");  
		System.out.println("El sou del treballadorOnline1 és de " + treballadorOnline1.calcularSou(160) + ".");  
		
		System.out.println(treballadorPresencial1.informarTreball());  
		System.out.println(treballadorOnline1.informarTreball());

	}

}


public class M8Ex1_ArnauBurguera {
	
	public static void main(String[] args) {
		
		Ordinador desktop1 = new Ordinador("Dell","Inspirion Desktop");
		Ordinador desktop2 = new Ordinador("Lenovo","Legion Tower 5i","Intel® Core™i9-11900",32,1000f);
		
		
		desktop2.setProcessador("i5");
		System.out.println(desktop1.getModel());
		System.out.println(desktop1.executant("Eclipse"));
		System.out.println(desktop2.toString());
		
		
	}
}

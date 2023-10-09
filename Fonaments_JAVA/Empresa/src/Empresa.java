public class Empresa {

	public static void main(String[] args) {
		
		Treballador[] treballadors = new Treballador[4];
	
		treballadors[0] = new Treballador("Esther",42000, 13,2,2018);
		treballadors[1] = new Treballador("Alex",26000,1,2,2023);
		treballadors[2] = new Encarregat("Francesca",130000,5,12,2000,2000);
		Encarregat capRRHH = (Encarregat)treballadors[2];//pq per defecte passa a ser treballador al array i li hem de fer un casting
		//System.out.println(capRRHH.getPlus());
		treballadors[3] = new Treballador("Iu",83000,5,12,1998);
		
		capRRHH.aplicarPlus();
		
		for(int i = 0; i < treballadors.length; i++) {
			treballadors[i].augment();
		}
		
		for(Treballador treballador : treballadors) {
			System.out.println(treballador.toString());
		}

	}

}

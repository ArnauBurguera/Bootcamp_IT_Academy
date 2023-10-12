package s1t4n1ex1;

import java.util.ArrayList;

public class LlistaMesos {
	
	private ArrayList<String> mesosAny;

	public LlistaMesos() {
		this.mesosAny = new ArrayList<String>();
	}

	public ArrayList<String> getMesosAny() {
		return mesosAny;
	}
	
	public void addMesos() {
		if(this.mesosAny.isEmpty()) {
			this.mesosAny.add("Gener");
			this.mesosAny.add("Febrer");
			this.mesosAny.add("Març");
			this.mesosAny.add("Abril");
			this.mesosAny.add("Maig");
			this.mesosAny.add("Juny");
			this.mesosAny.add("Juliol");
			this.mesosAny.add("Agost");
			this.mesosAny.add("Septembre");
			this.mesosAny.add("Octubre");
			this.mesosAny.add("Novembre");
			this.mesosAny.add("Desembre");
		}
	}
	
	

}

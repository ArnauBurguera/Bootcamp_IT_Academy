package s1t3n1ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LlegirFitxer {

	private String country = "";
	private String capital = "";
	private ArrayList<String> countriesList = new ArrayList<String>();

	public Map<String, String> dataToHashMap() {
		String linea = "";
		FileReader fitxerCapitals = null;
		BufferedReader buffer = null;
		Map<String, String> hashMap = new HashMap<>();

		try {
			fitxerCapitals = new FileReader("countries.txt");
			buffer = new BufferedReader(fitxerCapitals);
			linea = buffer.readLine();

			while(linea.length() > 1) {
				assignation(linea);
				hashMap.put(this.country, this.capital);
				countriesList.add(this.country);
				resetejar();
				linea = buffer.readLine();
			}

		} catch (IOException e) {
			System.out.println("No s'ha trobat l'arxiu.");

		}finally {
			try {
				fitxerCapitals.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return hashMap;
	}
	
	public String[] returnArrayCountries(){	
		 String[] array = new String[this.countriesList.size()];
		 array = this.countriesList.toArray(array);
	  
		return array;
	}

	public void assignation(String linea) {

		for(int i = 0; i < linea.length(); i++) {
			if(linea.charAt(i) != ' ' ) {
				this.country = this.country + linea.charAt(i);
			}else {
				i = linea.length();
			}
		}

		for(int i = (this.country.length() + 1); i < (linea.length()); i++) {
			this.capital = this.capital + linea.charAt(i);
		}
	}


	public void resetejar() {
		this.country = "";
		this.capital = "";
	}

}

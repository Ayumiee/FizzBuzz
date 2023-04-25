package fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		String resultat = "Hello, ";
		ArrayList<String> tabString = new ArrayList<>(Arrays.asList(string.split(",")));
		ArrayList<String> tabStringMaj = new ArrayList<String>();
		ArrayList<String> tabStringMin = new ArrayList<String>();

		// si 2+ personnes :
		if (tabString.size() > 1) {
			// tri des éléments majuscules et minuscules
			for (int i = 0; i < tabString.size(); i++) {
				if (tabString.get(i).toUpperCase() == tabString.get(i)) {
					tabStringMaj.add(tabString.get(i));
				} else {
					tabStringMin.add(tabString.get(i));
				}
			}
			// traitement des potentiels elements minuscules trouvés
			for (int j = 0; j < tabStringMin.size(); j++) {
				resultat = resultat + tabStringMin.get(j).substring(0, 1).toUpperCase()
						+ tabStringMin.get(j).substring(1);
				if (j + 2 < tabStringMin.size()) {
					resultat = resultat + ", ";
				} else if (j + 1 < tabStringMin.size()) {
					resultat = resultat + " and ";
				}
			}

			// traitement des potentiels elements majuscules trouvés
			if (tabStringMaj.size() > 0) {
				if (tabStringMin.size() > 0) {
					resultat = resultat + ". AND HELLO, ";
				} else {
					resultat = "HELLO, ";
				}
				for (int i = 0; i < tabStringMaj.size(); i++) {
					resultat = resultat + tabStringMaj.get(i);
					if (i + 2 < tabStringMaj.size()) {
						resultat = resultat + ", ";
					} else if (i + 1 < tabStringMaj.size()) {
						resultat = resultat + " AND ";
					}
				}
				resultat=resultat+" !";
			}
			return resultat;

			// si 1 personne :
		} else {
			// nom vide
			if (string.isBlank()) {
				return "Hello, my friend";
			}
			// tout en majuscule
			if (string.toUpperCase() == string) {
				return "HELLO, " + string + " !";
			} else {
				// premiere lettre en maj
				return "Hello, " + string.substring(0, 1).toUpperCase() + string.substring(1);
			}
		}
	}

}

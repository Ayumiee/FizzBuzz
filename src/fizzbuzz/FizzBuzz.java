package fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		String stringSansEspace = "";

		// reconstruction pour effacer tous les espaces vides
		for (char c : string.toCharArray()) {
			if (c != ' ') {
				stringSansEspace = stringSansEspace + c;
			}
		}

		StringBuilder resultat = new StringBuilder();
		ArrayList<String> tabString = new ArrayList<>(Arrays.asList(stringSansEspace.split(",")));
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
			if (tabStringMin.size() > 0) {
				resultat.append("Hello, ");
			}
			for (int i = 0; i < tabStringMin.size(); i++) {
				resultat.append(tabStringMin.get(i).substring(0, 1).toUpperCase() + tabStringMin.get(i).substring(1));
				// traitement affichage
				if (i + 2 < tabStringMin.size()) {
					resultat.append(", ");
				} else if (i + 1 < tabStringMin.size()) {
					resultat.append(" and ");
				}
			}

			// traitement des potentiels elements majuscules trouvés
			if (tabStringMaj.size() > 0) {
				if (tabStringMin.size() > 0) {
					resultat.append(". AND HELLO, ");
				} else {
					resultat.append("HELLO, ");
				}
				for (int i = 0; i < tabStringMaj.size(); i++) {
					resultat.append(tabStringMaj.get(i));
					if (i + 2 < tabStringMaj.size()) {
						resultat.append(", ");
					} else if (i + 1 < tabStringMaj.size()) {
						resultat.append(" AND ");
					}
				}
				resultat.append(" !");
			}
			return resultat.toString();

		// si 1 personne :
		} else {
			// nom vide
			if (stringSansEspace.isBlank()) {
				return "Hello, my friend";
			}
			// tout en majuscule
			if (stringSansEspace.toUpperCase() == stringSansEspace) {
				return "HELLO, " + string + " !";
			} else {
				// premiere lettre en maj
				return "Hello, " + stringSansEspace.substring(0, 1).toUpperCase() + stringSansEspace.substring(1);
			}
		}
	}
}

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
		ArrayList<String> tabStringSansDoublons = new ArrayList<String>();
		ArrayList<String> tabStringMaj = new ArrayList<String>();
		ArrayList<String> tabStringMin = new ArrayList<String>();
		ArrayList<Integer> tabOccurence = new ArrayList<Integer>();
		ArrayList<Integer> tabOccurenceMin = new ArrayList<Integer>();
		ArrayList<Integer> tabOccurenceMaj = new ArrayList<Integer>();
		boolean dejaDedans;

		// retirer les doublons
		if (tabString.size() > 0) {
			// initialisation
			tabStringSansDoublons.add(tabString.get(0));
			tabOccurence.add(1);
		}
		for (int i = 1; i < tabString.size(); i++) {
			dejaDedans = false;
			for (int j = 0; j < tabStringSansDoublons.size(); j++) {
				if (tabString.get(i).toUpperCase().equals(tabStringSansDoublons.get(j).toUpperCase())) {
					tabOccurence.set(j, tabOccurence.get(j) + 1);
					dejaDedans = true;
				}
			}
			if (!dejaDedans) {
				tabStringSansDoublons.add(tabString.get(i));
				tabOccurence.add(1);
			}
		}

		tabString.clear();

		// si 2+ personnes :
		if (tabStringSansDoublons.size() > 1) {
			// tri des éléments majuscules et minuscules
			for (int i = 0; i < tabStringSansDoublons.size(); i++) {
				if (tabStringSansDoublons.get(i).toUpperCase() == tabStringSansDoublons.get(i)) {
					tabStringMaj.add(tabStringSansDoublons.get(i));
					tabOccurenceMaj.add(tabOccurence.get(i));
				} else {
					tabStringMin.add(tabStringSansDoublons.get(i));
					tabOccurenceMin.add(tabOccurence.get(i));
				}
			}

			tabOccurence.clear();

			// traitement des potentiels elements minuscules trouvés
			if (tabStringMin.size() > 0) {
				resultat.append("Hello, ");
			}
			for (int i = 0; i < tabStringMin.size(); i++) {
				// mise en forme
				resultat.append(tabStringMin.get(i).substring(0, 1).toUpperCase() + tabStringMin.get(i).substring(1));
				// occurence
				if (tabOccurenceMin.get(i) > 1) {
					resultat.append("(x" + tabOccurenceMin.get(i) + ")");
					if (i + 1 < tabStringMin.size()) {
						resultat.append(",");
					}
				}
				// and ou virgule
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
					// occurence
					if (tabOccurenceMaj.get(i) > 1) {
						resultat.append("(x" + tabOccurenceMaj.get(i) + ")");
					}
					// and ou virgule
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

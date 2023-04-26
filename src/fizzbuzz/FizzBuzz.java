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

		StringBuilder resultatMaj = new StringBuilder();
		StringBuilder resultatMin = new StringBuilder();
		ArrayList<String> tabString = new ArrayList<>(Arrays.asList(stringSansEspace.split(",")));
		ArrayList<String> tabStringSansDoublons = new ArrayList<String>();
		ArrayList<String> tabStringMaj = new ArrayList<String>();
		ArrayList<String> tabStringMin = new ArrayList<String>();
		ArrayList<Integer> tabOccurence = new ArrayList<Integer>();
		ArrayList<Integer> tabOccurenceMin = new ArrayList<Integer>();
		ArrayList<Integer> tabOccurenceMaj = new ArrayList<Integer>();
		boolean dejaDedans;
		boolean yoda = false;

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
					System.out.println("deja dedans\n");
				}
			}
			if (!dejaDedans) {
				tabStringSansDoublons.add(tabString.get(i));
				tabOccurence.add(1);
			}
		}
		for (int e = 0; e < tabOccurence.size(); e++) {
			System.out.println(tabOccurence.get(e));
		}

		tabString.clear();

		// si 2+ personnes :
		if (tabStringSansDoublons.size() > 1) {
			// tri des éléments majuscules et minuscules
			for (int i = 0; i < tabStringSansDoublons.size(); i++) {
				if (tabStringSansDoublons.get(i).toUpperCase().equals(tabStringSansDoublons.get(i))) {
					tabStringMaj.add(tabStringSansDoublons.get(i));
					tabOccurenceMaj.add(tabOccurence.get(i));
				} else {
					tabStringMin.add(tabStringSansDoublons.get(i));
					tabOccurenceMin.add(tabOccurence.get(i));
				}
			}
			for (int e = 0; e < tabOccurenceMin.size(); e++) {
				System.out.println("min:"+tabOccurenceMin.get(e));
			}
			for (int e = 0; e < tabOccurenceMaj.size(); e++) {
				System.out.println("maj:"+tabOccurenceMaj.get(e));
			}

			tabOccurence.clear();

			// traitement des potentiels elements minuscules trouvés

			for (int i = 0; i < tabStringMin.size(); i++) {
				// repérage du yoda
				if (tabStringMin.get(i).toLowerCase().equals("yoda")) {
					yoda = true;
				}
				// mise en forme
				resultatMin.append(tabStringMin.get(i).substring(0, 1).toUpperCase() + tabStringMin.get(i).substring(1));
				// occurence
				if (tabOccurenceMin.get(i) > 1) {
					resultatMin.append("(x" + tabOccurenceMin.get(i) + ")");
					if (i + 1 < tabStringMin.size()) {
						resultatMin.append(",");
					}
				}
				// and ou virgule
				if (i + 2 < tabStringMin.size()) {
					resultatMin.append(", ");
				} else if (i + 1 < tabStringMin.size()) {
					resultatMin.append(" and ");
				}
			}
			// traitement yoda et placement du hello
			if ((tabStringMin.size() > 0) && (yoda)) {
				resultatMin.append(", Hello");
			}
			if ((tabStringMin.size() > 0) && (!yoda)) {
				resultatMin.insert(0, "Hello, ");
			}

			yoda = false;

			// traitement des potentiels elements majuscules trouvés
			if (tabStringMaj.size() > 0) {
				for (int i = 0; i < tabStringMaj.size(); i++) {
					// repérage du yoda
					if (tabStringMaj.get(i).toLowerCase().equals("yoda")) {
						yoda = true;
					}
					resultatMaj.append(tabStringMaj.get(i));
					// occurence
					if (tabOccurenceMaj.get(i) > 1) {
						resultatMaj.append("(x" + tabOccurenceMaj.get(i) + ")");
					}
					// and ou virgule
					if (i + 2 < tabStringMaj.size()) {
						resultatMaj.append(", ");
					} else if (i + 1 < tabStringMaj.size()) {
						resultatMaj.append(" AND ");
					}
				}
				// traitement yoda et placement du hello
				if (tabStringMaj.size() > 0) {
					if ((tabStringMin.size() > 0) && (yoda)) {
						resultatMaj.insert(0, ". AND ");
						resultatMaj.append(" HELLO");
					}
					if ((tabStringMin.size() > 0) && (!yoda)) {
						resultatMaj.insert(0, ". AND HELLO, ");
					}
					if ((tabStringMin.size() == 0) && (yoda)) {
						resultatMaj.append(" HELLO");
					}
					if ((tabStringMin.size() == 0) && (!yoda)) {
						resultatMaj.insert(0, "HELLO, ");
					}
					resultatMaj.append(" !");
				}
			}
			return resultatMin.toString() + resultatMaj.toString();

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

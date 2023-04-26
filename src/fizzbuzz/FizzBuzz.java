package fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;

public class FizzBuzz {

	// ------------------------------------------------------------

	public static Object fizzbuzz(String string) {
		String stringSansEspace = "";
		StringBuilder resultatMaj = new StringBuilder();
		StringBuilder resultatMin = new StringBuilder();
		ArrayList<String> tabStringSansDoublons = new ArrayList<String>();
		ArrayList<String> tabStringMaj = new ArrayList<String>();
		ArrayList<String> tabStringMin = new ArrayList<String>();
		ArrayList<Integer> tabOccurence = new ArrayList<Integer>();
		ArrayList<Integer> tabOccurenceMin = new ArrayList<Integer>();
		ArrayList<Integer> tabOccurenceMaj = new ArrayList<Integer>();
		boolean dejaDedans;
		boolean yoda = false;

		// CAS OU IL N'Y A PAS DE PRENOMS
		if (string.isBlank()) {
			return "Hello, my friend";
		}

		// EFFACEMENT DES ESPACES VIDES
		for (char c : string.toCharArray()) {
			if (c != ' ') {
				stringSansEspace = stringSansEspace + c;
			}
		}

		// SPLIT
		ArrayList<String> tabString = new ArrayList<>(Arrays.asList(stringSansEspace.split(",")));

		// RETRAIT DOUBLONS
		if (tabString.size() > 0) {
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

		// TRI ELEMENT MAJUSCULES ET MINUSCULES AVEC LEUR OCCURENCES
		if (tabStringSansDoublons.size() > 0) {
			for (int i = 0; i < tabStringSansDoublons.size(); i++) {
				if (tabStringSansDoublons.get(i).toUpperCase().equals(tabStringSansDoublons.get(i))) {
					tabStringMaj.add(tabStringSansDoublons.get(i));
					tabOccurenceMaj.add(tabOccurence.get(i));
				} else {
					tabStringMin.add(tabStringSansDoublons.get(i));
					tabOccurenceMin.add(tabOccurence.get(i));
				}
			}
			tabOccurence.clear();

			// TRAITEMENT MINUSCULES -------------------------------------------
			if (tabStringMin.size() > 0) {
				
				for (int i = 0; i < tabStringMin.size(); i++) {
					// repérage du yoda
					if (tabStringMin.get(i).toLowerCase().equals("yoda")) {
						yoda = true;
					}
					// affichage : ajout du prénom traité
					resultatMin.append(
							tabStringMin.get(i).substring(0, 1).toUpperCase() + tabStringMin.get(i).substring(1));
					// affichage : occurence
					if (tabOccurenceMin.get(i) > 1) {
						resultatMin.append("(x" + tabOccurenceMin.get(i) + ")");
						if (i + 1 < tabStringMin.size()) {
							resultatMin.append(",");
						}
					}
					// affichage : and ou virgule
					if (i + 2 < tabStringMin.size()) {
						resultatMin.append(", ");
					} else if (i + 1 < tabStringMin.size()) {
						resultatMin.append(" and ");
					}
				}

				// TRAITEMENT YODA
				if (yoda) {
					resultatMin.append(", Hello");
				} else {
					resultatMin.insert(0, "Hello, ");
				}
				
			}

			// TRAITEMENT MAJUSCULES -----------------------------------------
			yoda = false;
			if (tabStringMaj.size() > 0) {

				for (int i = 0; i < tabStringMaj.size(); i++) {
					// repérage du yoda
					if (tabStringMaj.get(i).toLowerCase().equals("yoda")) {
						yoda = true;
					}
					// affichage : ajout du prénom traité
					resultatMaj.append(tabStringMaj.get(i));
					// affichage : occurence
					if (tabOccurenceMaj.get(i) > 1) {
						resultatMaj.append("(x" + tabOccurenceMaj.get(i) + ")");
					}
					// affichage : and ou virgule
					if (i + 2 < tabStringMaj.size()) {
						resultatMaj.append(", ");
					} else if (i + 1 < tabStringMaj.size()) {
						resultatMaj.append(" AND ");
					}
				}

				// TRAITEMENT YODA
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
	}

	// FIN -------------------------------------------------------------

}

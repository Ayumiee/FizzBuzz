package fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		// 2 personnes et ++
		String resultat = "Hello, ";
		ArrayList<String> tabString = new ArrayList<>(Arrays.asList(string.split(",")));
		if (tabString.size() > 1) {
			for (int i = 0; i < tabString.size(); i++) {
				resultat = resultat + tabString.get(i).substring(0, 1).toUpperCase() + tabString.get(i).substring(1);
				if (i + 1 < tabString.size()) {
					resultat = resultat + ", ";
				}
			}
			return resultat;
		}

		// nom vide
		if (string.isBlank()) {
			return "Hello, my friend";
		}
		// tout en majuscule
		if (string.toUpperCase() == string) {
			return "HELLO, " + string + " !";
		} else {
			// premi�re lettre en maj
			return "Hello, " + string.substring(0, 1).toUpperCase() + string.substring(1);
		}
	}

}

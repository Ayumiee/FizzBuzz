package fizzbuzz;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		String resultat="Hello, ";
		String[] tabString=new String[10];
		tabString=string.split(",");
		
		//10 personnes
		if (tabString.length>1) {
			for (int i=0;i<tabString.length;i++) {
				resultat=resultat+tabString[i].substring(0,1).toUpperCase()+tabString[i].substring(1);
				if (i+1<tabString.length) {
					resultat=resultat+", ";
				}
			}
			return resultat;
		}
		
// 2 personnes et + (à l'infini)
//		String resultat="Hello, ";
//		ArrayList<String> tabString=new ArrayList<String>();
//		tabString=string.split(",");
//		
//		//2 personnes et +
//		if (tabString.size()>1) {
//			for (int i=0;i<tabString.size();i++) {
//				resultat=resultat+tabString[i].substring(0,1).toUpperCase()+tabString[i].substring(1);
//				if (i+1<tabString.size()) {
//					resultat=resultat+", ";
//				}
//			}
//			return resultat;
//		}
		
		//nom vide
		if (string.isBlank()) {
			return "Hello, my friend";
		}
		//tout en majuscule
		if(string.toUpperCase()==string) {
			return "HELLO, "+string+" !";
		} else {
			//première lettre en maj
			return "Hello, "+string.substring(0,1).toUpperCase()+string.substring(1);
		}
	}
		
}
	

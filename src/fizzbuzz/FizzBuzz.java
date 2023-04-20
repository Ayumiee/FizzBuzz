package fizzbuzz;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		String[] tabString=new String[2];
		tabString=string.split(",");
		
		//deux personnes
		if(tabString.length>1) {
			return "Hello, "+tabString[0].substring(0,1).toUpperCase()+tabString[0].substring(1)
					+", "+tabString[1].substring(0,1).toUpperCase()+tabString[1].substring(1);
		}
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

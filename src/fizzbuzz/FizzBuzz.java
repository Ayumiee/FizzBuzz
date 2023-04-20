package fizzbuzz;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		if (string.isBlank()) {
			return "Hello, my friend";
		}
		return "Hello "+string.substring(0,1).toUpperCase()+string.substring(1);
	}
	
	

}

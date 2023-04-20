package fizzbuzz;

public class FizzBuzz {

	public static Object fizzbuzz(String string) {
		if (string.isBlank()) {
			return "Hello, my friend";
		}
		if(string.toUpperCase()==string) {
			return "HELLO, "+string+" !";
		} else {
			return "Hello, "+string.substring(0,1).toUpperCase()+string.substring(1);
		}
		
	}
	
	

}

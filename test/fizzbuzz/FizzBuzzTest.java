package fizzbuzz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

	@Test
	void ex1() {
		assertEquals(FizzBuzz.fizzbuzz("bob"), "Hello, Bob");
	}

	@Test
	void ex2() {
		assertEquals(FizzBuzz.fizzbuzz(""), "Hello, my friend");
		assertEquals(FizzBuzz.fizzbuzz("  "), "Hello, my friend");
	}

	@Test
	void ex3() {
		assertEquals(FizzBuzz.fizzbuzz("JERRY"), "HELLO, JERRY !");
	}

	@Test
	void ex4() {
		assertEquals(FizzBuzz.fizzbuzz("amy,bob"), "Hello, Amy, Bob");
	}

	@Test
	void ex5() {
		assertEquals(FizzBuzz.fizzbuzz("amy,bob,jerry"), "Hello, Amy, Bob, Jerry");
	}
	
	@Test
	void ex6() {
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry"), "Hello, Amy, Jerry. AND HELLO, BOB !");
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry,MARK"), "Hello, Amy, Jerry. AND HELLO, BOB, MARK !");
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry,MARK,MALA"), "Hello, Amy, Jerry. AND HELLO, BOB, MARK, MALA !");
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry,MARK,MALA,Pedro"), "Hello, Amy, Jerry, Pedro. AND HELLO, BOB, MARK, MALA !");
		assertEquals(FizzBuzz.fizzbuzz("BOB,MARK"), "HELLO, BOB, MARK !");
		
	}

}

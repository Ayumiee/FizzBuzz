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

}

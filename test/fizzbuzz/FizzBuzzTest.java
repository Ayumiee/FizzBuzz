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
		assertEquals(FizzBuzz.fizzbuzz("amy,bob,jerry,lola,mathieu,carmen"), "Hello, Amy, Bob, Jerry, Mathieu, Carmen");
	}
	
	@Test
	void ex6() {
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry"), "Hello, Amy, Jerry. AND HELLO, BOB !");
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry,MARK"), "Hello, Amy, Jerry. AND HELLO, BOB, MARK !");
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry,MARK,MALA"), "Hello, Amy, Jerry. AND HELLO, BOB, MARK, MALA !");
		assertEquals(FizzBuzz.fizzbuzz("Amy,BOB,Jerry,MARK,MALA,Pedro"), "Hello, Amy, Jerry, Pedro. AND HELLO, BOB, MARK, MALA !");
		assertEquals(FizzBuzz.fizzbuzz("BOB,MARK"), "HELLO, BOB, MARK !");
		
	}
	
	@Test
	void ex7() {
		// les tests 4, 5, 6 ne peuvent plus marcher car l'affichage est différent
		assertEquals(FizzBuzz.fizzbuzz("bob,amy,jerry"), "Hello, Bob, Amy and Jerry");
		assertEquals(FizzBuzz.fizzbuzz("bob,AMY,jerry,JACK"), "Hello, Bob and Jerry. AND HELLO, AMY AND JACK !");
		assertEquals(FizzBuzz.fizzbuzz("bob,AMY,jerry,JACK,MALA,jason"), "Hello, Bob, Jerry and Jason. AND HELLO, AMY, JACK AND MALA !");
		assertEquals(FizzBuzz.fizzbuzz("AMY,JACK,MALA"), "HELLO, AMY, JACK AND MALA !");
		assertEquals(FizzBuzz.fizzbuzz("victor,AMY,JACK,MALA"), "Hello, Victor. AND HELLO, AMY, JACK AND MALA !");
		assertEquals(FizzBuzz.fizzbuzz("victor,AMY"), "Hello, Victor. AND HELLO, AMY !");
	}
	
	@Test
	void ex8() {
		assertEquals(FizzBuzz.fizzbuzz("bob         , amy    "), "Hello, Bob and Amy");
		assertEquals(FizzBuzz.fizzbuzz("   bob ,  AMY ,    jerry  , JACK   "), "Hello, Bob and Jerry. AND HELLO, AMY AND JACK !");
		assertEquals(FizzBuzz.fizzbuzz("  b  o b,   AM Y,je  rr  y,J A CK  "), "Hello, Bob and Jerry. AND HELLO, AMY AND JACK !");
		assertEquals(FizzBuzz.fizzbuzz("  v  i cto  r,A                             M   Y               "), "Hello, Victor. AND HELLO, AMY !");
		assertEquals(FizzBuzz.fizzbuzz("    vict  or            ,                    A MY              "), "Hello, Victor. AND HELLO, AMY !");
	} 
	
	@Test
	void ex9() {
		assertEquals(FizzBuzz.fizzbuzz("bob, JERRY, amy, bob, JERRY, bob"),"Hello, Bob(x3), and Amy. AND HELLO, JERRY(x2) !");
		assertEquals(FizzBuzz.fizzbuzz("bob, JERRY, amy, bob, JERRY, bob,amy"),"Hello, Bob(x3), and Amy(x2). AND HELLO, JERRY(x2) !");
		assertEquals(FizzBuzz.fizzbuzz("JERRY, JERRY,JERRY, AMY, AMY, JEAN"),"HELLO, JERRY(x3), AMY(x2) AND JEAN !");
		assertEquals(FizzBuzz.fizzbuzz("bob, amy, bob, bob,amy"),"Hello, Bob(x3), and Amy(x2)");
		
		//cas où il y a le même nom en minuscule ET majuscule
		//J'ai fais le choix d'afficher le nom en minuscule s'il apparait en minuscule en premier et inversement
		assertEquals(FizzBuzz.fizzbuzz("BOB, bob, JERRY, amy, bob, JERRY, bob,amy,BOB"),"Hello, Amy(x2). AND HELLO, BOB(x5) AND JERRY(x2) !");
		assertEquals(FizzBuzz.fizzbuzz("bob, BOB, JERRY, amy, bob, JERRY, bob,amy,BOB"),"Hello, Bob(x5), and Amy(x2). AND HELLO, JERRY(x2) !");
	}
	
	@Test
	void ex10() {
		assertEquals(FizzBuzz.fizzbuzz("bob, YODA, amy, JERRY, YODA"),"Hello, Bob and Amy. AND YODA(x2) AND JERRY HELLO !");
		assertEquals(FizzBuzz.fizzbuzz("bob, yoda, amy, JERRY"),"Bob, Yoda and Amy, Hello. AND HELLO, JERRY !");
		assertEquals(FizzBuzz.fizzbuzz("bob, yoda, yoda, amy, JERRY"),"Bob, Yoda(x2), and Amy, Hello. AND HELLO, JERRY !");
		assertEquals(FizzBuzz.fizzbuzz("bob, YODA, amy, JERRY, YODA"),"Hello, Bob and Amy. AND YODA(x2) AND JERRY HELLO !");
		assertEquals(FizzBuzz.fizzbuzz("YODA, amy, JERRY, YODA"),"Hello, Amy. AND YODA(x2) AND JERRY HELLO !");
	}
}

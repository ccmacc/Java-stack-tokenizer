/**
 * Driver class to test all methods from interface PushBackableTokenizer
 * @author Clint McCarthy
 *
 */


public class Driver {

	public static void main(String[] args) {

		/**
		 * Correct test case that tests the pushback(), nextToken(), and the hasMoreTokens() method
		 */
		
		PushbackTokenizer pushbackTokenizer = new PushbackTokenizer("Java is my favorite programming language");

		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
		
		pushbackTokenizer.pushback();
		pushbackTokenizer.pushback();
		
		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
		
		
		pushbackTokenizer.pushback();
		pushbackTokenizer.pushback();
		
		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
		System.out.println(pushbackTokenizer.nextToken());
	
			
	}// End of main method
	
}//End of Driver

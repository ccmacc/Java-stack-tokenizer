/**
 * This program takes in a string, separates the string by spaces, and allows the user to read a token and push it back
 * to where the token was read.
 * Any number of tokens can be pushed back.
 * 
 * Clint McCarthy
 */

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class PushbackTokenizer implements PushbackableTokenizer {
	StringTokenizer str;
	private Stack<String> tokenStack;
	private Stack<String> tokenPushedBackStack;
	private Stack<String> tempStack;

	/**
	 * Splits the sting of data and places elements in the tokenStack. Then elements are moved from the tokenStack to tempStack
	 * to reverse the order
	 * @param data
	 */
	public PushbackTokenizer(String data) {

		tokenStack = new Stack<>();
		tokenPushedBackStack = new Stack<>();
		tempStack = new Stack<>();
		
		str = new StringTokenizer(data);
		
		while (str.hasMoreTokens()) {
			tokenStack.add(str.nextToken());
			
			}
		while (!tokenStack.isEmpty()){
			tempStack.push(tokenStack.pop());
		}
	
	}

	/**
	 * Returns the next token if the stack is not empty. Else, throws EmptyStackException
	 * 
	 * @return the next token
	 */
	
	@Override
	public String nextToken() {
		if (tempStack.isEmpty()){
			throw new EmptyStackException();
		}
		else {
			tokenPushedBackStack.push(tempStack.pop());
			return tokenPushedBackStack.peek();
			
		}
	}

	/**
	 * Returns true if and only if there are more tokens
	 * 
	 * @return true if there is at least one more token; else false
	 */
	
	@Override
	public boolean hasMoreTokens() {
		if (tokenStack.size() >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The last token read and is not pushed back is pushed back, so it can be
	 * read again using nextToken.
	 * IF the stack is empty, throws EmptyStackException
	 */
	
	@Override
	public void pushback() {
		if(tokenPushedBackStack.isEmpty()){
			throw new EmptyStackException();
		} else {
			tempStack.push(tokenPushedBackStack.pop());
		}
	}

}//End of PushBackTokenizer

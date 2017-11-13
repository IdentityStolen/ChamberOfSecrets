/**
 * 
 */
package com.bloom;

import java.util.*;

/**
 * @author SK030960
 * this code is written by me for parenthesis checking & it seems both map & set are blank at the time stringParser
 * function is called, do you know the reason why?
 */
public class ParenChecker {

	/**
	 * @param args
	 */
	private static final Character OPEN_CURLY = '{';
	private static final Character CLOSE_CURLY = '}';
	
	private static final Character OPEN_SQR = '[';
	private static final Character CLOSE_SQR = ']';
	
	private static final Character OPEN_ANGLE = '<';
	private static final Character CLOSE_ANGLE = '>';
	
	public static final Map<Character,Paren> MAP_OF_PARENTHESIS = new HashMap<>();
	public static final Set<Character> MAP_OF_OPENING_PARENTHESIS = new HashSet<>();
	
	public enum Paren{
		CURLY(OPEN_CURLY, CLOSE_CURLY),
		SQR(OPEN_SQR,CLOSE_SQR),
		ANGLE(OPEN_ANGLE,CLOSE_ANGLE);
		
		private final Character openingParen;
		private final Character closingParen;
		
		Paren(Character openingParen,Character closingParen){
			this.openingParen = openingParen;
			this.closingParen = closingParen;
			
			MAP_OF_OPENING_PARENTHESIS.add(openingParen);
			MAP_OF_PARENTHESIS.put(closingParen, this);
		}
		
		public Character getOpeningParen() {
			return this.openingParen;
		}
		
		public Character getClosingParen() {
			return this.closingParen;
		}
	}
	
	public static boolean isValidOpeningParen(Character chr) {
		return MAP_OF_OPENING_PARENTHESIS.contains(chr);
	}
	
	public static boolean stringParser(String str) {
		if (str != null) {
			char[] strArray = str.toCharArray();
			Paren p;
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < strArray.length; i++) {
				if (isValidOpeningParen(strArray[i])) stack.push(strArray[i]);
				else {
					 p = MAP_OF_PARENTHESIS.get(strArray[i]);
					 if ((p != null) && (!stack.isEmpty()) && (p.getOpeningParen() != stack.pop())) return false;
				}
			}
			if(stack.isEmpty()) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParenChecker pc = new ParenChecker();
		System.out.println(stringParser("[ aa [ bbb ]"));
	}

}

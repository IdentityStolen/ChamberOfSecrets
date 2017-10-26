/**
Checks if parenthesis are appropriate
 * 
 */
package com.experiments;

import java.util.Stack;

/**
 * @author SK030960
 *
 */
public class ParenChecker {

	/**
	 * @param args
	 */
	static boolean DoCheckParenthesis(String s) {
		char c1 = 'a';
		Stack stack = new Stack();
		
		char[] stringArray = s.toCharArray();
		for (char c : stringArray) {
			if ((c == '{') || (c == '[') || (c == '(')) stack.push(c);
			else if (c == '}') {
				if (!stack.isEmpty()) {
					c1 = (char) stack.pop();
					if (c1 != '{') return false;
				}
				else return false;
			}
			else if (c == ']') {
				if (!stack.isEmpty()) {
					c1 = (char) stack.pop();
					if (c1 != '[') return false;
				}
				else return false;
			}
			else if (c == ')') {
				if (!stack.isEmpty()) {
					c1 = (char) stack.pop();
					if (c1 != '(') return false;
				}
				else return false;
			}
		}
		if (!stack.isEmpty()) return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DoCheckParenthesis("aa bb {[[]]} cc + dd [[[]]]"));
	}

}

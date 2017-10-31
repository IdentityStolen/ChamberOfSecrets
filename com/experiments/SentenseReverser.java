/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class SentenseReverser {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Str = "i am awesome";
		char[] charArray = Str.toCharArray();
		char temp;
		int start = 0;
		int end = charArray.length - 1;
		while (start < end) {
			temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		start = 0;
		end = 0;
		int next = 0;
		while (end <= charArray.length - 1) {
			while ((end <= charArray.length - 1) && (charArray[end] != ' ')) end++;
			next = end + 1;
			end--;
			while (start < end) {
				temp = charArray[start];
				charArray[start] = charArray[end];
				charArray[end] = temp;
				start++;
				end--;
			}
			start = end = next;
		}
		System.out.println(charArray);
	}

}

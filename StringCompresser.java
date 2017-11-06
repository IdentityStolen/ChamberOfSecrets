/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class StringCompresser {

	/**
	 * @param args
	 */
	
	public static void compress(String str) {
		int count = 1;
		int len = 0;
		
		if (str != null) len = str.length();
		System.out.println(len);
		if(len==0) {
			System.out.println("String is null");
			return;
		}
		
		for(int i = 0;i<len;i++) {
			if((i != len-1) && (str.charAt(i) == str.charAt(i+1))) {
				count++;
			}
			else {
				System.out.print(str.charAt(i));
				System.out.print(count);
				count = 1;
			}
		}
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compress("aaabbbcc");
		compress("");		//this can't be checked by str==null or str=="" condition!
		compress(null);
	}

}

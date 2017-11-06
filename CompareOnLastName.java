/**
 * 
 */
package com.learn;

import java.util.Comparator;

/**
 * @author SK030960
 *
 */
public class CompareOnLastName implements Comparator<SortHelperForComparator>{

	/**
	 * @param args
	 */
	
	@Override
	public int compare(SortHelperForComparator s1,SortHelperForComparator s2) {
		return s1.lastName.compareTo(s2.lastName);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

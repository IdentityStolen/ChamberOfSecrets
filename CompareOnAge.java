/**
 * 
 */
package com.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author SK030960
 *
 */
public class CompareOnAge implements Comparator<SortHelperForComparator> {

	/**
	 * @param args
	 */
	
	@Override
	public int compare(SortHelperForComparator s1, SortHelperForComparator s2) {
		return (s1.age - s2.age);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

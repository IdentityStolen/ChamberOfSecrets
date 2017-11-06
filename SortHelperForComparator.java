/**
 * 
 */
package com.learn;

import java.util.*;

/**
 * @author SK030960
 *
 */
public class SortHelperForComparator {

	/**
	 * @param args
	 */
	Integer ID;
	String lastName;
	Integer age;
	
	public SortHelperForComparator(int id, String lastName, int age) {
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.lastName = lastName;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "SortHelper [ID=" + ID + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortHelperForComparator s1 = new SortHelperForComparator(1, "eee", 18);
		SortHelperForComparator s2 = new SortHelperForComparator(2, "zzz", 13);
		List<SortHelperForComparator> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		CompareOnAge c = new CompareOnAge();
		Collections.sort(list,c);
		System.out.println(list);
		CompareOnLastName coln = new CompareOnLastName();
		Collections.sort(list,coln);
		System.out.println(list);
		System.out.println(Math.PI);
	}

}

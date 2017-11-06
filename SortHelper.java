/**
 * 
 */
package com.learn;

import java.util.*;

/**
 * @author SK030960
 *
 */
public class SortHelper implements Comparable<SortHelper> {

	/**
	 * @param args
	 */
	
	Integer ID;
	String lastName;
	Integer age;
	
	public SortHelper(int id, String lastName, int age) {
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
		SortHelper s1 = new SortHelper(1, "eee", 18);
		SortHelper s2 = new SortHelper(2, "aaa", 13);
		List<SortHelper> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		Collections.sort(list);
		for (SortHelper sortHelper : list) {
			System.out.println(sortHelper);
		}
	}

	@Override
	public int compareTo(SortHelper o) {
		// TODO Auto-generated method stub
		return this.lastName.compareTo(o.lastName);
	}

}

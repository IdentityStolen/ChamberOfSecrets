/**
 * 
 */
package com.experiments;

import java.util.*;

/**
 * @author SK030960
 *
 */
public class Intersector {

	/**
	 * @param args
	 */
	private int[] a;
	private int[] b;
	
	public Intersector(int[] a,int[] b) {
		this.a = a;
		this.b = b;
	}
	
	public List<Integer> FindIntersection() {
		List<Integer> result = new ArrayList<>();
		
		if (a.length > b.length) {
			int [] c = a;
			a = b;
			b = c;
		}
		
		int count = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i : a) {
			map.putIfAbsent(i, 0);
			if (map.get(i)!=0) {
				map.put(i,count);
			}
			else {
				count = map.get(i);
				count++;
				map.put(i, count);
				count = 0;
			}
		}
		
		for (int i : b) {
			if (map.containsKey(i) && (map.get(i) != 0)) {
				count = map.get(i);
				if (count > 0) count--;
				map.put(i, count);
				result.add(i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 5, 3};
		int[] b = {5, 1, 2};
		Intersector i = new Intersector(a, b);
		List<Integer> result = i.FindIntersection();
		
		System.out.print("{ ");
		Iterator<Integer> i1 = result.iterator();
		while (i1.hasNext()) {
			System.out.print(i1.next() + " ");
		}
		System.out.print("}");
		System.out.println(result);
	}

}

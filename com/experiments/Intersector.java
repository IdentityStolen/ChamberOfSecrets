/**
 * 
 */
package com.experiments;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SK030960
 *
 */
public class Intersector {
	
	public List<Integer> findIntersection(Integer[] a,Integer[] b) {
		List<Integer> result = new ArrayList<>();
		
		if (a.length > b.length) {
			Integer [] c = a;
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

	public Collection<Integer> findIntersectionUsingCollections(Integer [] a, Integer[] b){

		if(a==null||b==null){
			return Collections.emptySet();
		}

		List<Integer> input1 = Arrays.asList(a);
		List<Integer> input2 = Arrays.asList(b);

		Map<Integer,AtomicInteger> result = new ConcurrentHashMap<>();

		input1.forEach(e -> result.put(e,new AtomicInteger(1)));
		input2.forEach(e -> result.computeIfPresent(e, (integer, atomicInteger) -> {
			atomicInteger.getAndIncrement();
			return atomicInteger;
		}));

		System.out.println(result);

		List<Integer> resultList = new ArrayList<>();

		result.keySet().stream().filter(key -> result.get(key).get()>1).forEach(resultList::add);
		return resultList;




	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {2, 5, 3};
		Integer[] b = {5, 1, 2};
		Intersector i = new Intersector();
//		List<Integer> result = i.findIntersection(a, b);
//		System.out.print(result);

		System.out.println(i.findIntersectionUsingCollections(a,b));
	}

}

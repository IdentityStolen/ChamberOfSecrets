/**
 * 
 */
package com.godad;

import java.util.*;

/**
 * @author SK030960
 *
 */
public class FrequencySorter {

	/**
	 * @param args
	 */
	public class Node implements Comparable<Node>{

		int data;
		int freq;
		
		public Node(int data, int freq) {
			this.data = data;
			this.freq = freq;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return (this.data + " " + this.freq);
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return (o.freq - this.freq);
		}
		
	}
	
	public static List<Node> putIntoList(Map<Integer,Integer> map){
		List<Node> list = new ArrayList<>();
		FrequencySorter f = new FrequencySorter();
		for (Map.Entry<Integer,Integer> entry : map.entrySet()){
			FrequencySorter.Node node = f.new Node(entry.getKey(),entry.getValue());
			list.add(node);
		}
		Collections.sort(list);
		return list;
	}
	
	public static Map<Integer,Integer> putIntoHashMap(int[] a){
		Map<Integer,Integer> map = new HashMap<>();
		int count;
		for (int i : a) {
			if(map.get(i) == null) {
				map.put(i, 1);
			}
			else {
				count = map.get(i);
				map.put(i, ++count);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,2,3,2,1,1,4,5,5,5,5,5,6,6,6,6};
		System.out.println(putIntoList(putIntoHashMap(a)));
	}

}

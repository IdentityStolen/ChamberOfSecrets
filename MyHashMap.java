/**
 * 
 */
package com.wepay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SK030960
 *
 */
public class MyHashMap<Key, Value> {

	/**
	 * @param args
	 */
	private static final int arraySize = 15;
	
	private List<Node<Key, Value>> nodesArr = new ArrayList<>(getArraySize());		//why can't I create an array of nodes
	
	public static int getArraySize() {
		return arraySize;
	}
	
	public int myHashCode(Key key) {
		String str = (String) key;
		char[] charArr = str.toCharArray();
		int i = charArr[0];
		return (i % getArraySize());
	}
	
	public void myPut(Key key, Value value) {
		int index = this.myHashCode(key);
		Node<Key,Value> node = null;
		if (key != null) node = new Node<>(key, value);
		else return;
		if (nodesArr.get(index) != null) {
			Node<Key, Value> Iterator = nodesArr.get(index);
			if (!Iterator.myEquals(key)) return;
			while(Iterator.getNext() != null) {
				Iterator = Iterator.getNext();
				if (!Iterator.myEquals(key)) return;
			}
			Iterator.putNext(node);
		}
		nodesArr.get(index).putNext(node);
	}
	
	public Value myGet(Key key) {
		int index = this.myHashCode(key);
		if (nodesArr.get(index) != null) {
			Node<Key, Value> Iterator = nodesArr.get(index);
			if (Iterator.myEquals(key)) return Iterator.getValue();
			while(Iterator.getNext() != null) {
				Iterator = Iterator.getNext();
				if (Iterator.myEquals(key)) return Iterator.getValue();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
	}

}

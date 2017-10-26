/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class Node<T> {

	/**
	 * @param args
	 */
	T data;
	Node next;
	
	Node(T data){
		this.data = data;
		next = null;
	}
}

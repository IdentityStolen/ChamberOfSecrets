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
	private final T data;	//In  case Data is not going to change - better mark it as private.
	private Node<T> next;
	
	Node(T data){
		this.data = data;
		next = null;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}


	public T getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {                //ANY Value object you write - should ideally have equals, hashcode, and toString methods.
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Node<?> node = (Node<?>) o;

		return data.equals(node.data) && (next != null ? next.equals(node.next) : node.next == null);

	}

	@Override
	public int hashCode() {
		int result = data.hashCode();
		result = 31 * result + (next != null ? next.hashCode() : 0);
		return result;
	}
}

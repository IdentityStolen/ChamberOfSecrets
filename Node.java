package com.wepay;

public class Node<Key,Value> {
	private Key key;
	private Value value;
	private Node<Key, Value> next;
	
	public Node(Key key, Value value) {
		this.key = key;
		this.value = value;
		next = null;
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public Value getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void putNext(Node<Key, Value> node) {
		this.next = node;
	}
	
	public boolean myEquals(Key K) {
		return ((this.getClass() == K.getClass()) && (this.getKey().equals(K)));		//why Key gives me error here?
	}
}

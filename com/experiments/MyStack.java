/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class MyStack<T> {

	/**
	 * @param args
	 */
	private Node<T> top;
	
	public MyStack() {
		// TODO Auto-generated constructor stub
		top = null;
	}

	public Node<T> getTop() {
		return top;
	}

	public boolean isEmpty() {
		return top == null;	//Simplify....
	}
	
	public void push(Node<T> node) {	//always follow camelCase convention.
		if (isEmpty()) {
			top = node;
		}else {
			node.setNext(top);		//encapsulation violated if node.next.
			top = node;
		}
	}
	
	public Node<T> pop() {
		Node<T> popNode = null;
		if (!isEmpty()) {
			popNode = top;
			top = top.getNext();
			popNode.setNext(null);
		}	else {
			System.out.println("Nothing to pop! Empty Stack!!!");	//From Readability view - better to have else part always.
		}
		return popNode;
	}
	
	public Node<T> peek(){
		if (!isEmpty()) return top;
		else {
			System.out.println("Nothing to peek! Empty Stack!!!");
		}
		return null;
	}
	
	public void printStack() {
		Node<T> iterator = top;
		System.out.print("[");
		if (isEmpty()) {
			System.out.print("]"); return;
		}
		while (iterator.getNext() != null) {
			System.out.print(iterator.getData() + " ");
			iterator = iterator.getNext();
		}
		System.out.print(iterator.getData() + "]" + "\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> myStack = new MyStack<>();
		System.out.println(myStack.pop());
		Node<Integer> node1 = new Node<Integer>(23);
		myStack.push(node1);
		Node<Integer> node2 = new Node<Integer>(26);
		myStack.push(node2);
		Node<Integer> node3 = new Node<Integer>(12);
		Node<Integer> node4 = new Node<Integer>(29);
		myStack.push(node3);
		myStack.push(node4);
		myStack.printStack();
		myStack.pop();
		myStack.printStack();
		myStack.peek();
		myStack.printStack();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.printStack();
	}

}

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
	
	public boolean isEmpty() {
		if (top == null) return true;
		return false;
	}
	
	public void Push(Node<T> node) {
		if (isEmpty()) {
			top = node;
		}else {
			node.next = top;
			top = node;
		}
	}
	
	public Node<T> Pop() {
		Node<T> popNode = null;
		if (!isEmpty()) {
			popNode = top;
			top = top.next;
			popNode.next = null;
		}
		return popNode;
	}
	
	public Node<T> Peek(){
		if (!isEmpty()) return top;
		return null;
	}
	
	public void PrintStack() {
		Node<T> iterator = top;
		System.out.print("[");
		if (isEmpty()) {
			System.out.print("]"); return;
		}
		while (iterator.next != null) {
			System.out.print(iterator.data + " ");
			iterator = iterator.next;
		}
		System.out.print(iterator.data + "]" + "\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> myStack = new MyStack<>();
		System.out.println(myStack.Pop());
		Node<Integer> node1 = new Node<Integer>(23);
		myStack.Push(node1);
		Node<Integer> node2 = new Node<Integer>(26);
		myStack.Push(node2);
		Node<Integer> node3 = new Node<Integer>(12);
		Node<Integer> node4 = new Node<Integer>(29);
		myStack.Push(node3);
		myStack.Push(node4);
		myStack.PrintStack();
		myStack.Pop();
		myStack.PrintStack();
		myStack.Peek();
		myStack.PrintStack();
		myStack.Pop();
		myStack.Pop();
		myStack.Pop();
		myStack.Pop();
		myStack.Pop();
		myStack.PrintStack();
	}

}

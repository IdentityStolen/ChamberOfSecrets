package com.experiments;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Chaitanya on 10/29/2017.
 */
public class MyStackTest {

    private MyStack<Integer> myStack;



    @Before
    public void setUp() throws Exception {
        myStack = new MyStack<>();          //Unit tests should be stateless - so they can be run in any order.
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void push() throws Exception {

        Node<Integer> node0 = new Node<>(1);
        myStack.push(node0);

        myStack.printStack();

        Assert.assertTrue(myStack.getTop()==node0);

        Node<Integer> node1 = new Node<>(1);
        myStack.push(node1);

        myStack.printStack();

        Assert.assertTrue(myStack.getTop()==node1);
        Assert.assertTrue(myStack.getTop().getNext() == node0);


    }

    @Test
    public void pop() throws Exception {
        Assert.assertTrue(myStack.pop()==null);

        Node<Integer> node0 = new Node<>(1);
        myStack.push(node0);

        Assert.assertTrue(myStack.pop()==node0);

    }

    @Test
    public void peek() throws Exception {
        Assert.assertTrue(myStack.peek()==null);
    }

}
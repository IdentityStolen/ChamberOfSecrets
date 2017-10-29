package com.experiments;

import org.junit.Assert;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Chaitanya on 10/29/2017.
 */
public class IntersectorTest {

    Intersector intersector =  new Intersector();

    @org.junit.Test
    public void findIntersectionUsingCollectionsWhenOneOfTheInputNull() throws Exception {
        Integer[] a= null;
        Integer[] b= {1,2,3};
        Collection<Integer> intersection = intersector.findIntersectionUsingCollections(a, b);
        Assert.assertTrue(intersection == null || intersection.size() == 0);
    }

    @org.junit.Test
    public void findIntersectionUsingCollectionsWhenNoneOfTheInputNull() throws Exception {
        Integer[] a= {2,1,4};
        Integer[] b= {1,2,3};
        Collection<Integer> intersection = intersector.findIntersectionUsingCollections(a, b);
        Collection<Integer> expected = new HashSet<>();
        expected.add(2);
        expected.add(1);
        Assert.assertTrue(expected.containsAll(intersection));
    }

}
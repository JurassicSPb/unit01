package com.epam.java.se;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
/**
 * Created by Мария on 01.02.2017.
 */
public class IntSetTest {
    @Test
    public void add() throws Exception {
        final IntSet set = new IntSet();
        assertFalse(set.contains(100));
        set.add(5000);
        set.add(50);
        set.add(80);
        set.add(-500);
        set.add(-1);
        set.add(0);
        set.add(1);
        set.add(5);
        assertTrue(set.contains(0));
        assertTrue(set.contains(5000));
        assertFalse(set.contains(-1));
    }

    @Test
    public void remove() throws Exception {
        final IntSet set = new IntSet();
        set.remove(200);
        assertFalse(set.contains(200));

        set.add(-1);
        set.remove(-1);
        assertFalse(set.contains(-1));

        set.add(0);
        set.add(35345);
        set.add(Integer.MAX_VALUE);
        set.add(Integer.MIN_VALUE);
        set.remove(0);
        set.remove(35345);
        set.remove(Integer.MAX_VALUE);
        set.remove(Integer.MIN_VALUE);
        assertFalse(set.contains(0) && set.contains(35345) && set.contains(Integer.MAX_VALUE)
                && set.contains(Integer.MIN_VALUE));
    }


    @Test
    public void contains() throws Exception {
        final IntSet set = new IntSet();
        for (int i = -10; i < 500; i++) {
            assertFalse(set.contains(i));
        }

        set.add(-1);
        set.add(-100);
        set.add(0);
        assertTrue(set.contains(0));
        assertFalse(set.contains(-1) && set.contains(-100));

        for (int i = 0; i < 600; i++) {
            set.add(i);
            assertTrue(set.contains(i));
        }
    }

    @Test
    public void union() throws Exception {
        final IntSet set = new IntSet();
        final IntSet other = new IntSet();

        set.add(-1111);
        set.add(0);
        set.add(65000);
        set.add(500);
        set.add(15);
        set.add(10);

        set.add(-111111);
        set.add(0);
        other.add(6);
        other.add(2);
        other.add(20);

        final IntSet combined = set.union(other);
        assertFalse(combined.contains(-1111));
        assertTrue(combined.contains(0));
    }

    @Test
    public void intersect() throws Exception {
        final IntSet set = new IntSet();
        final IntSet other = new IntSet();


        set.add(40);
        set.add(20);
        set.add(-1);
        set.add(0);

        other.add(400);
        other.add(35);
        other.add(20);
        other.add(2220);
        other.add(40);

        final IntSet combined = set.intersection(other);
        assertTrue(combined.contains(40));
    }

    @Test
    public void difference() throws Exception {
        final IntSet set = new IntSet();
        final IntSet other = new IntSet();

        set.add(5);
        set.add(-1);

        other.add(4);
        other.add(0);

        IntSet combined = set.difference(other);
        assertTrue(combined.contains(0));

    }

    @Test
    public void isSubsetOf() throws Exception {
        final IntSet set = new IntSet();
        final IntSet other = new IntSet();

        set.add(404);
        set.add(50);

        other.add(404);
        other.add(-1);
        other.add(50);

        assertTrue(other.isSubsetOf(set));
    }

}
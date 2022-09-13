package org.cis120;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Use this file to test your implementation of Pixel.
 * 
 * We will manually grade this file to give you feedback
 * about the completeness of your test cases.
 */

public class MyPixelTest {

    /*
     * Remember, UNIT tests should ideally have one point of failure. Below we
     * give you two examples of unit tests for the Pixel constructor, one that
     * takes in three ints as arguments and one that takes in an array. We use
     * the getRed(), getGreen(), and getBlue() methods to check that the values
     * were set correctly. These two tests do not comprehensively test all of
     * Pixel so you must add your own.
     * 
     * You might want to look into assertEquals, assertTrue, assertFalse, and
     * assertArrayEquals at the following:
     * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
     *
     * Note, if you want to add global variables so that you can reuse Pixels
     * in multiple tests, feel free to do so.
     */

    @Test
    public void testConstructInBounds() {
        Pixel p = new Pixel(40, 50, 60);
        assertEquals(40, p.getRed());
        assertEquals(50, p.getGreen());
        assertEquals(60, p.getBlue());
    }

    @Test
    public void testConstructArrayLongerThan3() {
        int[] arr = { 10, 20, 30, 40 };
        Pixel p = new Pixel(arr);
        assertEquals(10, p.getRed());
        assertEquals(20, p.getGreen());
        assertEquals(30, p.getBlue());
    }

    /* ADD YOUR OWN TESTS BELOW */
    @Test
    public void testPositiveClipping() {
        int[] arr = { 300, 400, 30 };
        Pixel p = new Pixel(arr);
        assertEquals(255, p.getRed());
        assertEquals(255, p.getGreen());
        assertEquals(30, p.getBlue());
    }

    @Test
    public void testNegativeClipping() {
        int[] arr = { -200, 255, -3 };
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getRed());
        assertEquals(255, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testIncompleteEntries() {
        int[] arr = { 20, 30 };
        Pixel p = new Pixel(arr);
        assertEquals(20, p.getRed());
        assertEquals(30, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testNullEntries() {
        int[] arr = {};
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testGetRed() {
        Pixel p = new Pixel(230, 320, 20);
        assertEquals(230, p.getRed());
    }

    @Test
    public void testGetGreen() {
        Pixel p = new Pixel(300, 120, 100);
        assertEquals(120, p.getGreen());
    }

    @Test
    public void testGetBlue() {
        Pixel p = new Pixel(300, 120, 100);
        assertEquals(100, p.getBlue());
    }

    @Test
    public void testGetComponents() {
        int[] arr = { 20, 30, 230 };
        Pixel p = new Pixel(arr);
        assertArrayEquals(arr, p.getComponents());
    }

    @Test
    public void testDistance() {
        int[] arr = { 200, 100, 50 };
        int[] arr2 = { 50, 100, 200 };
        Pixel p = new Pixel(arr);
        Pixel p2 = new Pixel(arr2);
        assertEquals(300, p.distance(p2));
    }

    @Test
    public void testToString() {
        Pixel p = new Pixel(50, 100, 150);
        assertEquals("(50, 100, 150)", p.toString());
    }

    public void testEqualsSameEntries() {
        int[] arr = { 200, 100, 50 };
        int[] arr2 = { 200, 100, 50 };
        Pixel p = new Pixel(arr);
        Pixel p2 = new Pixel(arr2);
        assertArrayEquals(p.getComponents(), p2.getComponents());
    }

    public void testEqualsDifferentEntries() {
        int[] arr = { 200, 100, 50 };
        int[] arr2 = { 50, 100, 200 };
        Pixel p = new Pixel(arr);
        Pixel p2 = new Pixel(arr2);
        assertFalse(p.equals(p2));
    }

}

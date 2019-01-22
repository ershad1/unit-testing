package com.in28minutes.unittesing.unittesting.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{1, 2, 3});
        int expectedResult= 6;
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult= 0;
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{5});
        int expectedResult= 5;
        assertEquals(expectedResult, actualResult);
    }
}
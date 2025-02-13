package com.usac.ayd2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CC2Test {
    @Test
    void firstLevelArrayShouldReturnSimpleArray() {
        CC2 cc2 = new CC2();
        Object[] objects = new Object[] {1, 2, 3};
        Object[] result = cc2.transformArrayObjects(objects);
        assertArrayEquals(objects, result);
    }

    @Test
    void secondLevelArrayShouldReturnSimpleArray() {
        CC2 cc2 = new CC2();
        Object[] objects = new Object[] {1,2, new Object[] {3, "4"}};
        Object[] result = cc2.transformArrayObjects(objects);
        assertArrayEquals(new Object[] {1, 2, 3, "4"}, result);
    }

    @Test
    void secondLevelArrayStringNumberShouldReturnSimpleArray() {
        CC2 cc2 = new CC2();
        Object[] objects = new Object[] {1,2, new Object[] {"3", "4"}};
        Object[] result = cc2.transformArrayObjects(objects);
        assertArrayEquals(new Object[] {1, 2, "3", "4"}, result);
    }

    @Test
    void thirdLevelArrayShouldReturnSimpleArray() {
        CC2 cc2 = new CC2();
        Object[] objects = new Object[] {1,2, new Object[] {3,4,new Object[] {5,6}}};
        Object[] result = cc2.transformArrayObjects(objects);
        assertArrayEquals(new Object[] {1, 2, 3,4,5,6}, result);
    }

    @Test
    void fourthLevelArrayShouldReturnSimpleArray() {
        CC2 cc2 = new CC2();
        Object[] objects = new Object[] {new Object[] {new Object[] {new Object[] {1, 2, 3}}}};
        Object[] result = cc2.transformArrayObjects(objects);
        assertArrayEquals(new Object[] {1, 2, 3}, result);
    }

    @Test 
    void fifthLevelArrayShouldReturnSimpleArray(){
        CC2 cc2 = new CC2();
        Object[] objects = new Object[] {1,2, new Object[] {3,4,new Object[] {5,6, new Object[] {7, 8, new Object[] {9, 10}}}}};
        Object[] result = cc2.transformArrayObjects(objects);
        assertArrayEquals(new Object[] {1, 2, 3,4,5,6,7,8,9,10}, result);
    }
}

package com.usac.ayd2;

import java.util.ArrayList;
import java.util.List;

/**
 * Using TDD write your own function that transform an Array of objects, which
 * could contain objects that are also array of objects, into a single Array.
 * Our function must transform any given array input.
 * 
 * The input is an array and the output should be an array.
 */

/***************
 * COMPLEJIDAD *
 * *************
 * Al utilizar recurrencia dentro de un for, considero que 
 * la complejidad es de O(n*logn) al utilizar recurrencia en el algoritmo
 * 
 */
public class CC2 {
    public Object[] transformArrayObjects(Object[] objects) {
        List<Object> result = new ArrayList<>();
        Object[] subresult = new Object[0];
        for (Object object : objects) {
            if (object instanceof Object[]) {
                subresult = transformArrayObjects((Object[]) object);
            } else {
                result.add(object);
            }
        }

        for (Object element : subresult) {
            result.add(element);
        }
        return result.toArray();
    }
}

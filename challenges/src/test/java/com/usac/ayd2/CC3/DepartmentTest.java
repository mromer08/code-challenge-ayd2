package com.usac.ayd2.CC3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class DepartmentTest {
    @Test
    void SameLastNameShouldSaveOneEntry () {
        Department department = new Department();
        Map<Student, Integer> expectedMarks = new HashMap<>();
        Student student1 = new Student("Manuel", "Rojas");
        Student student2 = new Student("Antonio", "Rojas");
        Integer mark1 = 90;
        Integer mark2 = 61;

        expectedMarks.put(student2, mark2);

        department.addStudentMark(student1, mark1);
        department.addStudentMark(student2, mark2);
        
        assertEquals(department.getMarks(), expectedMarks);
        assertEquals(department.getMarks().get(student1), mark2);
        assertEquals(department.getMarks().size(), 1);
    }
    
    @Test
    void AddNullStudentShouldReturnFalse(){
        Department department = new Department();
        Student student1 = null;
        Integer mark1 = 90;

        boolean result = department.addStudentMark(student1, mark1);

        assertFalse(result);
    }

    @Test
    void AddNegativeMarkShouldReturnFalse(){
        Department department = new Department();
        Student student = new Student("Manuel", "Rojas");
        Integer mark1 = -1;
        boolean result = department.addStudentMark(student, mark1);
        assertFalse(result);
    }
}

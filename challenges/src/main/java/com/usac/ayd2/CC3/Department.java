package com.usac.ayd2.CC3;

import java.util.HashMap;
import java.util.Map;

/**
 * Applying TDD, create a simple Department class that contains a Map <Student, Integer>
 * with student marks.
 * 
 * The Student class has the attributes name and lastname.
 * The department class should have two methods:
 * - One method that allows to print in console each student and the mark.
 * - One method that allows to add a student and its mark into the map
 * If the student to add has the same last name of a student already added to the map
 * then the existing entry sould be replaced with the new entry.
 * >
 */

 /**
  * [COMPLEJIDAD]
  * La complejidad de este algoritmo es O(1) para el caso de agregar un estudiante y su nota
  * a la lista de estudiantes, ya que se hace uso de un HashMap, el cual tiene un tiempo de
  * inserción de O(1) en el peor de los casos. Para el caso de imprimir los estudiantes y sus
  * notas, la complejidad es O(n) ya que se recorre la lista de estudiantes y notas.
  *
  */
public class Department {
    private Map<Student, Integer> marks= new HashMap<>();


    public void printStudents() {
        for (Map.Entry<Student, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }

    public boolean addStudentMark(Student student, int mark){
        if (student == null || mark < 0) {
            return false;
        }
        if (marks.containsKey(student)) {
            marks.replace(student, mark);
        }else{
            marks.put(student, mark);
        }

        return true;
    }

    public Map<Student, Integer> getMarks(){
        return marks;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author pavol
 */

// Creating class Student and new object Student
public class Student {
    private String name;
    private String surname;
    private int numClasses;
    private String studNumber;

    public Student(String name, String surname, int numClasses, String studNumber) {
        this.name = name;
        this.surname = surname;
        this.numClasses = numClasses;
        this.studNumber = studNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public String getStudNumber() {
        return studNumber;
    }
    
    
}

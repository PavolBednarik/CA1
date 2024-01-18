/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author pavol
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    // creating method for reading from file
    public static void fileReading (){
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String firstLine;
            while ((firstLine = br.readLine()) !=null){
            String[] nameSurname = firstLine.split(" ");// splitting first line with String array using single space
            if (nameSurname.length == 2){
                String name = nameSurname[0];
                String surname = nameSurname[1];
                int numClasses = Integer.parseInt(br.readLine());
                String studNumber = br.readLine();
                Student student = new Student (name,surname,numClasses,studNumber); // creating new student object in loop
                System.out.println("name: " + student.getName());
                System.out.println("surname: "+ student.getSurname());
                System.out.println("number of clases: "+ student.getNumClasses());
                System.out.println("student number: "+ student.getStudNumber());
            }else {
                System.out.println("Student information incomplete in file!");
            }    
            }
        } catch (Exception e){
            System.out.println("Wrong format of input!");
        }
    }
    
    public static void main(String[] args) {
       fileReading ();
    }
    
}

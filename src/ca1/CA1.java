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
    // checking name if there is only letter 
    public static boolean checkName (String name){
        return (name.matches("[a-zA-Z]+"));
    }
   
    // checking surname it might contain also numbers
    public static boolean checkSurname (String surname){
        return (surname.matches("[a-zA-Z0-9]+"));
    }
    
    // checking if number of classes are between 1 and 8
    public static boolean checkNumClasses (int numClasses){
        return numClasses >=1 && numClasses <=8;
    }
    //22DIP1123
    //012345678
    //checking first 2 numbers in student number if they are numbers
    public static boolean checkFirst2InStudNumber (String studNumber ){
        String first2 = studNumber.substring(0, 2);
        return (first2.matches("[0-9]+"));
    }
    
    // cheking letters in student numbers 
    public static boolean checkLettersInStudNumber (String studNumber){
        String letters1 = studNumber.substring(2, 4); // 3 letters in student number
        String letters2 = studNumber.substring(2, 5); // 4 letters in student number
        boolean letter = false;
        if (letters1.matches("[a-zA-Z]+")){
        if (letters2.matches("[a-zA-Z]+")){
            letter = true;
        } else {
            letter = false;
        }
        }
            return letter;
    }
    // checking last numbers in student number deppending of how many letters is in student number
    public static boolean checkLastNumberInStudNumber (String studNumber){
        String letters1 = studNumber.substring(2, 4);
        String letters2 = studNumber.substring(2, 5);
        int cut = 0;
        if ( letters1.matches("[a-zA-Z]+")){
            cut = 4;
        }
        if ( letters2.matches("[a-zA-Z]+")){
            cut = 5;
        }
        String numbers = studNumber.substring(cut);
        return (numbers.matches("[0-9]+")); // checking if they are numbers
    }
    
    public static void main(String[] args) {
       fileReading ();
    }
    
}

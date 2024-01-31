/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    // creating method for reading from file
    public static void fileReadingWriting (){
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String firstLine;
            while ((firstLine = br.readLine()) !=null){
            String[] nameSurname = firstLine.split(" ");// splitting first line with String array using single space
            if (nameSurname.length == 2){
                String name = nameSurname[0];
                String surname = nameSurname[1];
                String classes = br.readLine();
                int numClasses = 0;
                try{
                numClasses = Integer.parseInt(classes);
                }catch (Exception e){
                    System.out.println("Number of classes need to be integer.");
                }
                String studNumber = br.readLine();
                Student student = new Student (name,surname,numClasses,studNumber); // creating new student object in loop
                System.out.println("name: " + student.getName());
                System.out.println("surname: "+ student.getSurname());
                System.out.println("number of clases: "+ student.getNumClasses());
                System.out.println("student number: "+ student.getStudNumber());
            //checking if is validation correct 
            if (validateStudentInput(student)) {
            student.workload = workload(student.getNumClasses());
                System.out.println(student.workload);
            // calling fileWritting method
            fileWriting(student, student.workload);
            }
            
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
    // checking if first 2 numbers are greater or equal to year 2020
    public static boolean checkFirst2year(String studNumber ){
        String first2 = studNumber.substring(0, 2);
        return Integer.parseInt(first2)>=20;
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
        return (numbers.matches("[0-9]+")) &&
               Integer.parseInt(numbers) >=1 &&
               Integer.parseInt(numbers) <= 200;
        // Checking if last numbers are numbers between 1 and 200
    }
    
    // validating student number and writing usefull messages
    public static boolean validateStudentInput (Student student){
        if (!checkName (student.getName())){
            System.out.println("Incorect name format! Name can contain letters only.");
            return false;
        }
        if (!checkSurname (student.getSurname())){
            System.out.println("Incorect surname format! Surname can cotain letters and numbers.");
            return false;
        }
        if (!checkNumClasses (student.getNumClasses())){
            System.out.println("Incorect number of classes! Number of classes need to be between 1 and 8.");
            return false;
        }
        if (!checkFirst2InStudNumber (student.getStudNumber())){
            System.out.println("Incorect student number format! First 2 characters in student number need to be numbers only.");
            return false;
        }
        if (!checkFirst2year (student.getStudNumber())){
            System.out.println("Incorect student number format! Year in student number need to be greater or equal then 2020.");
            return false;
        }
        if (!checkLettersInStudNumber (student.getStudNumber())){
            System.out.println("Incorect student number format! Next characters after 2 numbers could have lenght 3 or 4 and neet to contain letters only.");
            return false;
        }
        if (!checkLastNumberInStudNumber (student.getStudNumber())){
            System.out.println("Incorect student number format! Last characters in student number need to be numbers between 1 and 200.");
            return false;
        }
        return true;
    }
    // create workload method for calculation workload
    public static String workload(int numClasses) {
        if (numClasses == 1) {
            return "Very Light";
        } else if (numClasses == 2) {
            return "Light";
        } else if (numClasses >= 3 && numClasses <= 5) {
            return "Part Time";
        } else {
            return "Full Time";
        }
    }     
    // creating seperate fileWriting method
    public static void fileWriting (Student student, String workload){
    try{
        BufferedWriter bw = new BufferedWriter (new FileWriter ("status.txt", true));
        bw.write(student.getStudNumber() + "-" + student.getSurname());
        bw.newLine();
        bw.write(student.workload);
        bw.newLine();
        bw.close();
    }catch (Exception e){
        System.out.println(e);
       }
    }
    
    public static void main(String[] args) {
       menu();
    }
    // creating menu 
    public static void menu(){
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter operation:");
            System.out.println("1. Standard operation");
            System.out.println("2. Add another student");
        int choice = sc.nextInt();
        sc.nextLine();
        try {
            if (choice == 1){
                fileReadingWriting ();  
            }else if (choice == 2){
                System.out.println("Enter student name:");
                String name = sc.nextLine();
                System.out.println("Enter student surname:");
                String surname = sc.nextLine();
                System.out.println("Enter number of classes:");
                String classes = sc.nextLine();
                int numClasses = 0;
                try{
                    numClasses = Integer.parseInt(classes);
                }catch (Exception e){
                    System.out.println("Number of classes need to be integer");
                }
                System.out.println("Student student number:");
                String studNumber = sc.nextLine();
                Student student1 = new Student (name,surname,numClasses,studNumber);
                    if (validateStudentInput(student1)) {
                        student1.workload = workload(student1.getNumClasses());
                        System.out.println(student1.workload);
                        fileWriting(student1, student1.workload);
                    } else {
                        System.out.println("Invalid studen input, data will not be safed in file");
                    }
            }else{
                System.out.println("Enter your operation 1 or 2");
            }
        sc.close();
        }catch (Exception e){
        System.out.println(e);
        }
    
    }
}

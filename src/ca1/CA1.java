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
    
    public static void fileReading (){
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String firstLine;
            while ((firstLine = br.readLine()) !=null){
            String[] nameSurname = firstLine.split(" ");
            if (nameSurname.length == 2){
                String name = nameSurname[0];
                String surname = nameSurname[1];
                int numClasses = Integer.parseInt(br.readLine());
                String studNumber = br.readLine();
                Student student = new Student (name,surname,numClasses,studNumber);
            }else {
            }    
            }
        } catch (Exception e){
            System.out.println("invalid data");
        }
    }
    
    public static void main(String[] args) {
       fileReading ();
    }
    
}

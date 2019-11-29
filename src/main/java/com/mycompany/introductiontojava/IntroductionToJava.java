/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.introductiontojava;

import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays; // To sort banknotes from largest to smallest
/**
 *
 * @author Daniel
 */
public class IntroductionToJava {
    public static void main(String[] args){

        System.out.println("Starting variables test:\n");

        int myIntVariable = 2;
        Integer myIntObject = 2;//Object version of the int - takes more memory and has more methods
        Integer myIntObject2 = 6;//Object version of the int - takes more memory and has more methods

        long myLongVariable = 225252;
        Short myShortVariable = 2252;
        float myFloatVariable = 2.0f;// f specifies the float formatting
        Double myDoubleVariable = 2.2;
        char myCharVariable = 'c';// Notice the single quotes for the char, not double quotes
        String myStringVariable ="Hello I'm a string";
        boolean myBooleanObject = true;
        
        System.out.println("Starting if testing:\n");
        
        if(myIntVariable < myLongVariable){System.out.println("Less than\n");}
        else if(myIntVariable > myLongVariable){System.out.println("Greater than\n");}
        else if(myIntVariable <= myLongVariable){System.out.println("Less than or equal to\n");}
        else if(myIntVariable >= myLongVariable){System.out.println("Greater than or equal to\n");}
        else if(myIntVariable != myLongVariable){System.out.println("Is not the same object\n");}
        else if(myIntVariable == myLongVariable){System.out.println("Is the same object\n");}
        // Following only work when comparing objects of the same type AND THEY MUST BE OBJECTS not basic datatypes like int, must be Intergers
        else if(!myIntObject.equals(myIntObject2)){System.out.println("Does not equal i.e. doesn't have the same value as\n");}
        else if(myIntObject.equals(myIntObject2)){System.out.println("Equals i.e. has the same value as\n");}

        System.out.println("Starting switch testing:\n");
        int forMySwitch = 2;
        switch(forMySwitch){
            case (1+1):
                System.out.println("It's It's 1+1\n");
                break;  
            case 3:
                System.out.println("It's 3\n");
                break;           
            case 4:
                System.out.println("It's 4\n");
                break;            
        }
        // Without the breaks, each of the following switch cases are evaluated
        switch(forMySwitch){
            case 2:
                System.out.println("It's 2\n");
            case 3:
                System.out.println("It's 3\n");       
            case 4:
                System.out.println("It's 4\n");          
        }
        
        //ARRAYS
        System.out.println("\n\n");
        System.out.println("Starting loops and arrays testing:\n");
        int[] myIntArray= new int[5];// 5 item array created ALL ELEMENTS SET TO 0
        int[] myIntArray2 = {1,2,3,4,5};
        
        System.out.println("\n\n");
        System.out.println("For:\n");
        for (int i=0; i<5;i++){
            System.out.println(myIntArray[i]);
        }
        
        // WHILE LOOP MAY NEVER BE ENTERED DEPENDING ON THE CONDITION
        System.out.println("\n\n");
        System.out.println("While:\n");
        int i=0;
        while (i<myIntArray2.length){
            System.out.println(myIntArray2[i]);
            i++;
        }
        
        // DO WHILE WILL ALWAYS BE PERFORMED AT LEAST ONCE
        System.out.println("\n\n");
        System.out.println("Do While:\n");
        
        i = myIntArray2.length;
        do{
           System.out.println(myIntArray2[i-1]);
           i++;
        }while(i<myIntArray2.length);
        
        
        //OPERATORS
        int a=9;
        int b=3;
        int c = a+b;
        c=a-b;
        c=a*b;
        c=a/b;
        c = a%b;
        c=a;
        c+=b; // c=c+b;
        c-=b;//c =c-b
        c*=b;//c=c*b;
        c/=b;//c=c/b;
        c%=b;//c=c%b;
        c++;//c+=1; or c=c+1;
        c--;// c-=1; or c=c-1;

        //Exercises
        System.out.println("\n\n");
        System.out.println("Starting Exercises:\n");
        
        float x = 10.0f;
        float y = 5.0f;
        System.out.println(add(x,y));
        System.out.println(divide(x,y));
        System.out.println(multiply(x,y));
        System.out.println(subtract(x,y));
        
        System.out.println("\n\n");
        System.out.println("Starting Exercises:\n");
        atm();
    }
    public static float add(float a, float b){
        
        float result = a + b;
        return result;
    }
    public static float divide(float a, float b){
        
        float result = a / b;
        return result;
    }
    public static float subtract(float a, float b){
        
        float result = a - b;
        return result;
    }
    public static float multiply(float a, float b){
        
        float result = a * b;
        return result;
    }
    
    public static void print_bank_notes(int withdrawal_amount){
        
// Bank note sizes must be larges to smallest for the algorithm to work
        Integer[] bankNoteSizes = {50, 20, 10, 5, 1};
        //Arrays.sort(bankNoteSizes, Collections.reverseOrder());
        Arrays.sort(bankNoteSizes);
        
        int remaining_amount = withdrawal_amount;


        int num_bank_notes_highest_index = bankNoteSizes.length -1;
            
        // We iterate over the the bank ntes, highest value to smallest
        for (int i=num_bank_notes_highest_index; i>=0; i--){
            int current_banknote_value=bankNoteSizes[i];
            while(remaining_amount>=current_banknote_value){
                remaining_amount = remaining_amount-current_banknote_value;
                System.out.println("1 * "+current_banknote_value+" note\n");
            }
        }
    }
    

    public static void atm(){

        // Greet the customer
        System.out.println("Welcome to your local ATM machine. Please specify your withdrawal amount:\n");
        
        // Create a Acanner object to get user input from the command line.
        Scanner scan=new Scanner(System.in);
        
        
        Integer withdrawal_amount = 0;
        
        // Get the user input for the withdrawal amount
        do{
            System.out.println("> Please avoid entering a negative withdrawal amount.\n");
            withdrawal_amount = scan.nextInt();
        } while (withdrawal_amount<=0);
        
        System.out.println("\n\n\nOK. €" + withdrawal_amount + " being counted.\n\n");
        
        // Call static method to print the required bank notes.
        print_bank_notes(withdrawal_amount);
        
        // Thank the customer
        System.out.println("Please take your cash and card.\n");
        System.out.println("Thank you. Have a nice day!\n");
    }

}

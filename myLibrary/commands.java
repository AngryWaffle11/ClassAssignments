package myLibrary;
import java.util.Random;
import java.util.Scanner;

public class commands{
    // Initialize the scanner
    public static Scanner sc = new Scanner(System.in);
    // Random generator
    public static Random rd = new Random();

    // Ask for an integer value and handle wrong answers
    public static int askInt(){
        int input = 0; // declare variable
        try{
            input = sc.nextInt();
        } catch (Exception e) {
            // handle non int data
            System.out.print("NOOO STOP YOU CAN\'T DO THAT!!!!");
        }
        return input;
    }

    // Scrub terminal for new lines of text
    public static void clearTerminal(){
        try { // windows command for moving the cursor to the start of the terminal and clearing the rest of the text
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final Exception e){
            e.printStackTrace();
        }
    }

    // shorter print command for speed
    public static void p(String input){
        System.out.println(input);
    }
}
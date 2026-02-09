package old;
import java.util.Scanner;

public class OhmsLaw {
    // Initialize the scanner
    static Scanner sc = new Scanner(System.in);

    // Ask for an integer value and handle wrong answers
    static int askInt(){
        int input = 0; // declare variable
        try{
            input = sc.nextInt();
        } catch (Exception e) {
            // handle non int data
            System.out.print("NOOO STOP YOU CAN\'T DO THAT!!!!");
        }
        return input;
    }

    public static void main(String[] args){
        // Ask for values
        System.out.println("What is the voltage of the device?");
        int voltage = askInt();
        System.out.println("Great! What is the resistance of the device in ohms?");
        int resistance = askInt();

        // Calculate for current in the device
        float current = voltage/resistance;
        System.out.println("The current in the device is " + current + " amps!");

        // Close the scanner for best practice
        sc.close();
    }
}

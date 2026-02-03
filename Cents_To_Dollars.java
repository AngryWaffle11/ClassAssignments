import java.util.Scanner;

public class Cents_To_Dollars {
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
        System.out.println("Welcome to Cents and Dollars!");
        System.out.println("How many cents do you have?");
        int cents = askInt();

        // Check if cents can be converted to dollars and convert
        int dollars = 0;
        while (true){
            if (cents >= 100){
                dollars += 1;
                cents -= 100;
            } else {
                // Break loop when cents cannot be simplified further
                break;
            }
        }

        System.out.println("Looks like you have " + dollars + " dollars and " + cents + " cents!");
        System.out.println("Thank you for using Cents and Dollars!");

        // Close out scanner for best practice
        sc.close();
    }
}

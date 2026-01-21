import java.util.Scanner;
import java.lang.Math;

public class CircumferenceOfACircle {
    static Scanner sc = new Scanner(System.in);
    static final double PI = 3.141592;

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

    public static void main(String[] args) {
        // Ask for the radius of the circle
        System.out.println("What is the radius of your circle?");
        int radius = askInt();
        
        // Calculate for area
        double area = PI * Math.pow(radius, 2);
        // Calculate for curcumference
        double circumference = PI * radius * 2;

        // Print result
        System.out.println("Area:          " + area);
        System.out.println("Circumference: " + circumference);
    }
}
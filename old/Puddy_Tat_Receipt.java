package old;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Puddy_Tat_Receipt {
    // Initialize the scanner
    static Scanner sc = new Scanner(System.in);
    public static Random rd = new Random();

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

    // shorter print command for speed
    static void p(String input){
        System.out.println(input);
    }

    public static void main(String[] args){
        p("Welcome to Chez Vous!");
        p("We are the gourmet buffet ^u^ !!");
        p("");
        p("Lunch -------- $5.99");
        p("Dinner ------- &9.99");

        p("How many lunch meals would you like :)?");
        int lunches = askInt();

        p("How many dinner meals would you like :]?");
        int dinners = askInt();

        // Calculate subtotal
        double subtotal = (lunches * 5.99) + (dinners * 9.99);
        // Round subtotal to cents
        subtotal = Math.round(subtotal * 100);
        subtotal = subtotal/100;

        // Set tax rate
        double tax = 1.065;

        // Calculate total and round to cents
        double total = subtotal * tax;        

        // determine if user deserves a discount
        if(lunches + dinners >= 15){
            p("Ordering for a party tonight? I'll give you a 20% discount and enter you in our super raffe!!!");
            total = total * 0.8;

            // 1/4 chance to win a free meal
            p("Beep Boop Bop! Entering you in the raffle...");
            if (1 == rd.nextInt(4)){
                p("Congratulations! You won the raffle and get a free meal with your order!!");
            } else {
                p("Sorry you didn\'t win the raffle, but you still get a 20% discount!!");
            }
        } else if (lunches + dinners >= 10){
            p("Wow you\'re a big spender! You get a 10% discount!");
            total = total * 0.9;
        }

        total = Math.round(total * 100);
        total = total/100;

        // Tell client the total
        p(total + " is your total!");

        // Self checkout
        p("Time to pay!!");
        double recieved = askInt();

        double realTax = (subtotal * tax - subtotal) * 100;
        realTax = Math.round(realTax);
        realTax = realTax/100;

        // Calculate the change
        double change = recieved - total;
        double realChange = change * 100;
        realChange = Math.round(realChange);
        realChange = realChange/100;

        // Logic to find the amount of change needed
        int dollars=0, quarters=0, dimes=0, nickels=0, pennies=0;
        while (true){
            if (change >= 1){
                change -= 1;
                dollars += 1;
            } else if (change >= 0.25){
                change -= 0.25;
                quarters += 1;
            } else if (change >= 0.10){
                change -= 0.10;
                dimes += 1;
            } else if (change >= 0.05){
                change -= 0.05;
                nickels += 1;
            } else if (change >= 0.01){
                change -= 0.01;
                pennies += 1;
            } else {
                break;
            }
        }

        p("Give customer");
        p(dollars + " dollars");
        p(quarters + " quarters");
        p(dimes + " dimes");
        p(nickels + " nickels");
        p(pennies + " pennies");

        p("Printing receipt...");
        p("Beep Boop Bop!");

        p("_______________________");
        p(" Thank you for dining ");
        p("  at Chez Vous!       ");
        p("                     ");
        p(" Lunches:   " + lunches + "         ");
        p(" Dinners:   " + dinners + "         ");
        p("                      ");
        p(" Subtotal:  $" + subtotal + "    ");
        p(" Tax:       $" + realTax + "     ");
        p(" Total:     $" + total + "    ");
        p(" Change:    $" + realChange + "     ");
        p("                      ");
        p("  Thank you and come  ");
        p("  again!              ");
        p(" _____________________");
    }
}

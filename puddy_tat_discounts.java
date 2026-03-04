import myLibrary.c;

public class puddy_tat_discounts {
    static int totalPastries, totalCakes, totalTurnovers, totalTails;
    static double discount;
    static double total;
    public static void main (String[] args){
        // Print menu and greeting
        c.p("1 - Purrfect Puff Pastry ----- $0.75");
        c.p("2 - Chorley Cat Cake --------- $0.25");
        c.p("3 - Tweety's Tasty Turnover -- $0.50");
        c.p("4 - Cedric's Tiger Tail ------ $1.00");
        c.p("");
        c.p("Hello! Welcome to Puddy Tat Pastries!");
        c.p("May I take your order?");
        c.p("0 - finished");

        int input;

        // Aquire response
        while (true){
            input = c.askInt();
            c.clearTerminal();
            c.p("Great! How many ");

            // If purrfect puff pastry is selected
            if (input == 1){
                System.out.print("purrfect puff pastries?");
                while (true){
                    if (input >= 0){
                        totalPastries += input;
                        break;
                    }
                }
            }
            // If choreley cat cake is selected
            else if (input == 2){
                System.out.print("choreley cat cakes?");
                while (true){
                    if (input >= 0){
                        totalCakes += input;
                        break;
                    }
                }
            }
            // If tweety's tasty turnover is selected
            else if (input == 3){
                System.out.print("tasty turnovers?");
                while (true){
                    if (input >= 0){
                        totalTurnovers += input;
                        break;
                    }
                }
            }
            // If cedric's tiger tail is selected
            else if (input == 4){
                System.out.print("tiger tails?");
                while (true){
                    if (input >= 0){
                        totalTails += input;
                        break;
                    }
                }
            }
            // If finished is selected
            else if (input == 0){
                break; // end infinite loop
            }
        }

        // Calculate discounts
        if (totalCakes > 25 ||
            totalPastries > 25 ||
            totalTails > 25 ||
            totalTurnovers > 25
        ){
            c.p("It looks like you are eligable to have a 10 percent discount!");
            discount += 10;
            if (totalCakes > 50 ||
                totalPastries > 50 ||
                totalTails > 50 ||
                totalTurnovers > 50
            ){
                c.p("It looks like you also eligable to receive another 5 percent discount");
                discount += 5;
            }
        }

        c.p("How old are you?");
        input = c.askInt();
        if (input >= 55){
            c.p("Wow! You are ancient!!");
            c.p("You can get a 10 percent discount!");
            discount += 10;
            totalTurnovers += 1;
        }
        
        c.p("How many people in your party are under 5?");
        input = c.askInt();
        totalTails += input;

        c.p("Would you like to take a moment to talk about the awful work conditions at ACME?");
        c.p("1 - YES  2 - NO");
        input = c.askInt();
        if (input == 1){
            c.p("I only get paid 1 cent an hour...");
            c.p("I don't know how they keep getting away with this but it's ok");
            c.p("because I found a home that doesn't charge rent and I get free pastries all the time.");
            c.p("I actually got a new garden the other day. You should take a look at it when you leave.");
            c.p("You take 2 rights and it is the first box on your left.");
            totalPastries += 1;
        }

        // Calculate total
        // Pastries
        total += totalPastries * 0.75;
        // Cat cakes
        while (true){
            if (totalCakes >=9){
                totalCakes -=9;
                total += 2;
            } else {
                total += totalCakes * 0.25;
                break;
            }
        }
        // Turnovers
        while (true){
            if (totalTurnovers >= 12){
                totalTurnovers -= 12;
                total += 4;
            } else {
                total += totalTurnovers * 0.5;
                break;
            }
        }
        // Tiger tails
        total += totalTails;

        // calculate discount
        discount = (100 - discount)/100;

        total *= discount; // exponential reduction

        // Calculate grand total
        double tax = 1.065;
        total *= tax;

        c.p("Your total is " + total);
    }
}

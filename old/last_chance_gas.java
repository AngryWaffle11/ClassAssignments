import myLibrary.c;

public class last_chance_gas {
    public static void main(String args[]){
        c.clearTerminal();
        c.p("Oh no! It seems like you have passed the only gas station for 200 miles! ^^");
        c.p("Let's take a look at your gas tank to see if your car will break down");
        c.p("leaving you to survive the harsh conditions of the desert");

        int tankCapacity, scale, mpg;
        // Ask for tank capacity
        while(true){
            c.newDialogue();
            c.p("How many gallons does your tank hold?");
            tankCapacity = c.askInt();
            if(tankCapacity > 0){
                break;
            } else{}
        }

        // Ask for indication of the gas meter
        while(true){
            c.newDialogue();
            c.p("On a scale of 1 to 10, how high is your gas meter?");
            scale = c.askInt();
            // Confirm a number between 1 and 10 is entered
            if(scale < 1 || scale > 10){c.p("That's not a number between one and 10!");}
            else{break;}
        }

        // Ask for the miles per gallon of the car
        while(true){
            c.newDialogue();
            c.p("Hmm... What is the gas milage of your car in mpg");
            mpg = c.askInt();
            // Confirm mpg is realistic
            if(mpg > 0){
                break;
            } else{}
        }

        // Calculate if user will starve in the desert or not
        double totalGas = tankCapacity * (scale/10); // scale the gas
        c.p("Hmm.. Total gas is about " + totalGas + " gallons...");
        c.newDialogue();

        double maxRange = mpg*totalGas;
        c.p("Okay... your max range is.. " + maxRange + " miles.");
        c.newDialogue();

        c.p("Mhm.. and you would need to go 200 miles, so 200 minus...");

        if(maxRange<200){
            c.p("Nope. You are definitely not making it");
            c.p("Your car should break down soon and you will be on your own from here");
            c.p("Good luck out there :/)");
        } else {
            c.p("Ah, yes. It appears you will not be starving in the desert tonight. :(");
        }

    }
}

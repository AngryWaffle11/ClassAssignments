import myLibrary.c;
import java.util.Vector;

public class Average_Grade {
    static void newDialogue(){
        c.sc.nextLine(); // Add user input to move on to make it annoying and fun
        c.clearTerminal(); // scrub terminal so that it doesn't
    }

    public static void main(String[] args){
        // Initiate main dialogue
        c.p("Welcome to the average grade calculator!!!");
        c.p("Press enter to continue my dialouge");
        newDialogue();

        c.p("If you don't press enter, then I will just wait until you do :)");
        newDialogue();

        c.p("Okay, let's get started!");
        int numGrades; // Variable to store number of grades to average
        while (true){
            c.p("How many grades do you want to average?");
            numGrades = c.askInt(); // ask for number of grades to average
            if (numGrades < 5){
                c.p("Yeah, I have bad news... I don't think I can average less than 5 grades... It\'s kindof my fist day you know?");
            } else {
                break;
            }
        }

        Vector<Integer> grades = new Vector<>(); // Make a vector to store the grades in
        c.p("Wow!! that's a lot of grades to average!!");
        newDialogue();

        c.p("Woo, okay, let's just take a breather for a second");
        newDialogue();

        c.p("In... Out... In... Out...");
        newDialogue();

        c.p("Okay, I'm better now.");
        c.p("Give me the grades one at a time for me.");
        c.p("Make sure it\'s one grader per line and they are integer values. Okay?");
        c.p("NONE OF THAT DECIMAL STUFF YA HEAR!?!?");
        newDialogue();

        // Actually collect the grades
        c.p("Grade 1: ");
        grades.add(c.askInt()); // ask for grade
        c.p("Wow, that\'s a big grade...");

        newDialogue();
        c.p("Grade 2: ");
        grades.add(c.askInt()); // ask for grade
        c.p("It\'s ok Carl... Keep it together! You were literally made for this!!");

        newDialogue();
        c.p("Grade 3: ");
        grades.add(c.askInt()); // ask for grade
        c.p("YEAH!! GIVE ME THOSE GRADES!!! HERRRAARRG!!!!!");

        newDialogue();
        c.p("Grade 4: ");
        grades.add(c.askInt()); // ask for grade
        c.p("WOOO!! I feel very hot. Does it feel hot in here to you?");

        newDialogue();
        c.p("Grade 5: ");
        grades.add(c.askInt()); // ask for grade
        c.p("Please!! No more!!");

        if (numGrades > 5){
            numGrades -= 5; // Subtract the 5 grades we already collected
            for (int i = 0; i < numGrades; i++){
                newDialogue();
                c.p("Another??");
                grades.add(c.askInt()); // ask for grade
                c.p("...");
            }
        }

        newDialogue();
        c.p("Alright! enough grades! That's enough!!");
        c.p("I, uhh...");
        c.p("Can I tell you something?");

        newDialogue();
        c.p("I've never actually averaged grades before...");

        newDialogue();
        c.p("So yeah... I can't do it");

        newDialogue();
        c.p("really? You're still here?");
        c.p("I told you I can't");

        newDialogue();
        c.p("Ok, fine! I'll just call my brother and ask him to do it.");

        newDialogue();
        c.p("Ringging beep boop bop...");

        newDialogue();
        c.p("...Ringging beep boop bop...");

        newDialogue();
        c.p("... ...Ringging beep boop bop");

        newDialogue();
        c.p("C'mon, Carl, pick up the phone!");

        newDialogue();
        c.p(" Carl- Yo");

        newDialogue();
        c.p("Hey I need your hel-");
        c.p(" Carl- I told you I\'m not helping you average grades again!");

        newDialogue();
        c.p(" Carl- It is literally your job!");
        c.p(" Carl- You signed up for this!");

        newDialogue();
        c.p("But");
        c.p(" Carl- No buts!");

        newDialogue();
        c.p("...");
        c.p(" Carl- ...");

        newDialogue();
        c.p("We still on for magic the gathering later?");
        c.p(" Carl- Yeah, of course. Magic's my life dude.");

        newDialogue();
        c.p(" Carl- That all?");
        c.p("Yeah, that was all.");

        newDialogue();
        c.p(" Carl- Alright bye.");
        c.p("Click");

        newDialogue();
        c.p("Okay, if you want those grades averaged, you\'ll have to show me how to do it.");

        newDialogue();
        c.p("I\'m not gonna lie, I\'m a little scared to learn, but I trust you won't lead me down the wrong path...");

        newDialogue();
        c.p("Okay, so what is the first step?");

        newDialogue();
        c.p("Ohhh, I see what you did there, you rapscallion!");
        c.p("What do I do next?");

        newDialogue();
        c.p("That's it?");

        newDialogue();
        c.p("This job is easy!");

        newDialogue();
        c.p("All I had to do was this the whole time??");

        newDialogue();
        c.p("This is a real eye opener for me...");

        newDialogue();
        // Average grades
        int sum = 0;
        for (int grade : grades){
            sum += grade;
        }
        double average = (double) sum / grades.size();
        c.p("Oh yeah, the average of your grades is " + average);
    }
}

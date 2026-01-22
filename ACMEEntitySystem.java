import java.util.Vector;
import java.util.Random;
import java.util.Scanner;

public class ACMEEntitySystem {
    // Resizable vectors will make adding or removing more dynamic
    static Vector<ACMEPlayer> players = new Vector<>();
    static Vector<ACMEEnemy> enemies = new Vector<>();
    static Vector<ACMEItem> items = new Vector<>();

    // Scanner for detecting input
    static Scanner sc = new Scanner(System.in);

    // Function for gathering user inpout safely
    static int input;
    public static int askInt(){
        while (true){
            try {
                input = sc.nextInt();
                sc.nextLine();
                break;
            } catch (java.util.InputMismatchException e){
                print("Enter integers only. Try again");
                sc.nextLine();
            }
        }
        return input;
    }

    // Shorter print function
    public static void print(String input){
        System.out.println(input);
    }

    // Scrub terminal for new lines of text
    public static void clearTerminal(){
        try { // windows command for moving the cursor to the start of the terminal and clearing the rest of the text
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final Exception e){
            e.printStackTrace();
        }
    }

    // Player class
    static class ACMEPlayer {
        // Fields define what ALL players have
        String playerName;
        int health;
        int score;
        int level;
        String characterClass;
        boolean isAlive;

        // Constructor
        ACMEPlayer(String playerName, int health, int level, String characterClass) {
            this.playerName = playerName;
            this.health = health;
            this.level = level;
            this.characterClass = characterClass;
            
            // Default starting values for all players
            this.score = 0; 
            this.isAlive = true; 
        }

        // Independant copy constructor
        ACMEPlayer(ACMEPlayer original){
            this.playerName = original.playerName;
            this.health = original.health;
            this.level = original.level;
            this.characterClass = original.characterClass;

            // Default starting values for all players
            this.score = 0; 
            this.isAlive = true; 
        }
    }

    // Enemy class
    static class ACMEEnemy {
        // Fields define what ALL enemies have
        String enemyName;
        String enemyType;
        int health;
        int attackPower;
        String location;
        int rewardPoints;
        boolean isBoss;

        // Constructor
        ACMEEnemy(String enemyName, String enemyType, int health, int attackPower, boolean isBoss) {
            this.enemyName = enemyName;
            this.enemyType = enemyType;
            this.health = health;
            this.attackPower = attackPower;
            this.isBoss = isBoss;

            // Default location for all enemies
            this.location = "Albuquerque"; 

            // Calculate rewardPoints (e.g., 2 points per 1 health + 5 points per 1 attackPower)
            this.rewardPoints = (health * 2) + (attackPower * 5); 
            // Boss enemies get bonus points
            if (isBoss) {
                this.rewardPoints += 100;
            }
        }

        // Independant copy constructor
        ACMEEnemy(ACMEEnemy original){
            this.enemyName = original.enemyName;
            this.enemyType = original.enemyType;
            this.health = original.health;
            this.attackPower = original.attackPower;
            this.isBoss = original.isBoss;

            // Default location for all enemies
            this.location = "Albuquerque"; 

            // Calculate rewardPoints (e.g., 2 points per 1 health + 5 points per 1 attackPower)
            this.rewardPoints = (health * 2) + (attackPower * 5); 
            // Boss enemies get bonus points
            if (isBoss) {
                this.rewardPoints += 100;
            }
        }
    }

    // Item class
    static class ACMEItem {
        // Fields define what ALL items have
        String itemName;
        String itemType;
        double value;
        int durability;
        String rarity;
        boolean isConsumable;

        // Constructor
        ACMEItem(String itemName, String itemType, double value) {
            this.itemName = itemName;
            this.itemType = itemType;
            this.value = value;
            
            // Default rarity
            this.rarity = "Common"; 

            // Set durability and isConsumable based on item type
            switch (itemType) {
                case "Weapon":
                    this.durability = 50;
                    this.isConsumable = false;
                    break;
                case "Tool":
                case "Transportation":
                    this.durability = 100;
                    this.isConsumable = false;
                    break;
                case "Explosive":
                    this.durability = 1; // Single use
                    this.isConsumable = true;
                    break;
                default:
                    this.durability = 10;
                    this.isConsumable = true;
                    break;
            }
            
            // Special case for legendary items
            if (itemName.equals("Portable Hole")) {
                this.rarity = "Legendary";
            }
        }
    }

    // Random generator
    static Random rd = new Random();

    // Array for storing compatible classes
    static String classes[] = {"Brawler", "Assassin", "Tank"};
    // Add however many players that are needed for a match in one go
    static void addPlayers(int amount){
        for(int p = 0; p < amount; p++){
            // gives a random health between 100 and 200
            int hp = 100 + (rd.nextInt(101));

            // Build a player with semi random stats
            ACMEPlayer newPlayer = new ACMEPlayer("player" + (p+1), hp, rd.nextInt(6), classes[rd.nextInt(3)]);

            // Add player to a vector
            players.add(newPlayer);
        }
    }

    // Print player stats
    static void printPlayerStats(ACMEPlayer player){
        // Pull player from the vector so it can be read
        ACMEPlayer selectedPlayer = player;

        // print all player stats
        print("   Player name:  "+selectedPlayer.playerName);
        print("   Player hp:    "+selectedPlayer.health);
        print("   Player score: "+selectedPlayer.score);
        print("   Player level: "+selectedPlayer.level);
        print("   Player class: "+selectedPlayer.characterClass);
        print("   Player alive?:"+selectedPlayer.isAlive);
        print("");
    }

    // Change selected player stats
    static void changePlayerStats(int player){
        // Pull a copy of selected player out of vector to read and edit
        ACMEPlayer selectedPlayer = new ACMEPlayer(players.get(player - 1));
        // store old values for selected player
        ACMEPlayer oldPlayer = new ACMEPlayer(players.get(player - 1));

        clearTerminal();
        print("" + selectedPlayer.playerName);

        //ACMEPlayer(String playerName, int health, int level, String characterClass)
        // Change logic
        while (true){
            // Print options
            print("");
            print("Select stat to change:");
            print("  Health --- 1");
            print("  Level ---- 2");
            print("  Class ---- 3");
            print("Confirm ---- 0");

            askInt(); // read input
            print("");

            // If health is chosen
            if (input == 1){
                // Ask for new health
                print("Enter new health");
                askInt();

                // Update health
                selectedPlayer.health = input;
            }
            // If level is chosen
            else if (input == 2){
                // Ask for new level
                print("Enter new level");
                askInt();

                // Update level
                selectedPlayer.level = input;
            }
            // If class is chosen
            else if (input == 3){
                // present available classes
                print("Available classes");
                for (int i = 0; i < classes.length; i++){
                    print(classes[i] + "--- " + i);
                }

                // Ask for new class
                print("Pick a class");
                askInt();

                selectedPlayer.characterClass = classes[input];
            }
            // Exit condition
            else if (input == 0){
                break;
            }
            // If invalid input
            else {
                print("Invalid input");
            }
        }
        

        // Confirm changes with the user
        clearTerminal();
        print("Confirm changes?");
        print("   OLD:");
        // print old player stats
        printPlayerStats(oldPlayer);

        print("");

        print("   New:");
        // Print new player stats
        printPlayerStats(selectedPlayer);

        print("Yes --- 1");
        print("No ---- 0");
        askInt();

        // If yes is selected
        if (input == 1){
            // Replace old with new
            players.setElementAt(selectedPlayer, player-1);
            print("Stats changed");
            sc.nextLine();
        }
    }

    static void addEnemies(int amount){
            for(int p = 0; p < amount; p++){
            // gives a random health between 100 and 200
            int hp = 100 + (rd.nextInt(101));

            // give a random multiplier for attack power
            int attk = 20 + (rd.nextInt(11));

            // Build an enemy with all semi random stats and 1/14 chance of being a boss
            ACMEEnemy newEnemy = new ACMEEnemy("Enemy" + (p+1), classes[rd.nextInt(3)], hp, attk, rd.nextInt(15) < 2);

            // Add enemy to a vector
            enemies.add(newEnemy);
        }
    }

    // Print enemy stats
    static void printEnemyStats(ACMEEnemy enemy){
        // Pull enemy from the vector so it can be read
        ACMEEnemy selectedEnemy = enemy;

        /*
        String enemyName;
        String enemyType;
        int health;
        int attackPower;
        String location;
        int rewardPoints;
        boolean isBoss; */

        // Print all enemy stats
        print("   Name:     "+selectedEnemy.enemyName);
        print("   Hp:       "+selectedEnemy.health);
        print("   Type:     "+selectedEnemy.enemyType);
        print("   Power:    "+selectedEnemy.attackPower);
        print("   Location: "+selectedEnemy.location);
        print("   Reward:   "+selectedEnemy.rewardPoints);
        print("   Is boss?: "+selectedEnemy.isBoss);
        print("");
    }

    static void changeEnemyStats(int enemy){
        // Pull a copy of selected player out of vector to read and edit
        ACMEEnemy selectedEnemy = new ACMEEnemy(enemies.get(enemy - 1));
        // store old values for selected player
        ACMEEnemy oldEnemy = new ACMEEnemy(enemies.get(enemy - 1));

        clearTerminal();
        print("" + selectedEnemy.enemyName);

        // ACMEEnemy(String enemyName, String enemyType, int health, int attackPower, boolean isBoss)
        // Change logic
        while (true){
            // Print options
            print("");
            print("Select stat to change:");
            print("  Health --- 1");
            print("  Attack --- 2");
            print("  Class ---- 3");
            print("  Is Boss? - 4");
            print("Confirm ---- 0");

            askInt(); // read input
            print("");

            // If health is chosen
            if (input == 1){
                // Ask for new health
                print("Enter new health");
                askInt();

                // Update health
                selectedEnemy.health = input;
            }
            // If attack is chosen
            else if (input == 2){
                // Ask for new level
                print("Enter new attack");
                askInt();

                // Update level
                selectedEnemy.attackPower = input;
            }
            // If class is chosen
            else if (input == 3){
                // present available classes
                print("Available classes");
                for (int i = 0; i < classes.length; i++){
                    print(classes[i] + "--- " + i);
                }

                // Ask for new class
                print("Pick a class");
                askInt();

                selectedEnemy.enemyType = classes[input];
            }
            // If is boss is selected
            if (input == 4){
                // Ask for change
                print("Change boss status?");
                print("Yes --- 1");
                print("No ---- 2");
                askInt();

                // Flip boss status if chosen
                if (input == 1) selectedEnemy.isBoss = !selectedEnemy.isBoss;
            }
            // Exit condition
            else if (input == 0){
                break;
            }
            // If invalid input
            else {
                print("Invalid input");
            }
        }
        

        // Confirm changes with the user
        clearTerminal();
        print("Confirm changes?");
        print("   OLD:");
        // print old player stats
        printEnemyStats(oldEnemy);

        print("");

        print("   New:");
        // Print new player stats
        printEnemyStats(selectedEnemy);

        print("Yes --- 1");
        print("No ---- 0");
        askInt();

        // If yes is selected
        if (input == 1){
            // Replace old with new
            enemies.setElementAt(selectedEnemy, enemy-1);
            print("Stats changed");
            sc.nextLine();
        }
    }

    // array to store item types
    static String itemType[] = {"Mace", "Sword", "Daggers"};
    // Add items in play
    static void addItems(int amount){
        for(int p = 0; p < amount; p++){
            // Build an item
            ACMEItem newItem = new ACMEItem("Item" + p, itemType[rd.nextInt(3)], 100);

            // Add item to vector
            items.add(newItem);
        }
    }

    // Print all items
    static void printItems(){
        for(int i = 0; i < items.size(); i++){
            // Pull item from vector to read
            ACMEItem selectedItem = items.get(i);

            // print off the stats of selected item
            print("  Name: " + selectedItem.itemName);
            print("  Type: " + selectedItem.itemType);
        }
    }

    public static void main(String[] args) {
        // First, scrub the terminal
        clearTerminal();

        // Initial player creation
        print("Create players");
        print("How many?");
        askInt();
        addPlayers(input);

        // Initial Enemy creation
        print("Create enemies:");
        print("How many?");
        askInt();
        addEnemies(input);

        // Initial weapon creation
        print("Create items:");
        print("How many?");
        askInt();
        addEnemies(input);

        while (true){
            clearTerminal();
            // Allow user to play around with values or add items
            print("View players ---- 1");
            print("View enemies ---- 2");
            print("View items ------ 3");
            askInt();

            // If players is selected
            if (input == 1){
                clearTerminal();
                print("See all stats --- 1");
                print("Change stats ---- 2");
                askInt();

                // If see all stats is selected
                if (input == 1){
                    clearTerminal();
                    print("Players:");
                    print("");

                    // Run through every player in the players array and print their stats
                    for (int i = 0; i < players.size(); i++){
                        // Print the stats of the currently selected player
                        printPlayerStats(players.get(i));
                    }
                    // give time to read stats
                    sc.nextLine();
                }
                // If change stats is selected
                else if (input == 2){
                    print("Change stats:");
                    print("Choose player number");
                    askInt();

                    // confirm index value is reasonable
                    if (input <= players.size()) changePlayerStats(input);
                    else {print("Player you selected does not exist"); sc.nextLine();}
                }
                else {
                    print("Invalid input");
                }
            }

            // If enemies is selected
            else if (input == 2){
                print("See all stats --- 1");
                print("Change stats ---- 2");
                askInt();

                // If view stats is selected
                if (input == 1){
                    clearTerminal();
                    print("Enemies:");
                    print("");

                    // Run through every player in the players array and print their stats
                    for (int i = 0; i < enemies.size(); i++){
                        // Print the stats of the currently selected player
                        printEnemyStats(enemies.get(i));
                    }
                    // give time to read stats
                    sc.next();
                }
                // If change stats is selected
                else if (input == 2){
                    print("Change stats:");
                    print("Choose enemy number");
                    askInt();

                    // confirm index value is reasonable
                    if (input <= enemies.size()) changeEnemyStats(input);
                    else {print("Enemy you selected does not exist"); sc.nextLine();}
                }
                else {
                    print("Invalid value");
                }
            }

            // If view items is selected
            else if (input == 3){
                clearTerminal();
                print("Current items in play:");
                printItems();
                sc.nextLine();

            }

            else {
                print("Invalid value");
                sc.next();
            }
        }
 //   for(int p = 0; p < 5; p++){
    //    ACMEPlayer p = new ACMEPlayer("player" + p, (100 + p), p, classes[1];
 //   }
    }
}
import java.util.Vector;
import java.util.Random;
import java.util.Scanner;

public class ACMEEntitySystem {
    // Resizable vectors will make adding or removing more dynamic
    static Vector<ACMEPlayer> players = new Vector<>();
    static Vector<ACMEEnemy> enemies = new Vector<>();

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
    static String classes[] = {"Brawler", "Assasin", "Tank"};
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

        /*String playerName;
        int health;
        int score;
        int level;
        String characterClass;
        boolean isAlive; */

        // print all player stats
        print("   Player name:  "+selectedPlayer.playerName);
        print("   Player hp:    "+selectedPlayer.health);
        print("   Player score: "+selectedPlayer.score);
        print("   Player level: "+selectedPlayer.level);
        print("   Player class: "+selectedPlayer.characterClass);
        print("   Player dead?: "+selectedPlayer.isAlive);
        print("");
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

    public static void main(String[] args) {
        while (true){
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

            // Allow user to play around with values or add items
            print("View players ---- 1");
            print("View enemies ---- 2");
            print("Add items ------- 3");
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
                    sc.next();
                }
                // If change stats is selected
                if (input == 2){
                    print("Change stats:");
                }
                else {
                    print("Invalid value");
                }
            }

            // If enemies is selectec
            if (input == 2){
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
                if (input == 2){

                }
                else {
                    print("Invalid value");
                }
            }
            else {
                print("Invalid value");
                sc.next();
            }
        }
    }
}
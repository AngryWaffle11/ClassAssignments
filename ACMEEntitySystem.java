import java.util.Vector;

class ACMEPlayer {
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

class ACMEEnemy {
    // Fields define what ALL enemies have
    String enemyType;
    int health;
    int attackPower;
    String location;
    int rewardPoints;
    boolean isBoss;

    // Constructor
    ACMEEnemy(String enemyType, int health, int attackPower, boolean isBoss) {
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

class ACMEItem {
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



public class ACMEEntitySystem {
    // Resizable vectors will make adding or removing more dynamic
    static Vector<ACMEPlayer> players = new Vector<>();
    Vector<ACMEEnemy> enemies = new Vector<>();

    public static void main(String[] args) {
    for(int p = 0; p < 5; p++){
        ACMEPlayer p = new ACMEPlayer("player" + p, 100 + p, p, )
    }
    }
}
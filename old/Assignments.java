package old;
class ResourceConsumption{
    int woodenBoard;
    int metalScrap;
    int plasticPart;

    ResourceConsumption(int wood, int metal, int plastic){
        this.woodenBoard = wood;
        this.metalScrap = metal;
        this.plasticPart = plastic;
    }
};

class Weapon{
    String name;
    int damage;
    ResourceConsumption resources;

    Weapon(String name, int damage, ResourceConsumption resources){
        this.name = "Basic weapon";
        this.damage = 1;
        this.resources = new ResourceConsumption(resources.woodenBoard, resources.metalScrap, resources.plasticPart);
        }
};

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
};

class Enemy{
    int enemySize;
    String name;
    int health;
    int attack;
    Position startPosition;
    String location;

    Enemy(int enemySize, String name, Position startPosition){
        this.enemySize = enemySize;
        this.name = name;
        this.health = 1 + enemySize;
        this.attack = 1 + enemySize;
        this.startPosition = startPosition;
        this.location = "Albuquerque";
    }

    Enemy(int enemySize, String name, int health, int attack, Position startPosition, String location){
        this.enemySize = enemySize;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.startPosition = startPosition;
        this.location = location;
    }
};

class Item{
    String itemName;
    String itemType;
    int quantity;
    int value;
    String location;

    Item(String itemName, String itemType){
        this.itemName = itemName;
        this.itemType = itemType;
        this.quantity = 1;
        this.value = 1;
        this.location = "lava zone";
    }
}

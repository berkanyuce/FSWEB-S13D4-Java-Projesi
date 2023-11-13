public class Player {
    private String name;
    private int healthPercentage;
    private Weapon weapon;

    public enum Weapon {
        SWORD,
        AXE,
        BOW
    }
    public Player(String name, int healthPercentage, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        if (healthPercentage < 0) this.healthPercentage = 0;
        else this.healthPercentage = Math.min(healthPercentage, 100);
    }

    public int healthRemaining() { return healthPercentage; }
    public void loseHealth(int damage) {
        healthPercentage -= damage;
        if(healthPercentage < 0) {
            System.out.println(name + " player has been knocked out of game");
            healthPercentage = 0;
        }
    }

    public void restoreHealth(int healthPotion) {
        healthPercentage += healthPotion;
        if(healthPercentage > 100) healthPercentage = 100;
    }

    public static void main(String[] args) {
        Player player1 = new Player("Berkan", 5, Weapon.SWORD);

        System.out.println("player1 health= " + player1.healthRemaining());
        player1.loseHealth(2);
        System.out.println("player1 health= " + player1.healthRemaining());
        player1.loseHealth(20);
        System.out.println("player1 health= " + player1.healthRemaining());

        player1.restoreHealth(100);
        System.out.println("player1 health= " + player1.healthRemaining());

        player1.restoreHealth(100);
        System.out.println("player1 health= " + player1.healthRemaining());
    }
}

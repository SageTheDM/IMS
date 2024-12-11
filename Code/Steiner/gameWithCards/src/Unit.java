public abstract class Unit {
    protected int health;
    protected int defense;
    protected int attack;

    public Unit(int health, int defense, int attack) {
        this.health = health;
        this.defense = defense;
        this.attack = attack;
    }

    public abstract void defend();

    public abstract void attack();

    public abstract void move();
}
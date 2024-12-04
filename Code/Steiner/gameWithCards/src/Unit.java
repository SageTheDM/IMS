public abstract class Unit {
    private int health;
    private int defense;
    private int attack;
    private int reach;
    private int speed;

    public abstract void defend();

    public abstract void attack();

    public abstract void move();
}

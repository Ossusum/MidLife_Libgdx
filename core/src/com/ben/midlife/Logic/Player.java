package Logic;

/**
 * Created by Benny on 11/20/2016.
 */
public class Player extends Entity{

    private int exp;

    public Player(String name) {
        super(name);
    }

    public Player(String name, Part[] bodyParts, boolean isDead, int health, int attack) {
        super(name, bodyParts, isDead, health, attack);
    }

    public Player(String name,int exp) {
        super(name);
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}

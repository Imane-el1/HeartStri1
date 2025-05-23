package cards;

import java.io.Serializable;

public class Card implements Serializable{
    protected String name;
    protected int mana;
    protected int attack;
    protected int health;
    protected static final long serialVersionUID = 1L; 

    public Card(String name, int mana, int attack, int health) {
        this.name = name;
        this.mana = mana;
        this.attack = attack;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return name + " [Mana: " + mana + ", Attack: " + attack + ", Health: " + health + "]";
    }
}

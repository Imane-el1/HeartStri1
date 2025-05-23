
package cards;

public class WeaponCard extends Card {
    private int durability;

    public WeaponCard(String name, int attack, int manaCost, int durability, String desc) {
        super(name, attack, 0, manaCost); 
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }
}

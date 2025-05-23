package cards;

public class MinionCard extends Card {
    private String specialAbility;

    public MinionCard(String name, int attack, int defense, int manaCost, String specialAbility) {
        super(name, attack, defense, manaCost);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

	public void setHealth(int i) {
		this.health = health;
	}

	public void setAttack(int i) {
		this.attack = attack;
	}
}
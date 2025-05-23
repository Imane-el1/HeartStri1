
package cards;

import Heros.Hero;

public class HeroCard extends Card {
    private String specialPower;

    public HeroCard(String name, int mana, String specialPower) {
        super(name, 2, 0, 30); 
        this.specialPower = specialPower;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void useSpecialPower(Hero user, Hero opponent) {
    
        switch (specialPower) {
            case "Shapeshift":
                System.out.println(user.getName() + " uses Shapeshift! Gains +1 Attack and +1 Armor.");
                user.setAttack(user.getAttack() + 1);
                user.setHealth(user.getHealth() + 1);
                break;

            case "Steady Shot":
                System.out.println(user.getName() + " uses Steady Shot! Deals 2 damage to the enemy hero.");
                opponent.takeDamage(2);
                break;

            case "Fireblast":
                System.out.println(user.getName() + " uses Fireblast! Deals 1 damage to the enemy hero.");
                opponent.takeDamage(1);
                break;

            case "Reinforce":
                System.out.println(user.getName() + " uses Reinforce! Summons a 1/1 Silver Hand Recruit.");
                
                break;

            case "Lesser Heal":
                System.out.println(user.getName() + " uses Lesser Heal! Restores 2 Health.");
                user.setHealth(Math.min(30, user.getHealth() + 2));
                break;

            case "Dagger Mastery":
                System.out.println(user.getName() + " uses Dagger Mastery! Equips a 1/2 Dagger.");
                
                break;

            case "Totemic call":
                System.out.println(user.getName() + " uses Totemic Call! Summons a random Totem.");
         
                break;

            case "Life Tap":
                System.out.println(user.getName() + " uses Life Tap! Draws a card and takes 2 damage.");
                user.takeDamage(2);
                break;

            case "Armor Up!":
                System.out.println(user.getName() + " uses Armor Up! Gains 2 Armor.");
                user.setHealth(user.getHealth() + 2);
                break;

            case "Demon Claws":
                System.out.println(user.getName() + " uses Demon Claws! Gains +1 Attack this turn.");
                user.setAttack(user.getAttack() + 1);
                break;

            default:
                System.out.println("Unknown special power: " + specialPower);
        }
    }
}

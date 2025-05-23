
package Heros;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import cards.Card;
import cards.Deck; // Assuming Deck is a class that contains a list of cards
import cards.HeroCard;
import cards.MinionCard;
import cards.SpellCard;

import java.util.Scanner;

public class Hero {
    private String name;
    private int mana;
    private int attack;
    private int health;
    private Map<String, String> classe = new HashMap<>(); // Initialize the map

    
    public Hero() {
    	this.health = 30;
    }
    public String getName() {
        return name;
    }

    public Map<String, String> getClasse() {
        return classe;
    }

    public void setClasse(Map<String, String> classe) {
        this.classe = classe;
    }

    public void addClasse(String key, String value) {
        this.classe.put(key, value); // Add a key-value pair
    }

    public String getClasseValue(String key) {
        return this.classe.get(key); // Retrieve a value by key
    }

    public int getMana() {
        return mana;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return Math.max(0, health);
    }
   
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public String toString() {
        return name + " [Mana: " + mana + ", Attack: " + attack + ", Health: " + health + "]";
    }

    
    private int getInitialMana() {
    	// TODO Auto-generated method stub
    	return mana;
    }

    private void setInitialMana(int i) {
    	// TODO Auto-generated method stub
    	this.mana = i;
    }

    public void setMana(int mana) {
    	this.mana = mana;
    }

    public void setAttack(int attack) {
    	this.attack = attack;
    }

    public void setHealth(int health) {
    	this.health = health;
    }

    public void setName(String name) {
    	// TODO Auto-generated method stub
    	this.name = name;
    	
    }

    	  
        

    public void displayClasse() {
        int i = 1;
        // Populate the map with default values
        classe.put("Druid", "Malfurion Stormrage");
        classe.put("Hunter", "Rexxar");
        classe.put("Mage", "Jaina Proudmoore");
        classe.put("Paladin", "Uther Lightbringer");
        classe.put("Priest", "Anduin Wrynn");
        classe.put("Rogue", "Valeera Sanguinar");
        classe.put("Shaman", "Thrall");
        classe.put("Warlock", "Gul'dan");
        classe.put("Warrior", "Garrosh Hellscream");
        classe.put("Demon Hunter", "Illidan Stormrage");

        if (classe != null && !classe.isEmpty()) {
            System.out.println("Classe Keys:");
            for (String key : classe.keySet()) {
                System.out.println(i + ". " + key);
                i++;
            }
        } else {
            System.out.println("Classe map is empty or not initialized.");
        }
    }

    public Card drawRandom(Deck deck) {
        if (deck.getCards().isEmpty()) {
            System.out.println("The deck is empty.");
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(deck.getCards().size());
        return deck.getCards().remove(randomIndex);
    }
    
    
    
    
    

public void castSpellOnLastMinion(SpellCard spell, List<Card> opponentTargets) {
    if (spell == null) {
        System.out.println("No spell provided.");
        return;
    }

    if (opponentTargets.isEmpty()) {
        System.out.println("No available targets for the spell.");
        return;
    }

    Card target = null;
    for (int i = opponentTargets.size() - 1; i >= 0; i--) {
        if (opponentTargets.get(i) instanceof MinionCard) {
            target = opponentTargets.get(i);
            break;
        }
    }

    if (target == null) {
        System.out.println("No minion found to cast the spell on.");
        return;
    }

    System.out.println("Casting spell: " + spell.getName() + " on " + target.getName());

    if (target instanceof MinionCard) {
        MinionCard minion = (MinionCard) target;
        if (spell.getAttack() > 0) {
            minion.setAttack(minion.getAttack() + spell.getAttack());
            System.out.println(target.getName() + " gains " + spell.getAttack() + " attack.");
        }
        if (spell.getHealth() > 0) {
            minion.setHealth(minion.getHealth() + spell.getHealth());
            System.out.println(target.getName() + " gains " + spell.getHealth() + " health.");
        }
    }

    System.out.println("Spell cast successfully on " + target.getName() + ".");
}




public void fightCards(Hero srv1, Hero srv2, Deck deck1, Deck deck2) {
    ArrayList<Card> cardInHand1 = new ArrayList<>();
    ArrayList<Card> cardInHand2 = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int mana1 = 1;
    int mana2 = 1;


    for (int i = 0; i < 3; i++) {
        Card card = srv1.drawRandom(deck1);
        if (card != null) {
            cardInHand1.add(card);
        }
    }

    for (int i = 0; i < 4; i++) {
        Card card = srv2.drawRandom(deck2);
        if (card != null) {
            cardInHand2.add(card);
        }
    }

    boolean isServiteur1Turn = true;

    while (srv1.getHealth() > 0 && srv2.getHealth() > 0) {
        Hero currentServiteur = isServiteur1Turn ? srv1 : srv2;
        Hero opponentServiteur = isServiteur1Turn ? srv2 : srv1;
        ArrayList<Card> currentHand = isServiteur1Turn ? cardInHand1 : cardInHand2;
        Deck currentDeck = isServiteur1Turn ? deck1 : deck2;

   
        if (currentHand.isEmpty() && !currentDeck.getCards().isEmpty()) {
            System.out.println(currentServiteur.getName() + "'s hand is empty. Drawing new cards...");
            for (int i = 0; i < 3; i++) {
                Card card = currentServiteur.drawRandom(currentDeck);
                if (card != null) {
                    currentHand.add(card);
                }
            }
        }

        currentServiteur.setMana(isServiteur1Turn ? mana1 : mana2);

        System.out.println("\n" + currentServiteur.getName() + "'s turn. Mana: " + currentServiteur.getMana());
        System.out.println("Choose a card to play or type 0 to end your turn:");

        boolean turnEnded = false;

        while (!turnEnded) {
            for (int i = 0; i < currentHand.size(); i++) {
                Card card = currentHand.get(i);
                System.out.println((i + 1) + ". " + card + " (Mana Cost: " + card.getMana() + ")");
            }
            System.out.println("0. End Turn");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                turnEnded = true;
                System.out.println(currentServiteur.getName() + " ended their turn.");
            } else if (choice > 0 && choice <= currentHand.size()) {
                Card chosenCard = currentHand.get(choice - 1);
                if (chosenCard.getMana() <= currentServiteur.getMana()) {
                    currentHand.remove(choice - 1);
                    currentServiteur.setMana(currentServiteur.getMana() - chosenCard.getMana());

                    if (chosenCard instanceof SpellCard) {
                        SpellCard spellCard = (SpellCard) chosenCard;
                        currentServiteur.castSpellOnLastMinion(spellCard, isServiteur1Turn ? cardInHand2 : cardInHand1);
                    } else {
                        System.out.println(currentServiteur.getName() + " played: " + chosenCard + ". Remaining Mana: " + currentServiteur.getMana());
                        opponentServiteur.takeDamage(chosenCard.getAttack());
                        System.out.println(opponentServiteur.getName() + " took " + chosenCard.getAttack() + " damage. Remaining Health: " + opponentServiteur.getHealth());

                        if (opponentServiteur.getHealth() <= 0) {
                            System.out.println(opponentServiteur.getName() + " has been defeated!");
                            System.out.println(currentServiteur.getName() + " is the winner!");
                            scanner.close();
                            return;
                        }
                    }
                } else {
                    System.out.println("Not enough mana to play this card. Choose another card or end your turn.");
                }
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        if (isServiteur1Turn) {
            mana1 = Math.min(10, mana1 + 1);
        } else {
            mana2 = Math.min(10, mana2 + 1);
        }

        isServiteur1Turn = !isServiteur1Turn;
    }

    scanner.close();
}



}

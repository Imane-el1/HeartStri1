package cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


import Heros.Hero;
import cards.*;


public class Deck implements Serializable {
	private static final long serialVersionUID = 1L;
    private List<Card> cards;
    private static String name;
    private HeroCard heropower;
    static Deck deck = new Deck();
    
    public Deck() {
        this.name = name;
        this.cards = new ArrayList<>();
        this.heropower = heropower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
    
    public void createDeckFromConsole(String name) {
    		this.setName(name);
        	Scanner scanner = new Scanner(System.in);
            System.out.println("Class: " + name);
            List<Card> availableCards = getAvailableCardsForClass(name);

            if (availableCards.isEmpty()) {
                System.out.println("No cards available for the selected class.");
                return;
            }

            System.out.println("Available cards:");
            for (int i = 0; i < availableCards.size(); i++) {
                System.out.println((i + 1) + ". " + availableCards.get(i).getName());
            }

            System.out.println("Choose cards for your deck (enter one number at a time):");

            while (cards.size() < 30) {
                String input = scanner.nextLine();

                try {
                    int index = Integer.parseInt(input) - 1;

                    if (index >= 0 && index < availableCards.size()) {
                        Card selectedCard = availableCards.get(index);

                        long count = cards.stream()
                            .filter(card -> card.getName().equals(selectedCard.getName()))
                            .count();

                        if (count < 2) {
                            addCard(selectedCard);
                            System.out.println(selectedCard.getName() + " added to the deck.");
                        } else {
                            System.out.println("You can only choose " + selectedCard.getName() + " up to 2 times.");
                        }
                    } else {
                        System.out.println("Invalid number: " + input);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + input);
                }

                if (cards.size() == 30) {
                    System.out.println("Deck is full (30 cards).");
                }
            }

            System.out.println("Deck creation complete!");
        
    }


    
    

    private List<Card> getAvailableCardsForClass(String className) {
    	  
        List<Card> availableCards = new ArrayList<>();
        
        deck.setName(name);
        
        // Neutral cards
        availableCards.add(new MinionCard("Novice Engineer", 1, 1, 2, "Battlecry: Draw a card."));
        availableCards.add(new MinionCard("Boulderfist Ogre", 6, 7, 6, "No special ability."));
        availableCards.add(new MinionCard("Chillwind Yeti", 4, 5, 4, "No special ability."));
        availableCards.add(new MinionCard("Shieldbearer", 1, 0, 4, "Taunt"));
        availableCards.add(new MinionCard("Wolfrider", 3, 3, 1, "Charge"));
        availableCards.add(new MinionCard("Argent Squire", 1, 1, 1, "Divine Shield"));
        availableCards.add(new SpellCard("Arcane Explosion", 2, "Deal 1 damage to all enemy minions."));
        availableCards.add(new SpellCard("Polymorph", 4, "Transform a minion into a 1/1 Sheep."));
        
        switch (deck.getName()) {

			case "Druid":
				// specific cards for Druid 
				availableCards.add(new HeroCard("Malfurion Stormrage", 2, "Shapeshift"));
			    availableCards.add(new SpellCard("Innervate", 0, "Gain 1 Mana Crystal this turn only."));
			    availableCards.add(new SpellCard("Wild Growth", 2, "Gain an empty Mana Crystal."));
			    availableCards.add(new SpellCard("Swipe", 4, "Deal 4 damage to an enemy and 1 damage to all other enemies."));
			    availableCards.add(new SpellCard("Wrath", 2, "Choose One - Deal 3 damage to a minion; or 1 damage and draw a card."));
			    availableCards.add(new SpellCard("Nourish", 5, "Choose One - Gain 2 Mana Crystals; or Draw 3 cards."));
			    availableCards.add(new MinionCard("Ironbark Protector", 8, 8, 8, "Taunt"));
			    availableCards.add(new MinionCard("Keeper of the Grove", 4, 2, 4, "Choose One - Deal 2 damage; or Silence a minion."));
			    availableCards.add(new MinionCard("Druid of the Claw", 5, 4, 4, "Choose One - Transform into a 4/4 with Charge; or a 4/6 with Taunt."));
			    availableCards.add(new MinionCard("Ancient of Lore", 7, 5, 5, "Choose One - Draw 2 cards; or Restore 5 Health."));
			    availableCards.add(new MinionCard("Ancient of War", 7, 5, 5, "Choose One - Gain +5 Attack; or +5 Health and Taunt."));
			    break;

			case "Hunter":
				// Hunter cards 
				availableCards.add(new HeroCard("Rexxar", 2, "Steady Shot"));
			    availableCards.add(new SpellCard("Kill Command", 3, "Deal 3 damage. If you control a Beast, deal 5 damage instead."));
			    availableCards.add(new SpellCard("Animal Companion", 3, "Summon a random Beast companion."));
			    availableCards.add(new SpellCard("Unleash the Hounds", 3, "Summon a 1/1 Hound with Charge for each enemy minion."));
			    availableCards.add(new SpellCard("Explosive Trap", 2, "Secret: When your hero is attacked, deal 2 damage to all enemies."));
			    availableCards.add(new SpellCard("Tracking", 1, "Look at the top 3 cards of your deck. Draw one and discard the others."));
			    availableCards.add(new MinionCard("Savannah Highmane", 6, 6, 5, "Deathrattle: Summon two 2/2 Hyenas."));
			    availableCards.add(new MinionCard("Houndmaster", 4, 4, 3, "Battlecry: Give a friendly Beast +2/+2 and Taunt."));
			    availableCards.add(new MinionCard("Scavenging Hyena", 2, 2, 2, "Whenever a friendly Beast dies, gain +2/+1."));
			    availableCards.add(new MinionCard("Timber Wolf", 1, 1, 1, "Your other Beasts have +1 Attack."));
			    availableCards.add(new MinionCard("Starving Buzzard", 5, 3, 2, "Whenever you summon a Beast, draw a card."));
			    break;

            case "Mage":
            	// Here we add cards 
            	availableCards.add(new HeroCard("Jaina Proudmoore", 2, "Fireblast"));
                availableCards.add(new SpellCard("Fireball", 4, "Deal 6 damage."));
                availableCards.add(new SpellCard("Frostbolt", 2, "Deal 3 damage and freeze."));
                availableCards.add(new SpellCard("Arcane Intellect", 3, "Draw 2 cards."));
                availableCards.add(new SpellCard("Polymorph", 4, "Transform a minion into a 1/1 Sheep."));
                availableCards.add(new SpellCard("Flamestrike", 7, "Deal 4 damage to all enemy minions."));
                availableCards.add(new SpellCard("Arcane Explosion", 2, "Deal 1 damage to all enemy minions."));
                availableCards.add(new MinionCard("Water Elemental", 3, 6, 4, "Freeze any character damaged by this minion."));
                availableCards.add(new MinionCard("Sorcerer's Apprentice", 2, 3, 2, "Your spells cost (1) less."));
                availableCards.add(new MinionCard("Mana Wyrm", 1, 1, 3, "Gain +1 Attack whenever you cast a spell."));
                availableCards.add(new MinionCard("Kirin Tor Mage", 3, 4, 3, "Battlecry: The next Secret you play costs (0)."));
                availableCards.add(new MinionCard("Archmage Antonidas", 7, 5, 7, "Whenever you cast a spell, add a 'Fireball' to your hand."));
                availableCards.add(new MinionCard("Ragnaros the Firelord", 8, 8, 8, "At the end of your turn, deal 8 damage to a random enemy."));
                break;

			case "Paladin":
				availableCards.add(new HeroCard("Uther Lightbringer", 2, "Reinforce"));
			    availableCards.add(new SpellCard("Blessing of Kings", 4, "Give a minion +4/+4."));
			    availableCards.add(new SpellCard("Consecration", 4, "Deal 2 damage to all enemies."));
			    availableCards.add(new SpellCard("Holy Light", 2, "Restore 6 Health."));
			    availableCards.add(new SpellCard("Equality", 2, "Set the Health of all minions to 1."));
			    availableCards.add(new SpellCard("Hammer of Wrath", 4, "Deal 3 damage. Draw a card."));
			    availableCards.add(new MinionCard("Tirion Fordring", 8, 6, 6, "Taunt, Divine Shield, Deathrattle: Equip a 5/3 Ashbringer."));
			    availableCards.add(new MinionCard("Silver Hand Recruit", 1, 1, 1, "No special ability."));
			    availableCards.add(new MinionCard("Guardian of Kings", 7, 5, 6, "Battlecry: Restore 6 Health to your hero."));
			    availableCards.add(new MinionCard("Aldor Peacekeeper", 3, 3, 3, "Battlecry: Change an enemy minion's Attack to 1."));
			    availableCards.add(new MinionCard("Sunkeeper Tarim", 6, 3, 7, "Taunt, Battlecry: Set all other minions' Attack and Health to 3."));
			    break;

			case "Priest":
				// here we add paladin cards
				availableCards.add(new HeroCard("Anduin Wrynn", 2, "Lesser Heal"));
			    availableCards.add(new SpellCard("Holy Smite", 1, "Deal 2 damage."));
			    availableCards.add(new SpellCard("Power Word: Shield", 1, "Give a minion +2 Health. Draw a card."));
			    availableCards.add(new SpellCard("Shadow Word: Pain", 2, "Destroy a minion with 3 or less Attack."));
			    availableCards.add(new SpellCard("Shadow Word: Death", 3, "Destroy a minion with 5 or more Attack."));
			    availableCards.add(new SpellCard("Holy Nova", 5, "Deal 2 damage to all enemies. Restore 2 Health to all friendly characters."));
			    availableCards.add(new SpellCard("Mind Control", 10, "Take control of an enemy minion."));
			    availableCards.add(new MinionCard("Northshire Cleric", 1, 1, 3, "Whenever a minion is healed, draw a card."));
			    availableCards.add(new MinionCard("Injured Blademaster", 3, 4, 7, "Battlecry: Deal 4 damage to himself."));
			    availableCards.add(new MinionCard("Auchenai Soulpriest", 4, 3, 5, "Your cards and powers that restore Health now deal damage instead."));
			    availableCards.add(new MinionCard("Cabal Shadow Priest", 6, 4, 5, "Battlecry: Take control of an enemy minion that has 2 or less Attack."));
			    break;
			    
			case "Rogue":
				// Roge cards
				availableCards.add(new HeroCard("Valeera Sanguinar", 2, "Dagger Mastery: Equip a 1/2 Dagger."));
			    availableCards.add(new SpellCard("Backstab", 0, "Deal 2 damage to an undamaged minion."));
			    availableCards.add(new SpellCard("Eviscerate", 2, "Deal 2 damage. Combo: Deal 4 damage instead."));
			    availableCards.add(new SpellCard("Sap", 2, "Return an enemy minion to your opponent's hand."));
			    availableCards.add(new SpellCard("Fan of Knives", 3, "Deal 1 damage to all enemy minions. Draw a card."));
			    availableCards.add(new SpellCard("Preparation", 0, "The next spell you cast this turn costs (3) less."));
			    availableCards.add(new MinionCard("SI:7 Agent", 3, 3, 3, "Combo: Deal 2 damage."));
			    availableCards.add(new MinionCard("Edwin VanCleef", 3, 2, 2, "Combo: Gain +2/+2 for each other card you've played this turn."));
			    availableCards.add(new MinionCard("Defias Ringleader", 2, 2, 2, "Combo: Summon a 2/1 Defias Bandit."));
			    availableCards.add(new MinionCard("Shadowstep", 0, 0, 0, "Return a friendly minion to your hand. It costs (2) less."));
			    availableCards.add(new MinionCard("Vanish", 6, 0, 0, "Return all minions to their owner's hand."));
			    availableCards.add(new WeaponCard("Assassin's Blade", 5, 3, 4, "A reliable weapon for sustained damage."));
			    availableCards.add(new WeaponCard("Perdition's Blade", 3, 2, 2, "Combo: Deal 1 damage."));
			   
			    break;
			    
			case "Shaman":
				// Shaman cards
				availableCards.add(new HeroCard("Thrall", 2, "Totemic Call"));
			    availableCards.add(new SpellCard("Lightning Bolt", 1, "Deal 3 damage. Overload: (1)"));
			    availableCards.add(new SpellCard("Hex", 3, "Transform a minion into a 0/1 Frog with Taunt."));
			    availableCards.add(new SpellCard("Bloodlust", 5, "Give your minions +3 Attack this turn."));
			    availableCards.add(new SpellCard("Feral Spirit", 3, "Summon two 2/3 Spirit Wolves with Taunt. Overload: (2)"));
			    availableCards.add(new SpellCard("Lava Burst", 3, "Deal 5 damage. Overload: (2)"));
			    availableCards.add(new MinionCard("Fire Elemental", 6, 6, 5, "Battlecry: Deal 3 damage."));
			    availableCards.add(new MinionCard("Al'Akir the Windlord", 8, 3, 5, "Charge, Divine Shield, Taunt, Windfury."));
			    availableCards.add(new MinionCard("Mana Tide Totem", 3, 0, 3, "At the end of your turn, draw a card."));
			    availableCards.add(new MinionCard("Flametongue Totem", 2, 0, 3, "Adjacent minions have +2 Attack."));
			    availableCards.add(new MinionCard("Thunder Bluff Valiant", 5, 3, 6, "Inspire: Give your Totems +2 Attack."));
			    availableCards.add(new WeaponCard("Stormforged Axe", 2, 2, 3, "Overload: (1)."));
			    availableCards.add(new WeaponCard("Doomhammer", 5, 2, 8, "Windfury, Overload: (2)."));
			   
			    break;
			    
			case "Warlock":
				// Warlock cards
				availableCards.add(new HeroCard("Gul'dan", 2, "Life Tap"));
			    availableCards.add(new SpellCard("Soulfire", 1, "Deal 4 damage. Discard a random card."));
			    availableCards.add(new SpellCard("Hellfire", 4, "Deal 3 damage to all characters."));
			    availableCards.add(new SpellCard("Shadow Bolt", 3, "Deal 4 damage to a minion."));
			    availableCards.add(new SpellCard("Drain Life", 3, "Deal 2 damage. Restore 2 Health to your hero."));
			    availableCards.add(new SpellCard("Twisting Nether", 8, "Destroy all minions."));
			    availableCards.add(new MinionCard("Voidwalker", 1, 1, 3, "Taunt"));
			    availableCards.add(new MinionCard("Doomguard", 5, 5, 7, "Charge. Battlecry: Discard two random cards."));
			    availableCards.add(new MinionCard("Flame Imp", 1, 3, 2, "Battlecry: Deal 3 damage to your hero."));
			    availableCards.add(new MinionCard("Succubus", 2, 4, 3, "Battlecry: Discard a random card."));
			    availableCards.add(new MinionCard("Lord Jaraxxus", 9, 3, 15, "Battlecry: Replace your hero with Lord Jaraxxus."));
			    availableCards.add(new WeaponCard("Blood Fury", 3, 3, 8, "A weapon for aggressive Warlock strategies."));
			    availableCards.add(new WeaponCard("Skull of the Man'ari", 5, 0, 3, "At the start of your turn, summon a Demon from your hand."));
			    
			    break;
			    
			case "Warrior":
				// Warrior cards
				availableCards.add(new HeroCard("Garrosh Hellscream", 2, "Armor Up!: Gain 2 Armor."));
			    availableCards.add(new SpellCard("Execute", 1, "Destroy a damaged enemy minion."));
			    availableCards.add(new SpellCard("Shield Slam", 1, "Deal 1 damage to a minion for each Armor you have."));
			    availableCards.add(new SpellCard("Whirlwind", 1, "Deal 1 damage to all minions."));
			    availableCards.add(new SpellCard("Brawl", 5, "Destroy all minions except one. (chosen randomly)"));
			    availableCards.add(new SpellCard("Shield Block", 3, "Gain 5 Armor. Draw a card."));
			    availableCards.add(new MinionCard("Frothing Berserker", 3, 2, 4, "Whenever a minion takes damage, gain +1 Attack."));
			    availableCards.add(new MinionCard("Armorsmith", 2, 1, 4, "Whenever a friendly minion takes damage, gain 1 Armor."));
			    availableCards.add(new MinionCard("Grommash Hellscream", 8, 4, 9, "Charge. Enrage: +6 Attack."));
			    availableCards.add(new MinionCard("Acolyte of Pain", 3, 1, 3, "Whenever this minion takes damage, draw a card."));
			    availableCards.add(new MinionCard("Kor'kron Elite", 4, 4, 3, "Charge."));
			    availableCards.add(new WeaponCard("Fiery War Axe", 2, 3, 2, "A classic weapon for early board control."));
			    availableCards.add(new WeaponCard("Arcanite Reaper", 5, 5, 2, "A high-damage weapon for finishing blows."));
			   
			    break;
			    
			case "Demon Hunter":
				// Demon Hunter cards
				availableCards.add(new HeroCard("Illidan Stormrage", 2, "Demon Claws"));
			    availableCards.add(new SpellCard("Twin Slice", 0, "Give your hero +1 Attack this turn. Add a 'Second Slice' to your hand."));
			    availableCards.add(new SpellCard("Chaos Strike", 2, "Give your hero +2 Attack this turn. Draw a card."));
			    availableCards.add(new SpellCard("Blade Dance", 2, "Deal your hero's Attack damage to 3 random enemy minions."));
			    availableCards.add(new SpellCard("Eye Beam", 3, "Lifesteal. Deal 3 damage to a minion. Costs (1) if Outcast."));
			    availableCards.add(new SpellCard("Metamorphosis", 5, "Swap your Hero Power to 'Deal 5 damage.' After 2 uses, swap it back."));
			    availableCards.add(new MinionCard("Battlefiend", 1, 2, 2, "After your hero attacks, gain +1 Attack."));
			    availableCards.add(new MinionCard("Satyr Overseer", 3, 4, 2, "After your hero attacks, summon a 2/2 Satyr."));
			    availableCards.add(new MinionCard("Wrathscale Naga", 3, 3, 1, "Whenever a friendly minion dies, deal 3 damage to a random enemy."));
			    availableCards.add(new MinionCard("Hulking Overfiend", 6, 5, 10, "Rush. After this attacks and kills a minion, it may attack again."));
			    availableCards.add(new MinionCard("Priestess of Fury", 7, 6, 7, "At the end of your turn, deal 6 damage randomly split among all enemies."));
			    availableCards.add(new WeaponCard("Warglaives of Azzinoth", 5, 3, 4, "After attacking a minion, your hero may attack again."));
			    availableCards.add(new WeaponCard("Aldrachi Warblades", 3, 2, 3, "Lifesteal."));
			   
			    break;
			    
            default:
                System.out.println("No cards available for the selected class.");
                break;
        } 
        
        
		return availableCards;
       
    }



	public HeroCard getHeropower() {
		return heropower;
	}



	public void setHeropower(HeroCard heropower) {
		this.heropower = heropower;
	}
	
}



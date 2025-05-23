package cards;

import java.util.List;
import java.util.Scanner;

public class SpellCard extends Card {
    private String effect;

    public SpellCard(String name, int manaCost, String effect) {
        super(name, manaCost, 0, 0); 
        this.effect = effect;

    }

    public String getEffect() {
        return effect;
    }
    
	
	

    
}
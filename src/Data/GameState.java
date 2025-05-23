
package Data;

import java.io.Serializable;
import cards.Deck;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    private Deck deck1;
    private Deck deck2;

    public GameState(Deck deck1, Deck deck2) {
        this.deck1 = deck1;
        this.deck2 = deck2;
    }

    public Deck getDeck1() {
        return deck1;
    }

    public Deck getDeck2() {
        return deck2;
    }
}

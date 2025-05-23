
package main;

import java.util.Scanner;
import Data.SaveManager;
import Data.GameState;
import Heros.Hero;
import cards.Deck;

/**
 * The main method serves as the entry point for the Battle Simulation program.
 * It initializes two decks and their respective heroes, allows the user to configure them,
 * simulates a battle between the two decks so that we could save and load the game state.
 *
 * Steps:
 * 1. Choose the name of the Hero classe.
 * 2. Create the first deck.
 * 3. Choose the name of the Hero classe.
 * 2. Create the second deck.
 * 3. Simulate a battle between the two Heros.
 * 4. Save the game state to a file.
 * 5. Load the game state from the file and display the loaded data.
 *
 */

public class BattleSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // We create the first deck
        Deck deck1 = new Deck();
        Hero serv1 = new Hero();
        serv1.displayClasse();
        String userInput1 = scanner.nextLine();
        serv1.setName(serv1.getClasse().get(userInput1));
        deck1.setName(userInput1);
        deck1.createDeckFromConsole(deck1.getName());

        // then  the second deck
        Deck deck2 = new Deck();
        Hero serv2 = new Hero();
        serv2.displayClasse();
        String userInput2 = scanner.nextLine();
        serv2.setName(serv2.getClasse().get(userInput2));
        deck2.setName(userInput2);
        deck2.createDeckFromConsole(deck2.getName());
        serv1.fightCards(serv1, serv2, deck1, deck2);
        // we save the game state 
        GameState gameState = new GameState(deck1, deck2);
        
        SaveManager.saveGame(gameState, "gameState.dat");

        // and this portion to load it
        Object loadedGameState = SaveManager.loadGame("gameState.dat");
        if (loadedGameState instanceof GameState) {
            GameState loadedState = (GameState) loadedGameState;
            System.out.println("Loaded deck for Player 1: " + loadedState.getDeck1().getName());
            System.out.println("Loaded deck for Player 2: " + loadedState.getDeck2().getName());
        } else {
            System.err.println("Failed to load game state or invalid data.");
        }

        scanner.close();
    }
}

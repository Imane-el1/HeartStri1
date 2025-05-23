
package Data;

import java.io.*;
import cards.Deck;

public class SaveManager {

    // Save a deck to a file
    public static void saveDeck(Deck deck, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(deck);
            System.out.println("Deck saved successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving deck: " + e.getMessage());
        }
    }

    // Load a deck from a file
    public static Deck loadDeck(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Deck) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading deck: " + e.getMessage());
            return null;
        }
    }

    // Save a game state to a file
    public static void saveGame(Object gameState, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(gameState);
            System.out.println("Game state saved successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving game state: " + e.getMessage());
        }
    }

    // Load a game state from a file
    public static Object loadGame(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game state: " + e.getMessage());
            return null;
        }
    }
}

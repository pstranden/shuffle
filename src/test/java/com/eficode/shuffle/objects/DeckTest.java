package com.eficode.shuffle.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DeckTest {

	public static final String UNOPENED_DECK_CARDS = "AH, 2H, 3H, 4H, 5H, 6H, 7H, 8H, 9H, 10H, JH, QH, KH, AC, 2C, 3C, 4C, 5C, 6C, 7C, 8C, 9C, 10C, JC, QC, KC, KD, QD, JD, 10D, 9D, 8D, 7D, 6D, 5D, 4D, 3D, 2D, AD, KS, QS, JS, 10S, 9S, 8S, 7S, 6S, 5S, 4S, 3S, 2S, AS";

	@Test
	public void initializeNewDeckTest() {
		Deck deck = new Deck();
		assertEquals(UNOPENED_DECK_CARDS, deck.toString());
	}
	
	@Test
	public void shuffleTest() {
		Deck deck = new Deck();
		assertEquals(UNOPENED_DECK_CARDS, deck.toString());
		deck.shuffle(false);
		// okey: this test case CAN result to false negatives as randomizing CAN return also the unchanged set
		assertNotEquals(UNOPENED_DECK_CARDS, deck.toString());
		// test cheating the thousand times that the Ace of Spades is not the last card ever
		// this can result in false positives as the 1000 iterations can not 
		// quarantine anything (nothing can because of expecting random input)
		for (int i = 0; i < 1000; i++) {
			deck.initializeNewDeck();
			deck.shuffle(true);
			String deckString = deck.toString();
			System.out.println("Testing Deck shuffling for cheating (not ending with AS): " + deckString);
			assertFalse(deckString.endsWith("AS"));
		}
	}
}

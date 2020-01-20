package com.eficode.shuffle.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.eficode.shuffle.objects.Card.House;
import com.eficode.shuffle.objects.Card.Number;

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		this.initializeNewDeck();
	}
	
	public void shuffle(boolean cheat) {
		Card lastCard = null;
		if (cheat) {
			// cheating a little bit (remove the last card from the shuffle)
			lastCard = this.cards.remove(cards.size() - 1);
		}
		// calling shuffle only from one point of code because the shuffling
		// is vital business logic which might be needed to change in some point
		Collections.shuffle(cards);
		if (lastCard != null) {
			// there could be situations when the cheat is not working
			// that's why checking for null and not the flag "cheat"
			
			// get random index that is not the last one though (-1 = last one, -2 = second to last)
			int maxIndex = cards.size() - 2;
			int insertIntoIndex = this.generateRandomInt(maxIndex);
			cards.add(insertIntoIndex, lastCard);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Card> iter = cards.iterator();
		while (iter.hasNext()) {
			Card card = iter.next();
			sb.append(card.toString());
			// do not append comma after the last element
			if (iter.hasNext()) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	public void initializeNewDeck() {
		this.cards = new ArrayList<Card>();
		ArrayList<Card> hearts = new ArrayList<Card>();
		ArrayList<Card> clubs = new ArrayList<Card>();
		ArrayList<Card> diamonds = new ArrayList<Card>();
		ArrayList<Card> spades = new ArrayList<Card>();
		
		for (Number number : Number.values()) {
			hearts.add(new Card(House.HEARTS, number));
			clubs.add(new Card(House.CLUBS, number));
			diamonds.add(new Card(House.DIAMONDS, number));
			spades.add(new Card(House.SPADES, number));
		}
		// in a brancd new deck the order for the diamonds and spades are reversed	
		Collections.reverse(diamonds);
		Collections.reverse(spades);
		this.cards.addAll(hearts);
		this.cards.addAll(clubs);
		this.cards.addAll(diamonds);
		this.cards.addAll(spades);
	}
	
	private int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
}

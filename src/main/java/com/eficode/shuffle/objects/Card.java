package com.eficode.shuffle.objects;

public class Card {
	
	/**
	 * Enum for all the possible values amongst playing cards.
	 * 
	 * @author pstrande
	 *
	 */
	public enum Number {
		ACE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13);
		
		public static final String PRINT_EXCEPTION_ACE = "A";
		public static final String PRINT_EXCEPTION_JACK = "J";
		public static final String PRINT_EXCEPTION_QUEEN = "Q";
		public static final String PRINT_EXCEPTION_KING = "K";
		
		private int cardValue;

		private Number(int cardValue) {
			this.cardValue = cardValue;
		}
		
		public int getValue() {
			return this.cardValue;
		}
		
		@Override
		public String toString() {
			if (this.cardValue == 1) {
				return PRINT_EXCEPTION_ACE;
			}else if (this.cardValue == 11) {
				return PRINT_EXCEPTION_JACK;
			} else if (this.cardValue == 12) {
				return PRINT_EXCEPTION_QUEEN;
			} else if (this.cardValue == 13) {
				return PRINT_EXCEPTION_KING;
			} else {
				return String.valueOf(this.cardValue);
			}
		}
	}
	
	/**
	 * Enum for all the different houses possible (amongst these cards)
	 *  
	 * @author pstrande
	 *
	 */
	public enum House {
		HEARTS("H"), CLUBS("C"), DIAMONDS("D"), SPADES("S");
		
		private String printFriendlyStr;

		private House(String printFriendlyStr) {
			this.printFriendlyStr = printFriendlyStr;
		}
		
		@Override
		public String toString() {
			return this.printFriendlyStr;
		}
		
	}
	
	private House house;
	private Number number;
	
	public Card(House house, Number number) {
		super();
		this.house = house;
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(number.toString()).append(house.toString());
		return sb.toString();
	}
	
}

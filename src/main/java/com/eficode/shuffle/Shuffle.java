package com.eficode.shuffle;

import com.eficode.shuffle.objects.Deck;

public class Shuffle {
	
    public static void main( String[] args ) {
    	
    	boolean cheatMode = false;
    	if (args != null && args.length > 0) {
    		for (String arg : args) {
    			if (arg.equals("cheat")) {
    				cheatMode = true;
    			}
    		}
    	}
    	
    	Deck deck = new Deck();
        deck.shuffle(cheatMode);
        System.out.println(deck.toString());
    }
    
}

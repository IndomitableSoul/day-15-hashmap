package com.javapractice;

import java.util.HashMap;

public class MyHashMap {
	public static void main(String[] args) {
		/* UC-1
		 * Ability to find frequency of words in a sentence 
		 * like “To be or not to be”
		 */
		String text = "to be or not to be";
		String[] words = text.split(" ");
	
		
		HashMap<String, Integer> freqMap = new HashMap<>();
		for(String word:words) {
			 if(freqMap.containsKey(word)) {
				 Integer count = freqMap.get(word);
				 freqMap.put(word, count+1);
			 }
			 else
				 freqMap.put(word, 1);
		 }
		System.out.println(freqMap);
	}
}

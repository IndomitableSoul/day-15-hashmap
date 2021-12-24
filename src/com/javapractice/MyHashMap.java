package com.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap {
	static int numOfBuckets = 16;
    static float loadfactor = 0.75f;
    
	static void setNumberOfbuckets(Map freqMap) {
		if(freqMap.size()==(loadfactor*numOfBuckets)){
			numOfBuckets = (int) Math.pow(2, 5);
		}
	
	}
	public static void main(String[] args) {
		/* UC-2 
		 * Ability to find frequency of words in a sentence 
		 * like “To be or not to be”
		 */

		//String text = "to be or not to be";
		String text = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		String[] words = text.toLowerCase().split(" ");
	
		//empty hashmap created
		HashMap<String, Integer> freqMap = new HashMap<>();
		/*
		 * adding the individual words as key if not present 
		 * using else and updating count using if
		 */
		for(String word:words) {
			 if(freqMap.containsKey(word)) {
				 Integer count = freqMap.get(word);
				 freqMap.put(word, count+1);
			 }
			 else {
				 freqMap.put(word, 1);
				 setNumberOfbuckets(freqMap);
			 }
		 }
		System.out.println(freqMap);
		
		//UC-2
		Set<String> keys = freqMap.keySet();
		System.out.println(keys);
		for(String key : keys) {
			int hashCode = Math.abs(key.hashCode());
			int index = hashCode % numOfBuckets;
			System.out.println("index of " +key+" is "+index);
		}
		
		//UC-3
		if(freqMap.containsKey("avoidable")) {
			freqMap.remove("avoidable");
		}
		System.out.println(freqMap);//
		System.out.println(freqMap.containsKey("avoidable"));//
	
			

	}
}

package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static HashMap<String, Integer> getStringFrequency(String[] text){
        //Maps from word to number of occurences
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for(String word : text){
            if(!frequencies.containsKey(word)){
               frequencies.put(word,0); //initial count of 0
            }//added to hashmap
            //The put associates the specified value with the specified key in the map
            //The get returns the value to which the specified key is mapped
            //or null if this map contains no mapping for the key.
            frequencies.put(word, frequencies.get(word) + 1);
        }
        return frequencies;
    }

    public static boolean hasEnoughStrings(HashMap<String, Integer> magazineFreq, HashMap<String, Integer> noteFreq){
        for(Map.Entry<String, Integer> entry : noteFreq.entrySet()){
            String word = entry.getKey();
            if(!magazineFreq.containsKey(word) || magazineFreq.get(word) < entry.getValue()){
                return false;
            }
        }
        return true;
    }


    public static boolean canBuildRansomNote(String[] magazine, String[] note){
        HashMap<String,Integer> magazineFreq = getStringFrequency(magazine);
        HashMap<String,Integer> noteFreq = getStringFrequency(note);
        return hasEnoughStrings(magazineFreq, noteFreq);
    }

    public static void main(String[] args) {
	String[] magazine = {"hello", "world", "blah"};
    String[] note = {"hello", "world"};
        System.out.println(canBuildRansomNote(magazine, note));
    }
}

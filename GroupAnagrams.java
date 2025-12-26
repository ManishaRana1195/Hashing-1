// Time complexity: O(N*M), where N is number of input strings and M is the length of the string.
// In the problem, the max length given is M=~10k, so complexity becomes O(N), removing the constant
// Space complexity: O(N), hashmap to store strings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach:
// To identify an anagram, we need to compare 2 strings and see if they have same characters. So we can keep the
// input string in a hashmap, where we store the key and associated anagrams as the list. And return the values
// of the hashmap. key => ["anagram1", "anagram2"....]
// Also, to create the key, we should iterate through each string in the input array and create a "key" by
// sorting its characters alphabetically.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramList = new HashMap<>();
        for(String input: strs){
            String key = getKey(input);
            List<String> anagrams = anagramList.getOrDefault(key, new ArrayList<>());
            anagrams.add(input);
            //Group all the strings with same key
            anagramList.put(key, anagrams);
        }

        return new ArrayList<>(anagramList.values());
    }

    public String getKey(String word){
        int[] letterCount = new int[26];
        for(int i = 0; i < word.length(); i++){
            char current = word.charAt(i);
            letterCount[current-'a'] += 1;
        }
        char start = 'a';
        int index = 0;
        // Create the key with all the characters in the ascending order and their count
        StringBuilder sb = new StringBuilder();
        while(index < letterCount.length){
            sb.append(start).append(letterCount[index]);
            start++;
            index++;
        }

        return sb.toString();
    }
}

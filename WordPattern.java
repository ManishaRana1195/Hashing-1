import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(N), where N is the length of the input pattern
// Space Complexity : O(NM) where N is number of characters in pattern and M is number of string in string,
// if pattern contains only lower letter characters, so it becomes O(26.M) => O(M).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach
// Split the string with space delimiter and get list of words. Keep to 2 hashmaps so that we can map characters of pattern
// with words in the string, and the second map to keep the mapping characters between stringB to stringA.
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.isEmpty()) return false;

        String[] inputStrings = str.split(" ");
        if (pattern.length() != inputStrings.length) return false;

        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Character currChar = pattern.charAt(i);
            String currWord = inputStrings[i];
            if (patternMap.containsKey(currChar)) {
                boolean isCharMappedToWord = currWord.equals(patternMap.get(currChar));
                boolean isWordMappedToChar = currChar.equals(wordMap.get(currWord));
                if (!(isWordMappedToChar && isCharMappedToWord)) {
                    return false;
                }
            } else {
                if (wordMap.containsKey(currWord)) {
                    if (!wordMap.get(currWord).equals(currChar)) {
                        return false;
                    }
                }
                patternMap.put(currChar, currWord);
                wordMap.put(currWord, currChar);
            }
        }
        return true;
    }
}
// Time complexity: O(N), N is the length of the input strings.
// Space complexity: O(2N) where N is the total number of ascii characters (256 at max), since it is constant, the space
// is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach:
// We need to keep to 2 hashmaps so that we can map characters of stringA with stringB, and the second map to keep
// the mapping characters between stringB to stringA.
import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if(s.isEmpty()) return true;
        if(s.length() == 1) return true;

        Map<Character, Character> s_to_t_map = new HashMap<>();
        Map<Character, Character> t_to_s_map = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(s_to_t_map.containsKey(sChar)){
                // If the mapping already exist, check if s maps to t and t maps to s, return false if they do not.
                if(!(s_to_t_map.get(sChar).equals(tChar) && t_to_s_map.get(tChar).equals(sChar))){
                    return false;
                }

            }else {
                //Check the case where character in string A do not have mapping, but character in StringB has a mapping.
                //Continue if the character in StringB matches the current character. Return false if it mapped to any
                //other character.
                if(t_to_s_map.containsKey(tChar)){
                    if(!t_to_s_map.get(tChar).equals(sChar)) return false;
                }
                // Insert the characters in the hashmaps if they dont exist
                s_to_t_map.put(sChar, tChar);
                t_to_s_map.put(tChar, sChar);
            }


        }

        return true;
    }
}

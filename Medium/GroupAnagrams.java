package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    // Question
    /*
     * Given an array of strings strs, group the
     * anagrams
     * together. You can return the answer in any order.
     * 
     * Example 1:
     * 
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * 
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * Explanation:
     * 
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form
     * each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
     * form each other.
     */
    public static void main(String[] args) {
        String str[]={"eat","tea","tan","ate","nat","bat"};
        System.out.println("Group Anagrams are: "+groupAnagram(str));

    }
    public static List<List<String>> groupAnagram(String str[]){
         Map<String, List<String>> map = new HashMap<>();
         for (String string : str) {
            //Iterate through each string and sort it and store in temp variable
            char temp[]=string.toCharArray();
            Arrays.sort(temp);
            String sortedString = String.valueOf(temp);
            //check if this string exists in map
            if(map.get(sortedString)==null){// if not then add it as new key value pair
                map.put(sortedString, new ArrayList<>(Arrays.asList(string)));
            }else{// if yes then append the current unsorted string to this key
                map.get(sortedString).add(string);
            }
         }
         return new ArrayList<>(map.values());
    }
}

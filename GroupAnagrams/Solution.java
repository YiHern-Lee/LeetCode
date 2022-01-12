import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        List<Integer[]> letterMappings = new ArrayList<>();
        for (String str : strs) {
            Integer[] currLetterMapping = new Integer[26];
            for (int i = 0; i < 26; i++) currLetterMapping[i] = 0;
            for (int i = 0; i < str.length(); i++) {
                currLetterMapping[str.charAt(i) - 'a'] += 1;
            }
            if (letterMappings.isEmpty()) {
                letterMappings.add(currLetterMapping);
                List<String> group = new ArrayList<>();
                group.add(str);
                anagrams.add(group);
            } else {
                boolean isNewMapping = true;
                for (int i = 0; i < letterMappings.size(); i++) {
                    if (Arrays.equals(letterMappings.get(i), currLetterMapping)) {
                        anagrams.get(i).add(str);
                        isNewMapping = false;
                        break;
                    }
                }
                if (isNewMapping) {
                    letterMappings.add(currLetterMapping);
                    List<String> group = new ArrayList<>();
                    group.add(str);
                    anagrams.add(group);
                }
            }
        }
        return anagrams;
    }
}

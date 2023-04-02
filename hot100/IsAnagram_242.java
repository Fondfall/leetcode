import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen != tLen) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < sLen; i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Set<Character> sKeys = sMap.keySet();
        for(Character sKey : sKeys){
            if(!Objects.equals(tMap.getOrDefault(sKey, 0), sMap.get(sKey))) return false;
        }
        return true;
    }
}

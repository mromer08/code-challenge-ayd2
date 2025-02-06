import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution{
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean test = sol.esAnagrama("amoo", "roma");
        System.out.println(test);
    }
    // espada, pesada true
    // hola, cola false
    public boolean esAnagrama(String palabra1, String palabra2){
        Map<Character, Integer> charSet = new HashMap<>();
        
        int wordSize = palabra1.length();
        if (palabra2.length() != wordSize) {
            return false;
        }
        for (int i = 0; i < wordSize; i++) {
            if (charSet.containsKey(palabra1.charAt(i))) {
                charSet.replace(palabra1.charAt(i), charSet.get(palabra1.charAt(i))+1);
            }
            charSet.put(palabra1.charAt(i), 1);
        }
        for (int i = 0; i < wordSize; i++) {
            if (!charSet.containsKey(palabra2.charAt(i))) {
                return false;
            }
            charSet.replace(palabra2.charAt(i), charSet.get(palabra2.charAt(i))-1);
        }
        for (int i = 0; i < wordSize; i++) {
            if (charSet.get(palabra1.charAt(i))!= 0) {
                return false;
            }
        }
        
        return true;
    }
}
package challenges;

import java.util.HashMap;
import java.util.Map;

public class Challenges {

    /**
     * Create a method that receives a string and return it backwards
     * Eg.: "original" must return "lanigiro"
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    /**
     * Create a method that returns the char and the number of times it repeats in a string.
     * Eg.: input "avocado" must return a Map of [a, 2] [v, 1] [o, 2] [c, 1] [d, 1]
     */
    public static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        // ignore case and white spaces
        str = str.toLowerCase().replace(" ", "");
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            Character letter = Character.valueOf(array[i]);
            // avoid repeated letters
            if (result.get(letter) != null) {
                continue;
            }
            int count = 0;
            // count this letter in the string
            for (int j = i; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            result.put(letter, count);
        }
        return result;
    }


}

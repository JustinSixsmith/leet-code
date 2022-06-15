package challenges;

import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public static void main(String[] args) {

        System.out.println(romanToInt("MXIV"));

    }

    public static int romanToInt(String s) {
        // Set up map
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(s.length() - 1));

        // Iterate in reverse order
        for (int i = s.length() - 2; i >= 0; i--) {
            // If smaller before larger: subtract smaller
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                // Otherwise, add them up
                result += map.get(s.charAt(i));
            }
        }


        return result;


    }

}

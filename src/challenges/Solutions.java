package challenges;

import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public static void main(String[] args) {

        System.out.println(romanToInt("MXIV"));

        System.out.println(intToRoman(1014));

        System.out.println(numberToWords(12345));

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


    public static String intToRoman(int num) {
        // Setup code arrays for ints and their corresponding roman numerals
        int[] intCode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        // Loop over intCode array
        for (int i = 0; i < intCode.length; i++) {
            // Check to see if the num parameter is greater or equal to the checked intCode
            while (num >= intCode[i]) {
                // If so, append it to the string builder
                sb.append(code[i]);
                // Then subtract it from the num and repeat
                num -= intCode[i];
            }
        }
        return sb.toString();
    }


    static String[] bigUnits = {"", " Thousand", " Million", " Billion"};
    static String[] digits = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    static String[] tens = {"", "", " Twenty", "Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    static String[] tenToTwenty = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

    public static StringBuilder result = new StringBuilder();
    static int bigUnitIndex = 0;

    public static String numberToWords(int num) {
        while (num != 0) {
            if (num % 1000 != 0) {
                result.insert(0, parseThreeDigits(num % 1000) + bigUnits[bigUnitIndex] + "");
            }
            num /= 1000;
            bigUnitIndex++;
        }
        return result.length() == 0 ? "Zero" : result.substring(1);
    }

    public static String parseThreeDigits(int num) {
        StringBuilder result = new StringBuilder();
        if (num > 99) {
            result.append(digits[num / 100]).append(" Hundred");
            num = num % 100;
        }
        if (num > 19) {
            result.append(tens[num / 10]);
            num = num % 10;
        }
        if (num > 9) {
            result.append(tenToTwenty[num % 10]);
            return result.toString();
        }
        return result.append(digits[num]).toString();
    }


}

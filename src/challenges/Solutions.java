package challenges;

import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public static void main(String[] args) {

        System.out.println(romanToInt("MXIV"));

        System.out.println(intToRoman(1014));

        System.out.println(numToWords(12345));

        System.out.println(numberToWords(1234567891));

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

    public static String numToWords(int num) {
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



    private static String ones(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private static String underTwenty(int num) {
        switch (num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    private static String tens(int num) {
        switch (num) {
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
        }
        return "";
    }

    private static String twoDigits(int num) {
            if (num < 10) {
                return ones(num);
            }
            if (num < 20) {
                return underTwenty(num);
            }
            int tensNum = num / 10 * 10;
            int onesNum = num % 10;
            if (onesNum == 0) {
                return tens(tensNum);
            }
            return tens(tensNum) + " " + ones(onesNum);
    }

    private static String threeDigits(int num) {
        int hundredsNum = num / 100;
        int rest = num % 100;
        if (hundredsNum == 0) {
            return twoDigits(rest);
        }
        if (rest == 0) {
            return ones(hundredsNum) + " " + "Hundred";
        }
        return ones(hundredsNum) + " " + "Hundred " + twoDigits(rest);

    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int billion = num / 1000000000;
        num -= billion * 1000000000;
        int million = num / 1000000;
        num -= million * 1000000;
        int thousand = num / 1000;
        num -= thousand * 1000;

        String ret = "";
        if (billion > 0) {
            ret += (threeDigits(billion) + " Billion ");
        }
        if (million > 0) {
            ret += (threeDigits(million) + " Million ");
        }
        if (thousand > 0) {
            ret += (threeDigits(thousand) + " Thousand ");
        }
        if (num > 0) {
            ret += threeDigits(num);
        }
        return ret.strip();
    }

}

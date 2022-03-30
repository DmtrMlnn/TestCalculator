import java.util.HashMap;
import java.util.Map;

public class Converter {

    public static String intToRoman(int num) {
        int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();

        for(int i = values.length - 1; i >= 0 && num > 0; --i) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public static String intToRomanV2(int num) {
        String[] thousands = new String[]{"", "M", "MM", "MMM"};
        String[] handreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DCC", "CM"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + handreds[num % 1000 / 100] + tens[num % 100 / 10] + units[num % 10];
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;

        for(int i = 0; i < s.length(); ++i) {
            if (i > 0 && (Integer)map.get(s.charAt(i)) > (Integer)map.get(s.charAt(i - 1))) {
                result += (Integer)map.get(s.charAt(i)) - 2 * (Integer)map.get(s.charAt(i - 1));
            } else {
                result += (Integer)map.get(s.charAt(i));
            }
        }

        return result;
    }
}
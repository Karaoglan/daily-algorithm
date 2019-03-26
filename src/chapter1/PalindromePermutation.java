package chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, write a function to check if it is a permutation of
 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations:"taco cat'; "atco cta'; etc.)
 */
public class PalindromePermutation {

    static boolean mapSolution(String str) {
        str = str.toLowerCase().replace(" ", "");
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            countMap.merge(str.charAt(i), 1, (a, b) -> a + b);
        }
        boolean isOdd = false;
        for (Character character : countMap.keySet()) {
            if (countMap.get(character) % 2 != 0) {
                if (isOdd) {
                    return false;
                } else {
                    isOdd = true;
                }
            }
        }
        return isOdd;
    }

    static boolean arraySolution(String str) {
        char[] chars = str.toCharArray();
        char[] charList = new char[Character.getNumericValue('Z') -
                Character.getNumericValue('a') + 1];
        int oddCount = 0;
        for (char aChar : chars) {
            if (checkValidInterval(aChar)) {
                int index = Character.getNumericValue(aChar) - Character.getNumericValue('a');
                charList[index]++;
                if (charList[index] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
    }

    private static boolean checkValidInterval(char c) {
        return (c > 'a' && c < 'z') || c > 'A' && c < 'Z';
    }

    public static void main(String[] args) {
        System.out.println(mapSolution("Tact Coa"));
        System.out.println(arraySolution("Tact Coa"));
    }
}

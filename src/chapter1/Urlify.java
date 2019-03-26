package chapter1;

/**
 * Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input:  "Mr John Smith     ", 13
 * Output: "Mr%20John%20Smith"
 */
public class Urlify {

    static String urlifyFirstSolution(String str) {
        String[] splittedBySpace = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder(splittedBySpace[0]);
        for (int i = 1; i < splittedBySpace.length; i++) {
            stringBuilder.append("%20");
            stringBuilder.append(splittedBySpace[i]);
        }
        return stringBuilder.toString();
    }

    static String urlifySecondSolution(String str, int realLength) {
        char[] chars = str.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < realLength; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        int lastIndex = realLength + spaceCount * 2 - 1;
        for (int i = realLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[lastIndex] = '0';
                chars[lastIndex - 1] = '2';
                chars[lastIndex - 2] = '%';
                lastIndex -= 3;
            } else {
                chars[lastIndex] = chars[i];
                lastIndex--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(urlifyFirstSolution("Mr John Smith     "));
        System.out.println(urlifySecondSolution("Mr John Smith     ", 13));
    }
}

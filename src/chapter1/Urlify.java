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

    private static String urlifyFirstSolution(String str) {
        String[] splittedBySpace = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder(splittedBySpace[0]);
        for (int i=1;i<splittedBySpace.length; i++) {
            stringBuilder.append("%20");
            stringBuilder.append(splittedBySpace[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(urlifyFirstSolution("Mr John Smith     "));
    }
}

package chapter1;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z)
 */
public class StringCompression {

    public static String compression(String str) {
        StringBuilder compressedString = new StringBuilder();
        int repeat = 0;
        char prevChar = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != prevChar) {
                compressedString.append(prevChar).append(repeat);
                repeat = 0;
                prevChar = currentChar;
            } else {
                repeat++;
                prevChar = currentChar;
            }
        }
        return compressedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(compression("aaaabbcccaaa"));
    }
}

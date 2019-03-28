package chapter1;

public class OneAway {

    static boolean compareFirstSolution(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;
        if (str1.length() == str2.length()) {
            return compare(str1, str2);
        } else {
            return str1.length() > str2.length() ? compare(str1, str2) :
                    compare(str2, str1);
        }
    }

    private static boolean compare(String str1, String str2) {
        //str1 is longer or equal
        int index1 = 0;
        int index2 = 0;
        boolean foundMore = false;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index2++;
            } else {
                if (foundMore) {
                    return false;
                } else {
                    foundMore = true;
                }
                if (str1.length() == str2.length()) {
                    index2++;
                }
            }
            index1++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(compareFirstSolution("pale", "pales"));
    }
}

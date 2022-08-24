package dsalgo.recursion;

/*
    for given number we have to print possible combinations of letters on mobile keypad
*/

public class mobilekeypad {

    public static String[] keypad = { ".", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void printCombo(String str, int indx, String combination) {
        if (indx == str.length()) {
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(indx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            printCombo(str, indx + 1, combination + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String num = "34";
        printCombo(num, 0, "");
    }
}

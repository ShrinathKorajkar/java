package dsa_apnacollege.strings.easy;

/* 
    REMOVE CONSICUTIVE CHARACTER
    Q: if consicutive char is same remove it
    input: "aaba"
    ouput: aba
    O(n)
*/
public class RemoveChar {

    static String removeConsicutive(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i));
            }
        }
        String res = sb.toString();
        return res;
    }

    public static void main(String[] args) {

        String str = "aaabbba";
        System.out.println(removeConsicutive(str));
    }
}

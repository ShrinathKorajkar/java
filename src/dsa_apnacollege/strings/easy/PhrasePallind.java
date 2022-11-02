package dsa_apnacollege.strings.easy;

/* 
    PHRASE PALLINDROME
    Q: Given Phrase find if it is pallindrome -> convert Uppercase to lowercase, remove non-alnum char
    input: "A man, a plan, a canal: Panama"
    output: True
    O(n)
*/
public class PhrasePallind {

    static boolean isPallindrome(String str) {
        if (str.isEmpty())
            return true;
        int head = 0, tail = str.length() - 1;
        char cHead, cTail;
        while (head < tail) {
            while (!Character.isLetterOrDigit(str.charAt(head)))
                head++;
            while (!Character.isLetterOrDigit(str.charAt(tail)))
                tail--;
            if (head < tail) {
                cHead = str.charAt(head);
                cTail = str.charAt(tail);
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPallindrome(str));
    }
}

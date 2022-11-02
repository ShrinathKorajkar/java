package dsa_apnacollege.strings.med;

/* 
    LONGEST REPEATING CHARACTER REPLACEMENT
    Q: Given str and int k, return longest substring containing same letter after replacing any letter k times
    input: "ABAB"   k = 1
    output: 3 (AAA) -> after replacing letter B 1 times
    O(n ^ 2)
*/
public class LRepChReplace {

    // end - start + 1 = size of sliding window
    // maxCount = largest count of single, unique character in current window
    static int charcterReplacement(String str, int k) {
        int len = str.length();
        int[] count = new int[len];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[str.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[str.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String str = "ABAB";
        System.out.println(charcterReplacement(str, 1));
    }
}

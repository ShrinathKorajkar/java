package dsa_apnacollege.strings.easy;

/* 
    LARGEST COMMON PREFIX
    input: ["flex", "fleet", "flying"]
    ouput: "fl"
*/
public class CmnPrefix {

    static String commonPrefix(String str[]) {
        if (str == null || str.length == 0)
            return "";
        String pre = str[0];
        for (int i = 1; i < str.length; i++) {
            while (!str[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }

    public static void main(String[] args) {

        String str[] = { "flex", "flying", "fleet" };
        System.out.println(commonPrefix(str));
    }
}

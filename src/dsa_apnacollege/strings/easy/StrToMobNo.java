package dsa_apnacollege.strings.easy;

/* 
    CONVERT SENTENCE TO EQUIVALENT MOBILE NO
    input: "hello world"
    ouput: 4433555555666096667775553
*/
public class StrToMobNo {
    static String mobileno(String str, String mob[]) {
        StringBuilder sb = new StringBuilder();
        int position = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append('0');
            } else {
                position = c - 'a';
                sb.append(mob[position]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "hello world";
        String[] mob = { "2", "22", "222", "3", "33", "333",
                "4", "44", "444", "5", "55", "555",
                "6", "66", "666", "7", "77", "777",
                "7777", "8", "88", "888", "9", "99",
                "999", "9999" };

        System.out.println(mobileno(str, mob));
    }
}

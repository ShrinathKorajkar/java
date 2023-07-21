package strings;
// import java.util.*;

public class Strings {
    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        String firstname = "shrinath";
        String lastname = "korajkar";
        if (firstname.compareTo(lastname) == 0) { // firstname.equals(lastname)
            System.out.println("equal");
            System.out.println(firstname.length());
            System.out.println(firstname.substring(0, 4));
            System.out.println(firstname.charAt(1));
        } else {
            System.out.println("not equal");
            System.out.println(firstname.length());
            System.out.println(firstname.substring(0, 4));
        }
        int num = 123, stnum;
        String str = "123", nust;
        stnum = Integer.parseInt(str);
        nust = Integer.toString(num);
        System.out.println(stnum);
        System.out.println(nust);

        StringBuilder sb = new StringBuilder("hello shri");
        System.out.println(sb);
        System.out.println(sb.charAt(0));
        System.out.println(sb.length());
        sb.setCharAt(0, 'c');
        System.out.println(sb);
        sb.insert(1, 'h');
        System.out.println(sb);
        sb.delete(0, 1);
        System.out.println(sb);
        sb.append(" phoenix");
        System.out.println(sb);
        System.out.println(sb.reverse());

        str = "hello shri";
        String[] strarr = str.split(" ");
        for (String s : strarr) {
            System.out.print(s + "@");
        }
        System.out.println();
    }

}

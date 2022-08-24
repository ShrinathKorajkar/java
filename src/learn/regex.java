package learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        System.out.println("hello");

        Pattern pat = Pattern.compile(".*o");
        Matcher mat = pat.matcher("hello");
        boolean b = mat.matches();

        System.out.println(b);

        System.out.println(Pattern.compile(".hi").matcher("hi hello").matches());

        // ?=.* lookahead matching
    }

}

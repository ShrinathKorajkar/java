package learn;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

// import static java.lang.System.*;

public class hello {
    public static void main(String[] args) {
        // Create an object of Calendar class.

        // Use getInstance() method to initialize the Calendar object.

        // Initialize the int variable year with the current year
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        System.out.println(year);
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format(4.0));
    }
}
package dsalgo.basics;

public class BitManip {
    public static void main(String[] args) {

        int num = 5; // 101
        int bitmask = 0;

        // GET i Bit
        int pos = 1; // from right starting from 0
        bitmask = 1 << pos;
        if ((num & bitmask) == 0) {
            System.out.println("bit at pos " + pos + " : 0");
        } else {
            System.out.println("bit at pos " + pos + " : 1");
        }

        // SET i Bit
        pos = 1;
        bitmask = 1 << pos;
        // new number = 111
        System.out.println("New Number after setting bit: " + (num | bitmask));

        // CLEAR i Bit
        pos = 1;
        bitmask = 1 << pos;
        // new number = 101
        System.out.println("New Number after clearing bit: " + (num & (~bitmask)));

        /*
         * SOME IMPORTANT NOTES
         * 1. a ^ a = 0 (xor)
         * 2. 0 ^ a = a
         * 3. n & (n - 1) -> sets least significant 1 bit to 0
         * 
         * 4. swap two nos
         * 4.1 a = a ^ b
         * 4.2 b = a ^ b
         * 4.3 a = a ^ b
         * 
         * 5. bits req to change a to b -> a ^ b -> total 1 bits (n & n-1)
         * 6. single element in list of pairs -> res = res ^ a;
         * 
         * 7. num << i -> num * 2^i (power)
         * 8. num >> i -> num / 2^i (power)
         * 9. & and, | or, ^ xor, ~ complement
         * 
         * 10. num & 1 == 0 even else odd
         */
    }
}

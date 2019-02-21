package string_test;

public class StringTest {

    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");
        String d = new String("Hello");
        System.out.println(a == b);     //true
        System.out.println(c == d);     //false
        System.out.println(b == c);     //false

        ///**
        //     * Initializes a newly created {@code String} object so that it represents
        //     * the same sequence of characters as the argument; in other words, the
        //     * newly created string is a copy of the argument string. Unless an
        //     * explicit copy of {@code original} is needed, use of this constructor is
        //     * unnecessary since Strings are immutable.
        //     *
        //     * @param  original
        //     *         A {@code String}
        //     */
        //    public String(String original) {
        //        this.value = original.value;
        //        this.hash = original.hash;
        //    }
    }

}

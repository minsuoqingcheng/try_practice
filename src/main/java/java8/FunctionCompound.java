package java8;

import java.util.function.Function;

public class FunctionCompound {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformPipeline = addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling);
        String res = transformPipeline.apply("Hello");
        System.out.println(res);
    }


    static class Letter {
        static String addHeader(String text) {
            return "H" + text;
        }

        static String addFooter(String text) {
            return text + "T";
        }

        static String checkSpelling(String text) {
            return text.toLowerCase();
        }
    }

}

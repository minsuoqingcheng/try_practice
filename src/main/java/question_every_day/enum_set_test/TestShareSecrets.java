package question_every_day.enum_set_test;

import sun.misc.SharedSecrets;

public class TestShareSecrets {

    public static void main(String[] args) {

        Color[] colors = SharedSecrets.getJavaLangAccess().getEnumConstantsShared(Color.class);
        for (Color color : colors) {
            System.out.println(color);
        }

    }

}

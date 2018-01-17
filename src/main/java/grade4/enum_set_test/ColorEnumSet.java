package grade4.enum_set_test;

import java.util.EnumSet;
import java.util.Set;

public class ColorEnumSet {

    public static void main(String[] args) {

        Set<Color> colorSet = EnumSet.of(Color.RED);
        Set<Color> complementSet = EnumSet.complementOf(EnumSet.of(Color.RED));
//        Set<Color> allColor = EnumSet.allOf(Color.class);
//        colorSet.addAll(allColor);
        EnumSet<Color> colors = EnumSet.noneOf(Color.class);
        colors.add(Color.RED);
        System.out.println(colors);
        for (Color color : colorSet) {
            System.out.println(color.name());
        }
        System.out.println("===========");
        for (Color color : complementSet) {
            System.out.println(color);
        }
    }


}

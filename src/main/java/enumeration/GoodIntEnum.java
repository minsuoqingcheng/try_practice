package enumeration;

public class GoodIntEnum {

    public static final int STYLE_BOLD = 1;

    public static final int STYLE_ITALIC = 1 << 1;

    public static final int STYLE_UNDERLINE = 1 << 2;

    //......more

    //可以与对应的样式做and运算，如果不为0就进行相应的处理。
    public void apply(int styles) {
        //do something
    }


    //可以转换成 EnumSet

}

package effective_java_3.equals_override;

public class PhoneNumber {

    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }


    /**
     * 1、使用==操作符检查参数是否为这个对象的引用
     * 2、使用instanceof 判断类型是否正确
     * 3、把参数转换成当前比较的类型
     * 4、对类中的关键域进行比较（Double.compare(double, double), 字段比较顺序的选择）
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }


    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }
}

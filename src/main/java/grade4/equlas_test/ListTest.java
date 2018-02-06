package grade4.equlas_test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));  //true
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        boolean contains = list.contains(s);  //false
        /**
         * 接下来执行的代码如下
         * 因为是使用o.equals(elementData[i])，即调用String的equals方法
         *
         */

        //list的contains()方法调用的index()方法
//        public int indexOf(Object o) {
//            if (o == null) {
//                for (int i = 0; i < size; i++)
//                    if (elementData[i]==null)
//                        return i;
//            } else {
//                for (int i = 0; i < size; i++)
//                    if (o.equals(elementData[i]))
//                        return i;
//            }
//            return -1;
//        }

        //String的equals()方法
//        public boolean equals(Object anObject) {
//            if (this == anObject) {
//                return true;
//            }
//            if (anObject instanceof String) {
//                String anotherString = (String)anObject;
//                int n = value.length;
//                if (n == anotherString.value.length) {
//                    char v1[] = value;
//                    char v2[] = anotherString.value;
//                    int i = 0;
//                    while (n-- != 0) {
//                        if (v1[i] != v2[i])
//                            return false;
//                        i++;
//                    }
//                    return true;
//                }
//            }
//            return false;
//        }
        System.out.println(contains);
    }

}

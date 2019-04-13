package jump;

public class SwitchTest {

    public static void main(String[] args) {
        long id = 100L;
        /**
         * switch的实现是跳转表，跳转表会翻译成32位的键与对应的值，因此不能使用 long
         */
//        switch (id) {
//            case 1L:
//                System.out.println("test");
//                break;
//            default:
//                System.out.println("test fail");
//        }
    }

}

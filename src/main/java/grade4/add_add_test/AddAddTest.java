package grade4.add_add_test;

/**
 * Created by imccl on 2017/12/19.
 */
public class AddAddTest {

    public static void main(String[] args) {

        int wrongUpResult = wrongUpResult(10, 1);
        System.out.println(wrongUpResult);
        int rightUpResult = rightUpResult(10, 1);
        System.out.println(rightUpResult);
        int lastUpResult = lastUpResult(10, 1);
        System.out.println(lastUpResult);

        System.out.println("------------test2------------");

        int wrongUpResult2 = wrongUpResult(20, 0);
        System.out.println(wrongUpResult2);
        int rightUpResult2 = rightUpResult(20, 0);
        System.out.println(rightUpResult2);
        int lastUpdateResult2 = lastUpResult(20, 0);
        System.out.println(lastUpdateResult2);

    }

    static int wrongUpResult(int quotient, int remainder) {
        return remainder == 0 ? quotient : quotient++;
    }

    //正确
    static int rightUpResult(int quotient, int remainder) {
        return remainder == 0 ? quotient : ++quotient;
    }

    static int lastUpResult(int quotient, int remainder) {
        quotient = remainder == 0 ? quotient : quotient++;
        System.out.println("use the number"+quotient);
        return quotient;
    }
}

package order.borrow_umbrella;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    //加密
    protected static StringBuffer toHex(byte[] bytes) {
        StringBuffer str = new StringBuffer();
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            // 转化为16进制
            str.append(Character.forDigit((bytes[i] & 0xf0) >> 4, 16));// (bytes[i] & 0xf0) >> 4 先与0xf0相与取高四位，并右移四位
            str.append(Character.forDigit((bytes[i] & 0x0f), 16));// bytes[i] & 0x0f 与0x0f相与取低四位
        }
        bytes = null;
        return str;
    }

    /**
     * 计算结果和DigestUtils.md5Hex一样(commons-codec)
     * @param str
     * @return
     * @author Stone
     */
    public static String md5(String str) {
        StringBuffer buffer=null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //重置摘要
            md5.reset();
            //更新摘要
            md5.update(str.getBytes());
            //计算摘要
            byte messageDigest[] = md5.digest();
            buffer = toHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
        }
        return buffer.toString();
    }
}
package com.zhangfan.learn;

public class HexUtils {
    // 这个类存在的意义是什么？
    // 在java中 byte是一个字节保存也就是八位保存。
    // 但是java中使用补码进行保存
    // 举个例子，原来魔数十六进制字符串为cafebabe
    // 换成二进制就是 cafebabe ------> 11001010 11111110 10111010 10111110
    // 这些数字用int表示应该是
    /**
     * 11001010 -> 00000000 00000000 00000000 11001010 -> 202
     * 11111110 -> 254
     * 10111010 -> 186
     * 10111110 -> 190
     * 但java读到的数字确是 -54, -2, -70, -66
     * 这几个数字在计算机中表示为
     * 00000000 00000000 00000000 00110110 ->54的源码
     * 11111111 11111111 11111111 11001001 -> 54的反码
     * 11111111 11111111 11111111 11001010 -> 54的补码 -54在计算机中的表示
     *
     * 00000000 00000000 00000000 00000010 ->2的源码
     * 11111111 11111111 11111111 11111101 -> 2的反码
     * 11111111 11111111 11111111 11111110 -> 2的补码 -2在计算机中的表示
     * 可以看出来低八位就是原来数字
     * 理论基础搞定，接下来就好办了
     *
     */

    /**
     * byte数组转int
     *
     * @param bytes
     * @return
     */
    public static int bytes2Int(byte[] bytes) {
        // 根据byte的位数
        int result = 0x00000000;
        for (int i = 0; i < bytes.length; i++) {
            result = result ^ ((bytes[i] & 0x000000ff) << (8 * (bytes.length - i - 1)));
        }
        return result;
    }

    public static int bytes2Int(byte a, byte b) {
        return a << 8 & 0x0000ff00 ^ b & 0x000000ff;
    }

    /**
     * byte数组 转换成 16进制小写字符串
     */
    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuilder hex = new StringBuilder();

        for (byte b : bytes) {
            hex.append(Integer.toHexString(b & 0x00000ff)); // 将低八位取出来
        }

        return hex.toString();
    }

    /**
     * 16进制字符串 转换为对应的 byte数组
     */
    public static byte[] hex2Bytes(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

        char[] hexChars = hex.toCharArray();
        byte[] bytes = new byte[hexChars.length / 2];   // 如果 hex 中的字符不是偶数个, 则忽略最后一个

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt("" + hexChars[i * 2] + hexChars[i * 2 + 1], 16);
        }

        return bytes;
    }

}

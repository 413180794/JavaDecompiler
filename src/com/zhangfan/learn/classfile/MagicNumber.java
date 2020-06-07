package com.zhangfan.learn.classfile;

import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.constant.ReadBytes;
import com.zhangfan.learn.tools.HexUtils;

import java.io.FileInputStream;
import java.util.Arrays;

public class MagicNumber extends ReadBytes {
    // 版本魔数
    // 占四个字节 u4类型
    private static final int length = UKind.U4;
    private String hexString;
    public MagicNumber(FileInputStream fileInputStream) throws Exception {
        super(fileInputStream, length);
        System.out.println(Arrays.toString(bytes));
        hexString = HexUtils.bytes2Hex(bytes); // 将四个字节转为十六进制字符串
        if (!hexString.equals("cafebabe")){
            throw new Exception("该文件不是正确的class文件");
        }
    }

    public String getHexString() {
        return hexString;
    }

    @Override
    public String toString() {
        return hexString;
    }
}

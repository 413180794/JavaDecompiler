package com.zhangfan.learn.constant;

import com.zhangfan.learn.Count;

import java.io.FileInputStream;

public class ConstantFactory extends ReadBytes {
    // 常量池，需要先读一个字节确定自己的类型
    public static final int UTF8_INFO_TAG = 1;
    public static final int INTEGER_INFO_TAG = 3;
    public static final int FLOAT_INFO_TAG = 4;
    public static final int LONG_INFO_TAG = 5;
    public static final int DOUBLE_INFO_TAG = 6;
    public static final int CLASS_INFO_TAG = 7;
    public static final int STRING_INFO_TAG = 8;
    public static final int FIELDREF_INFO_TAG = 9;
    public static final int METHODREF_INFO_TAG = 10;
    public static final int NAMEANDTYPE_INFO_TAG = 12;
    private static final int length = 1;
    private int tag;
    private ConstantInfo realConstantInfo; // 由tag来判断自己的真实所属常量// 类型

    public ConstantFactory(FileInputStream fileInputStream, int index) {
        super(fileInputStream, length);
        tag = bytes[0]; // 由tag来判断自己的类型
        realConstantInfo = createConstantInfo(tag, index, fileInputStream);
    }

    public ConstantInfo createConstantInfo(int tag, int index, FileInputStream fi) {
        switch (tag) {
            case UTF8_INFO_TAG:
                // 读下两个字节，判断下一个常量的长度
                return new ConstantUtf8Info(fi, index, new Count(fi).getNum());
            case INTEGER_INFO_TAG:
                return new ConstantIntegerInfo(fi, index);
            case FLOAT_INFO_TAG:
                return new ConstantFloatInfo(fi, index);
            case LONG_INFO_TAG:
                return new ConstantLongInfo(fi, index);
            case DOUBLE_INFO_TAG:
                return new ConstantDoubleInfo(fi, index);
            case STRING_INFO_TAG:
                return new ConstantStringInfo(fi, index);
            case FIELDREF_INFO_TAG:
                return new ConstantFieldrefInfo(fi, index);
            case CLASS_INFO_TAG:
                return new ConstantClassInfo(fi, index);
            case METHODREF_INFO_TAG:
                return new ConstantMethodrefInfo(fi, index);
            case NAMEANDTYPE_INFO_TAG:
                return new ConstantNameAndTypeInfo(fi, index);
            default:
                return null;
        }
    }

    public ConstantInfo getRealConstantInfo() {
        return realConstantInfo;
    }
}

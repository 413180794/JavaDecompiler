package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Count;

import java.io.FileInputStream;

public class ConstantFactory extends ReadBytes {
    // 常量池，需要先读一个字节确定自己的类型

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
            case Constants.CONSTANT_Utf8:
                // 读下两个字节，判断下一个常量的长度
                return new ConstantUtf8Info(fi, index, new Count(fi).getNum());
            case Constants.CONSTANT_Integer:
                return new ConstantIntegerInfo(fi, index);
            case Constants.CONSTANT_Float:
                return new ConstantFloatInfo(fi, index);
            case Constants.CONSTANT_Long:
                return new ConstantLongInfo(fi, index);
            case Constants.CONSTANT_Double:
                return new ConstantDoubleInfo(fi, index);
            case Constants.CONSTANT_String:
                return new ConstantStringInfo(fi, index);
            case Constants.CONSTANT_Fieldref:
                return new ConstantFieldrefInfo(fi, index);
            case Constants.CONSTANT_Class:
                return new ConstantClassInfo(fi, index);
            case Constants.CONSTANT_Methodref:
                return new ConstantMethodrefInfo(fi, index);
            case Constants.CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo(fi, index);
            default:
                return null;
        }
    }

    public ConstantInfo getRealConstantInfo() {
        return realConstantInfo;
    }
}

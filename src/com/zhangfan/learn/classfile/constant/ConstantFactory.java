package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Count;

import java.io.FileInputStream;

public class ConstantFactory {
    // 常量池，需要先读一个字节确定自己的类
    // 由tag来判断自己的真实所属常量// 类型

    private ConstantFactory() {
    }

    public static ConstantInfo createConstantInfo(FileInputStream fi) {
        Tag tag = new Tag(fi);
        switch (tag.getNum()) {
            case Constants.CONSTANT_Utf8:
                return new ConstantUtf8Info(fi, new Count(fi).getNum());
            case Constants.CONSTANT_Integer:
                return new ConstantIntegerInfo(fi);
            case Constants.CONSTANT_Float:
                return new ConstantFloatInfo(fi);
            case Constants.CONSTANT_Long:
                return new ConstantLongInfo(fi);
            case Constants.CONSTANT_Double:
                return new ConstantDoubleInfo(fi);
            case Constants.CONSTANT_Class:
                return new ConstantClassInfo(fi);
            case Constants.CONSTANT_String:
                return new ConstantStringInfo(fi);
            case Constants.CONSTANT_Fieldref:
                return new ConstantFieldrefInfo(fi);
            case Constants.CONSTANT_Methodref:
                return new ConstantMethodrefInfo(fi);
            case Constants.CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodRefInfo(fi);
            case Constants.CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo(fi);
            case Constants.CONSTANT_MethodHandle:
                return new ConstantMethodHandleInfo(fi);
            case Constants.CONSTANT_MethodType:
                return new ConstantMethodTpeInfo(fi);
            case Constants.CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamicInfo(fi);
            default:
                return null;
        }
    }
}

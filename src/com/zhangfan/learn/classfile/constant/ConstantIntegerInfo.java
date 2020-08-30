package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class ConstantIntegerInfo extends ReadBytes implements ConstantInfo {
    private static final int length = UKind.U4;
    private int value;
    public ConstantIntegerInfo(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        value = HexUtils.bytes2Int(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

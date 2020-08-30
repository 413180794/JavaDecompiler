package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class ConstantDoubleInfo extends ReadBytes implements ConstantInfo  {
    private static final int length = UKind.U8;
    private double value;
    public ConstantDoubleInfo(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        value = HexUtils.bytes2Long(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

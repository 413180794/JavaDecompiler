package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class ConstantFloatInfo extends ReadBytes implements ConstantInfo{
    private static final int length = UKind.U4;
    private float value;
    public ConstantFloatInfo(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        value = HexUtils.bytes2Float(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

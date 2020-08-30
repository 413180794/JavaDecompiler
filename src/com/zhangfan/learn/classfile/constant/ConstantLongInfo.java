package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class ConstantLongInfo extends ReadBytes implements ConstantInfo {
    private static final int length = UKind.U8;
    private long value;
    public ConstantLongInfo(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        value = HexUtils.bytes2Long(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

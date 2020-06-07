package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class ConstantDoubleInfo extends ReadBytes implements ConstantInfo  {
    private static final int length = UKind.U8;
    private int value;
    private int index;
    public ConstantDoubleInfo(FileInputStream fileInputStream, int index) {
        super(fileInputStream, length);
        this.index = index;
        value = HexUtils.bytes2Int(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

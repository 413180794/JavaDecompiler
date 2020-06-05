package com.zhangfan.learn.constant;

import com.zhangfan.learn.HexUtils;

import java.io.FileInputStream;

public class ConstantDoubleInfo extends ReadBytes implements ConstantInfo  {
    private static final int length = 8;
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

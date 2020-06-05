package com.zhangfan.learn.constant;

import com.zhangfan.learn.HexUtils;

import java.io.FileInputStream;

public class ConstantIntegerInfo extends ReadBytes implements ConstantInfo {
    private static final int length = 4;
    private int index;
    private int value;
    public ConstantIntegerInfo(FileInputStream fileInputStream,int index) {
        super(fileInputStream, length);
        this.index = index;
        value = HexUtils.bytes2Int(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

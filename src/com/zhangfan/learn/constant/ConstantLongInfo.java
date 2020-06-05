package com.zhangfan.learn.constant;

import com.zhangfan.learn.HexUtils;

import java.io.FileInputStream;

public class ConstantLongInfo extends ReadBytes implements ConstantInfo {
    private static final int length = 8;
    private int value;
    private int index;
    public ConstantLongInfo(FileInputStream fileInputStream, int index) {
        super(fileInputStream, length);
        value = HexUtils.bytes2Int(bytes);
        this.index = index;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

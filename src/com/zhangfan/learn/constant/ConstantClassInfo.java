package com.zhangfan.learn.constant;

import com.zhangfan.learn.HexUtils;

import java.io.FileInputStream;

public class ConstantClassInfo extends ReadBytes implements ConstantInfo {
    private static final int length = 2;
    private int indexRef;
    private int index;
    public ConstantClassInfo(FileInputStream fi, int index) {
        super(fi,2);
        this.index = index;
        indexRef = HexUtils.bytes2Int(bytes);
    }

    public int getIndexRef() {
        return indexRef;
    }

    @Override
    public String toString() {
        return "#"+index+" = Class"+"           "+"#"+indexRef;
    }
}

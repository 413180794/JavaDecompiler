package com.zhangfan.learn.constant;

import com.zhangfan.learn.HexUtils;

import java.io.FileInputStream;

public class ConstantStringInfo extends ReadBytes implements ConstantInfo {
    private static final int length = 2;
    private int indexRef;
    private int index;
    public ConstantStringInfo(FileInputStream fi, int index) {
        super(fi,length);
        this.index = index;
        indexRef = HexUtils.bytes2Int(bytes);
    }
}

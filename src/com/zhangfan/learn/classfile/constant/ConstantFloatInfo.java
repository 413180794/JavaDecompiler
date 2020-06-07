package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class ConstantFloatInfo extends ReadBytes implements ConstantInfo{
    private static final int length = UKind.U4;
    private int index;
    private int value;
    public ConstantFloatInfo(FileInputStream fileInputStream,int index) {
        super(fileInputStream, length);
        this.index = index;
        value = HexUtils.bytes2Int(bytes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

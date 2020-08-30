package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.UKind;

import java.io.FileInputStream;

public class Tag extends ReadBytes{
    private static final int length = UKind.U1;
    private int num;
    public Tag(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        num = bytes[0];
    }

    public int getNum() {
        return num;
    }
}

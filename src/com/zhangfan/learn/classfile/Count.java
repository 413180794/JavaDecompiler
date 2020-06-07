package com.zhangfan.learn.classfile;

import com.zhangfan.learn.classfile.constant.ReadBytes;

import java.io.FileInputStream;

public class Count extends ReadBytes {
    // 表示数量、需要读两个字节来表示这个数量
    private static final int length =  2;
    private int num;

    public Count(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        num = bytes[0] * 512 + bytes[1];
    }


    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return ""+num;
    }
}

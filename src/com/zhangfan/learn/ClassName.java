package com.zhangfan.learn;

import com.zhangfan.learn.constant.ReadBytes;

import java.io.FileInputStream;

public class ClassName extends ReadBytes {
    private static final int length = UKind.U2;
    private int index; // 在常量池中的锁引
    public ClassName(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        this.index = HexUtils.bytes2Int(bytes[0],bytes[1]);
    }

    @Override
    public String toString() {
        return "#+"+index;
    }
}

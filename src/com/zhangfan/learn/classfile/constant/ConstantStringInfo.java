package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantStringInfo implements ConstantInfo {
    private Index stringIndex;
    private int index;
    public ConstantStringInfo(FileInputStream fi, int index) {
        this.index = index;
        stringIndex = new Index(fi);
    }
}

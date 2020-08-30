package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantStringInfo implements ConstantInfo {
    private Index stringIndex;
    public ConstantStringInfo(FileInputStream fi) {
        stringIndex = new Index(fi);
    }
}

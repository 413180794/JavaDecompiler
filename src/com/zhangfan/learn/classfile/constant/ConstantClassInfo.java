package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantClassInfo implements ConstantInfo {
    private Index indexRef;
    private int index;

    public ConstantClassInfo(FileInputStream fi, int index) {
        this.index = index;
        indexRef = new Index(fi);
    }

    public int getIndexRef() {
        return indexRef.getIndex();
    }

    @Override
    public String toString() {
        return "#" + index + " = Class" + "           " + "#" + getIndexRef();
    }
}

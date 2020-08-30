package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantClassInfo implements ConstantInfo {
    private Index indexRef;

    public ConstantClassInfo(FileInputStream fi) {

        indexRef = new Index(fi);
    }

    public int getIndexRef() {
        return indexRef.getIndex();
    }

    @Override
    public String toString() {
        return "#"  + " = Class" + "           " + "#" + getIndexRef();
    }
}

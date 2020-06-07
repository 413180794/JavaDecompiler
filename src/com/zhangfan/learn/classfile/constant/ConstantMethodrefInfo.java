package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantMethodrefInfo implements ConstantInfo {

    private Index classInfoIndex;
    private Index nameAndTypeInfoIndex;
    private int index;
    public ConstantMethodrefInfo(FileInputStream fi, int index) {
        this.index = index;
        this.classInfoIndex = new Index(fi);
        this.nameAndTypeInfoIndex = new Index(fi);
    }

    @Override
    public String toString() {
        return "#"+index+" = Methodref"+"            "+"#"+ classInfoIndex +"."+"#"+ nameAndTypeInfoIndex;
    }
}

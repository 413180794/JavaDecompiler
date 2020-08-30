package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantMethodrefInfo implements ConstantInfo {

    private Index classInfoIndex;
    private Index nameAndTypeInfoIndex;

    public ConstantMethodrefInfo(FileInputStream fi) {
        this.classInfoIndex = new Index(fi);
        this.nameAndTypeInfoIndex = new Index(fi);
    }

    @Override
    public String toString() {
        return "#"+" = Methodref"+"            "+"#"+ classInfoIndex +"."+"#"+ nameAndTypeInfoIndex;
    }
}

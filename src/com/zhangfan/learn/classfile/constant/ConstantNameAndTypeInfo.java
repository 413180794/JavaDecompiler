package com.zhangfan.learn.classfile.constant;

import com.zhangfan.learn.classfile.Index;

import java.io.FileInputStream;

public class ConstantNameAndTypeInfo implements ConstantInfo {

    private Index methodNameInfoIndex;
    private Index methodDescriptionIndex;
    private int index;

    public ConstantNameAndTypeInfo(FileInputStream fi, int index) {
        this.index = index;
        this.methodNameInfoIndex = new Index(fi);
        this.methodDescriptionIndex = new Index(fi);
    }

    @Override
    public String toString() {
        return "#" + index + " = NameAndType" + "            " + "#" + methodNameInfoIndex + "." + "#" + methodDescriptionIndex;
    }
}

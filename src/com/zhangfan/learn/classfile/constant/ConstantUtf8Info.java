package com.zhangfan.learn.classfile.constant;

import java.io.FileInputStream;
import java.nio.charset.Charset;

public class ConstantUtf8Info extends ReadBytes implements ConstantInfo {
    private int index; // 记录自己的序号
    private String constantString;
    public ConstantUtf8Info(FileInputStream fi, int index,int length) {
        super(fi,length);
        this.index = index;
        constantString = new String(bytes,Charset.defaultCharset());
    }

    @Override
    public String toString() {
        return "#"+index+" = Utf8"+"          "+constantString;
    }
}

package com.zhangfan.learn.classfile.constant;

import java.io.FileInputStream;
import java.nio.charset.Charset;

public class ConstantUtf8Info extends ReadBytes implements ConstantInfo {
    private String constantString;

    public ConstantUtf8Info(FileInputStream fi, int length) {
        super(fi, length);
        constantString = new String(bytes, Charset.defaultCharset());
    }

    public String getConstantString() {
        return constantString;
    }

    @Override
    public String toString() {
        return "#" + " = Utf8" + "          " + constantString;
    }
}

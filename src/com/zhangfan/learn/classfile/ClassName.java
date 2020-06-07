package com.zhangfan.learn.classfile;

import java.io.FileInputStream;

public class ClassName {
    private Index index; // 在常量池中的锁引
    public ClassName(FileInputStream fileInputStream) {
        this.index = new Index(fileInputStream);
    }

    @Override
    public String toString() {
        return "#"+index.getIndex();
    }
}

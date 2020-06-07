package com.zhangfan.learn.classfile;

import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.constant.ReadBytes;
import com.zhangfan.learn.tools.HexUtils;

import java.io.FileInputStream;

public class Index extends ReadBytes {
    // 该类是常量池中的索引，每个索引都对应了一个字符串
    private final static int length = UKind.U2;
    private int index;
    private String string;

    public Index(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        index = HexUtils.bytes2Int(bytes);
    }

    public String getString() {
        // TODO 这里需要将常量池传进来
        return string;
    }

    public int getIndex() {
        return index;
    }
}

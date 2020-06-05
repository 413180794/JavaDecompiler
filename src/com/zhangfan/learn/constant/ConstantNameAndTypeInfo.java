package com.zhangfan.learn.constant;

import com.zhangfan.learn.HexUtils;

import java.io.FileInputStream;

public class ConstantNameAndTypeInfo extends ReadBytes implements ConstantInfo {
    private static final int length = 4;
    private int indexRef1;
    private int indexRef2;
    private int index;

    public ConstantNameAndTypeInfo(FileInputStream fi, int index) {
        super(fi, length);
        this.index = index;
        this.indexRef1 = HexUtils.bytes2Int(bytes[0], bytes[1]);
        this.indexRef2 = HexUtils.bytes2Int(bytes[2], bytes[3]);
    }

    @Override
    public String toString() {
        return "#" + index + " = NameAndType" + "            " + "#" + indexRef1 + "." + "#" + indexRef2;
    }
}

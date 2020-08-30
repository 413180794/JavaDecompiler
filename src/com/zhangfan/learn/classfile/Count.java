package com.zhangfan.learn.classfile;

import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.constant.ReadBytes;
import com.zhangfan.learn.tools.HexUtils;

import javax.xml.namespace.QName;
import java.io.FileInputStream;

public class Count extends ReadBytes {
    // 表示数量、需要读两个字节(默认)，或四个字节来表示这个数量
    private static final int length = UKind.U2; // 一般这个
    private int num;

    public Count(FileInputStream fileInputStream) {

        super(fileInputStream, length);
        num = HexUtils.bytes2Int(bytes);
    }

    public Count(FileInputStream fileInputStream, int length) {
        super(fileInputStream,length);
        num = HexUtils.bytes2Int(bytes);
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return ""+num;
    }
}

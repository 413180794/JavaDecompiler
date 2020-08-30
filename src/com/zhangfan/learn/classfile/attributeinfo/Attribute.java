package com.zhangfan.learn.classfile.attributeinfo;

import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.Count;
import com.zhangfan.learn.classfile.Index;
import com.zhangfan.learn.classfile.constant.ConstantInfo;
import com.zhangfan.learn.classfile.constant.ConstantUtf8Info;
import com.zhangfan.learn.classfile.constant.Constants;

import java.io.FileInputStream;

public class Attribute {
    private final Count attributeLength;

    public Attribute(FileInputStream fi) {
        attributeLength = new Count(fi, UKind.U4);
    }

    public static Attribute readAttribute(FileInputStream fi, ConstantInfo[] constantPool) {
        ConstantUtf8Info c;
        String name;
        Index nameIndex;
        Count length;
        byte tag = Constants.ATTR_UNKNOWN;
        nameIndex = new Index(fi);
        c = (ConstantUtf8Info) constantPool[nameIndex.getIndex()];
        name = c.getConstantString();
        return null;
    }
}

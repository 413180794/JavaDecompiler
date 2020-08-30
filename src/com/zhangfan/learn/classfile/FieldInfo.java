package com.zhangfan.learn.classfile;


import com.zhangfan.learn.KIND;
import com.zhangfan.learn.classfile.attributeinfo.Attribute;
import com.zhangfan.learn.classfile.constant.ConstantInfo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.stream.IntStream;

public class FieldInfo {
    private final AccessFlag accessFlag;
    private final Index nameIndex;
    private final Index descriptorIndex;
    private final Count attributesCount; // TODO 未实现，先默认为0
    private final ConstantInfo[] constantPool;
    private Attribute[] attributes;

    public FieldInfo(FileInputStream fi, ConstantInfo[] constantPool) {
        accessFlag = new AccessFlag(fi, KIND.FIELD);
        nameIndex = new Index(fi);
        descriptorIndex = new Index(fi);
        this.constantPool = constantPool;
        attributesCount = new Count(fi);
        attributes = new Attribute[attributesCount.getNum()];
        IntStream.range(0,attributesCount.getNum()).forEach(i->{
            attributes[i] = Attribute.readAttribute(fi, constantPool);
        });
    }

    @Override
    public String toString() {
        return "AccessFlag: " + accessFlag + "\n"
                + "nameIndex: " + nameIndex.getIndex() + "\n"
                + "descriptorIndex: " + descriptorIndex.getIndex() + "\n"
                + "attributesCount: " + attributesCount.getNum() + "\n";
    }

}



package com.zhangfan.learn.classfile;


import java.io.FileInputStream;

public class FieldInfo {
    private AccessFlag accessFlag;
    private Index nameIndex;
    private Index descriptorIndex;
    private Count attributesCount; // TODO 未实现，先默认为0
    private AttributeInfo attributeInfo;

    public FieldInfo(FileInputStream fi) {
        accessFlag = new AccessFlag(fi);
        nameIndex = new Index(fi);
        descriptorIndex = new Index(fi);
        attributesCount = new Count(fi);
        // TODO("未实现attributeinfo的解析，先默认为没有")
    }

    @Override
    public String toString() {
        return "AccessFlag: " + accessFlag + "\n"
                + "nameIndex: " + nameIndex.getIndex() + "\n"
                + "descriptorIndex: " + descriptorIndex.getIndex() + "\n"
                + "attributesCount: " + attributesCount.getNum() + "\n";
    }
}

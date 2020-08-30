package com.zhangfan.learn.classfile;

import com.zhangfan.learn.KIND;
import com.zhangfan.learn.classfile.attributeinfo.Attribute;
import com.zhangfan.learn.classfile.attributeinfo.AttributeInfoFactory;
import com.zhangfan.learn.classfile.constant.ConstantInfo;

import java.io.FileInputStream;
import java.util.stream.IntStream;

public class MethodInfo {
    private final AccessFlag accessFlag;
    private Index nameIndex;
    private final Index descriptorIndex;
    private final Count attributesCount;
    private Attribute[] attributes;

    public MethodInfo(FileInputStream fi, ConstantInfo[] constantPool) {
        accessFlag = new AccessFlag(fi, KIND.METHOD);
        nameIndex = new Index(fi);
        descriptorIndex = new Index(fi);
        attributesCount = new Count(fi);
        // TODO("未实现attributeinfo的解析，先默认为没有")
        /**
         *
         * 方法里面的代码去哪里了，方法里面的代码，经过编译器编译成字节码指令以后，存放在方法属性表集合中一个名为
         * “code”的属性里面，属性表作为Class文件格式中最具扩展性的一种数据结构，将在下面解释
         */
        IntStream.range(0, attributesCount.getNum()).forEach(i->{
            attributes[i] = AttributeInfoFactory.createAttributeInfo(fi,constantPool);
        });
    }

}

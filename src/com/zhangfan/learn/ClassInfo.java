package com.zhangfan.learn;

import com.sun.org.apache.xml.internal.utils.IntStack;
import com.zhangfan.learn.classfile.*;
import com.zhangfan.learn.classfile.constant.ConstantFactory;
import com.zhangfan.learn.classfile.constant.ConstantInfo;


import javax.tools.JavaFileObject;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ClassInfo {


    private final MagicNumber magicNumber; // u4
    private final Version minorVersion; // u2
    private final Version majorVersion; // u2
    private final Count constantPoolCount; // u2
    private final ConstantInfo[] constantPool;
    private final AccessFlag accessFlag;
    private final ClassName thisClassName; // 读取类的名字
    private final ClassName superClassName;
    private final Count interfacesCount;
    private final int[] interfaces;

    private final Count fieldsCount;
    private final FieldInfo[] fieldInfos; // 字段表集合
    private final Count methodCount; // 方法表中的个数
    private final MethodInfo[] methodInfos;  // 方法表
    public ClassInfo(FileInputStream fi) throws Exception {
        magicNumber = new MagicNumber(fi);
        minorVersion = new Version(fi);
        majorVersion = new Version(fi);
        constantPoolCount = new Count(fi);
        constantPool = new ConstantInfo[constantPoolCount.getNum() + 1]; // 加一是因为多了一个null
        constantPool[0] = null;
        IntStream.range(1, constantPoolCount.getNum()).forEach(i -> constantPool[i] = ConstantFactory.createConstantInfo(fi));
        accessFlag = new AccessFlag(fi, KIND.CLASS);
        thisClassName = new ClassName(fi);
        superClassName = new ClassName(fi);
        interfacesCount = new Count(fi);
        interfaces = new int[interfacesCount.getNum()];
        // TODO interface暂时解释为int类型的
        IntStream.range(0, interfacesCount.getNum()).forEach(i->{
            interfaces[i] = new Count(fi).getNum();
        });

        fieldsCount = new Count(fi);
        fieldInfos = new FieldInfo[fieldsCount.getNum()];
        IntStream.range(0, fieldsCount.getNum()).forEach(i-> fieldInfos[i] = new FieldInfo(fi, constantPool));


        methodCount = new Count(fi);
        methodInfos = new MethodInfo[methodCount.getNum()];
        IntStream.range(0, methodCount.getNum()).forEach(i-> methodInfos[i] = new MethodInfo(fi, constantPool));
    }

    @Override
    public String toString() {
        return "魔数：" + magicNumber + "\n"
                + "次版本号：" + minorVersion + "\n"
                + "主版本号：" + majorVersion + "\n"
                + "常量池数量：" + constantPoolCount + "\n"
                + "访问标识：" + accessFlag + "\n"
                + "class_name" + thisClassName + "\n"
                + "super_class_name" + superClassName + "\n"
                + "接口个数：" + interfacesCount + "\n"
                + "字段表个数：" + fieldsCount + "\n"
                + "字段表信息：" + Arrays.toString(fieldInfos);
    }
}

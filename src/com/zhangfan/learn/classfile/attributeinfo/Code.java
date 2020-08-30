package com.zhangfan.learn.classfile.attributeinfo;

//import com.sun.org.apache.bcel.internal.generic.Instruction;
import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.Count;
import com.zhangfan.learn.classfile.constant.ConstantInfo;
import com.zhangfan.learn.classfile.instruction.Instruction;
import com.zhangfan.learn.classfile.instruction.InstructionFactory;

import java.io.FileInputStream;
import java.util.stream.IntStream;

public class Code extends Attribute {
    // Code出现在方法的属性集合表中
    private Count maxStack; // 操作数栈深度的最大值。在方法执行的任意时刻，操作数栈都不会超过这个深度。
    private Count maxLocals; // 局部变量所需的存储空间。在这里，max_local的单位是slot，slot是虚拟机为局部变量分配内存所使用的最小单位
    /**
     * code_length 和 code用来存储Java
     * 源程序编译后生成的字节码指令。
     * code_length 用来代表字节码的长度，
     * code 是用于存储字节码指令的一系列字节流。
     * 既然叫字节码指令，那么每个指令就是一个u1类型的单字节，当虚拟机读取到code中的一个字节码的时候，
     * 就可以找到对应这个字节码代表的是什么指令，并且可以知道这条指令后面是否需要跟随参数，以及参数应当如何理解
     * 我们知道一个u1数据结构的取值范围是0-255，也就是总共256条指令，目前，java虚拟机规范定义了其中约200条
     * 对应的指令含义，编码与指令之间的对应关系可以啥表得知
     * 既然
     * ***/
    private Count codeLength;
    private Instruction[] codes; // 长度为codeLength
    private Count exceptionTableLength;
    private CodeException[] exceptionTable; // 长度为exceptionTableLength
    private Count attributesCount;
    private Attribute[] attributes;

    public Code(FileInputStream fi, ConstantInfo[] constantPool) {
        super(fi);
        maxStack = new Count(fi);
        maxLocals = new Count(fi);
        codeLength = new Count(fi, UKind.U4);
        codes = new Instruction[codeLength.getNum()];
//        IntStream.range(0,codeLength.getNum()).forEach(i->
//                codes[i] = InstructionFactory.getInstruction(fi)
//        );
        exceptionTableLength = new Count(fi);
        exceptionTable = new CodeException[exceptionTableLength.getNum()];
        IntStream.range(0, exceptionTableLength.getNum()).forEach(i->{
            exceptionTable[i] = new CodeException(fi);
        });
        attributesCount = new Count(fi);
        attributes = new Attribute[attributesCount.getNum()];
        IntStream.range(0,attributesCount.getNum()).forEach(i->{
            attributes[i] = Attribute.readAttribute(fi, constantPool);
        });
    }

}

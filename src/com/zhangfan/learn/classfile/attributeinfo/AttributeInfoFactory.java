package com.zhangfan.learn.classfile.attributeinfo;

import com.zhangfan.learn.classfile.Index;
import com.zhangfan.learn.classfile.constant.ConstantInfo;
import com.zhangfan.learn.classfile.constant.ConstantUtf8Info;
import com.zhangfan.learn.classfile.constant.Constants;

import java.io.FileInputStream;

public class AttributeInfoFactory {
    // 先读attribute_name_index 判断是什么属性
   //  package com.sun.org.apache.bcel.internal.classfile;
    private Index attributeNameIndex; // 属性名在常量池中的索引
    public static Attribute createAttributeInfo(FileInputStream fi, ConstantInfo[] constantInfos) {
        // 需要从常量池中找到对应的属性名
        Index attributeNameIndex = new Index(fi);
        ConstantUtf8Info utf8Info = (ConstantUtf8Info) constantInfos[attributeNameIndex.getIndex()];
        switch (utf8Info.getConstantString()) {
            case Constants.CODE:
                return new Code(fi, constantInfos);
            case Constants.CONSTANT_VALUE:
                break;
            case Constants.DEPRECATED:
                break;
            case Constants.EXCEPTIONS:
                break;
            case Constants.LINE_NUMBER_TABLE:
                break;
            case Constants.LOCAL_VARIABLE_TABLE:
                break;
            case Constants.INNER_CLASSES:
                break;
            case Constants.SYNTHETIC:
                break;
            case Constants.SOURCE_FILE:
                System.out.println("asdf");
                break;
            case Constants.PMG_CLASS:
                break;
            case Constants.SIGNATURE:
                break;
            case Constants.STACK_MAP:
                break;
            case Constants.LOCAL_VARIABLE_TYPE_TABLE:
                break;
            default:
                break;
        }
        return null;
    }
}

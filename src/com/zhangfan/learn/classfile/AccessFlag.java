package com.zhangfan.learn.classfile;

import com.sun.org.apache.bcel.internal.classfile.AccessFlags;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.constant.ReadBytes;
import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.classfile.constant.Constants;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
// https://blog.csdn.net/dengzhao3993/article/details/101506016/
public class AccessFlag extends ReadBytes {
    private static final int length = UKind.U2;
    private int accessFlag; // 将两个字节拼接起来
    private List<String> accessFlags;
    private Supplier<Boolean> isX;
    private Supplier[] isTrueList;

    public AccessFlag(FileInputStream fileInputStream) {
        super(fileInputStream, length);
        accessFlag = HexUtils.bytes2Int(bytes);
        accessFlags = new ArrayList<>();
        isTrueList = new Supplier[]{
                this::isPublic,
                this::isPrivate,
                this::isProtected,
                this::isStatic,
                this::isFinal,
                this::isSynchronized,
                this::isVolatile,
                this::isTransient,
                this::isNative,
                this::isInterface,
                this::isAbstract,
                this::isStrictfp,

        };
        for (int i = 0; i < isTrueList.length; i++) {
            if ((Boolean) isTrueList[i].get()) {
                accessFlags.add(Constants.ACCESS_NAMES[i]);
            }
        }
        // 上面的access_flag为类和方法字段共有
        // 下面为类单独享有
        if (isSuper()) {
            accessFlags.add("super");
        }
        if (isEnum()) {
            accessFlags.add("enum");
        }

    }

    public final boolean isEnum() {
        return (accessFlag & Constants.ACC_ENUM ) != 0;
    }

    public final boolean isSuper() {
        return (accessFlag & Constants.ACC_SUPER) != 0;
    }

    public final boolean isClass() {
        return (accessFlag & Constants.ACC_INTERFACE) == 0;
    }

    public final boolean isPublic() {
        return (accessFlag & Constants.ACC_PUBLIC) != 0;

    }

    public final boolean isPrivate() {
        return (accessFlag & Constants.ACC_PRIVATE) != 0;
    }

    public final boolean isProtected() {
        return (accessFlag & Constants.ACC_PROTECTED) != 0;
    }

    public final boolean isStatic() {
        return (accessFlag & Constants.ACC_STATIC) != 0;
    }


    public final boolean isFinal() {
        return (accessFlag & Constants.ACC_FINAL) != 0;
    }


    public final boolean isSynchronized() {
        return (accessFlag & Constants.ACC_SYNCHRONIZED) != 0;
    }


    public final boolean isVolatile() {
        return (accessFlag & Constants.ACC_VOLATILE) != 0;
    }


    public final boolean isTransient() {
        return (accessFlag & Constants.ACC_TRANSIENT) != 0;
    }


    public final boolean isNative() {
        return (accessFlag & Constants.ACC_NATIVE) != 0;
    }


    public final boolean isInterface() {
        return (accessFlag & Constants.ACC_INTERFACE) != 0;
    }


    public final boolean isAbstract() {
        return (accessFlag & Constants.ACC_ABSTRACT) != 0;
    }


    public final boolean isStrictfp() {
        return (accessFlag & Constants.ACC_STRICT) != 0;
    }

    @Override
    public String toString() {
        return String.join(",", accessFlags);
    }
}

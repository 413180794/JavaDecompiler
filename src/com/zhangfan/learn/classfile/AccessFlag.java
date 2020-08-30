package com.zhangfan.learn.classfile;

import com.zhangfan.learn.KIND;
import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.constant.ReadBytes;
import com.zhangfan.learn.tools.HexUtils;
import com.zhangfan.learn.classfile.constant.Constants;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AccessFlag extends ReadBytes {


    private static final int length = UKind.U2;
    private int accessFlag; // 将两个字节拼接起来
    private List<String> accessFlags;
    private Supplier<Boolean> isX;
    private Supplier[] isTrueList;

    public AccessFlag(FileInputStream fileInputStream, KIND kind) {
        super(fileInputStream, length);
        accessFlag = HexUtils.bytes2Int(bytes);
        accessFlags = new ArrayList<>();
        isTrueList = getSuppliersByKind(kind);
        for (int i = 0; i < isTrueList.length; i++) {
            if ((Boolean) isTrueList[i].get()) {
                accessFlags.add(getAccessNamesByKind(kind)[i]);
            }
        }
        // TODO public private protected三个标志最多只能选择其一、final volatile不能同时选择
        // 借口字段必须要有 public static final 标志
    }

    private String[] getAccessNamesByKind(KIND kind) {
        if (kind == KIND.CLASS) {
            return Constants.CLASSES_ACCESS_NAMES;
        } else if (kind == KIND.FIELD) {
            return Constants.FIELD_ACCESS_NAMES;
        } else if (kind == KIND.METHOD) {
            return Constants.METHOD_ACCESS_NAMES;
        }
        else {
            return Constants.NESTED_CLASS_ACCESS_NAMES;
        }
    }

    private Supplier[] getSuppliersByKind(KIND kind) {
        if (kind == KIND.CLASS) {
            return new Supplier[]{
                    this::isPublic,
                    this::isFinal,
                    this::isSuper,
                    this::isInterface,
                    this::isAbstract,
                    this::isSynthetic,
                    this::isAnnotation,
                    this::isEnum
            };
        } else if (kind == KIND.FIELD) {
            return new Supplier[]{
                    this::isPublic,
                    this::isPrivate,
                    this::isProtected,
                    this::isStatic,
                    this::isFinal,
                    this::isVolatile,
                    this::isTransient,
                    this::isSynthetic,
                    this::isEnum
            };
        } else if (kind == KIND.METHOD) {
            return new Supplier[]{
                    this::isPublic,
                    this::isPrivate,
                    this::isProtected,
                    this::isStatic,
                    this::isFinal,
                    this::isSynchronized,
                    this::isBridge,
                    this::isVarargs,
                    this::isNative,
                    this::isAbstract,
                    this::isStatic,
                    this::isSynthetic
            };
        } else {
            return new Supplier[]{
                    this::isPublic,
                    this::isPrivate,
                    this::isProtected,
                    this::isStatic,
                    this::isFinal,
                    this::isInterface,
                    this::isAbstract,
                    this::isSynthetic,
                    this::isAnnotation,
                    this::isEnum
            };
        }
    }

    public final boolean isSynthetic() {
        return (accessFlag & Constants.ACC_SYNTHETIC) != 0;
    }

    public final boolean isAnnotation() {
        return (accessFlag & Constants.ACC_ANNOTATION) != 0;
    }

    public final boolean isBridge() {
        return (accessFlag & Constants.ACC_BRIDGE) != 0;
    }

    public final boolean isVarargs() {
        return (accessFlag & Constants.ACC_VARARGS) != 0;
    }

    public final boolean isEnum() {
        return (accessFlag & Constants.ACC_ENUM) != 0;
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

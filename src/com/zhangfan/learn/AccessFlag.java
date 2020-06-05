package com.zhangfan.learn;

import com.zhangfan.learn.constant.ReadBytes;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccessFlag extends ReadBytes {
    private static final int length = UKind.U2;
    private List<String> accessFlags;
    public AccessFlag(FileInputStream fileInputStream) {
        super(fileInputStream,length);
        accessFlags = new ArrayList<>();
        // 解析accessflag
        if ((bytes[1] & 0x01) == 0x01 ) {
            accessFlags.add("ACC_PUBLIC");
        }
        if ((bytes[1] & 0x10) == 0x10) {
            accessFlags.add("ACC_FINAL");
        }
        if ((bytes[1] & 0x20) == 0x20) {
            accessFlags.add("ACC_SUPER");
        }
        if ((bytes[0] & 0x02) == 0x02) {
            accessFlags.add("ACC_INTERFACE");
        }
        if ((bytes[0] & 0x04) == 0x04) {
            accessFlags.add("ACC_ABSTRACT");
        }
        if ((bytes[0] & 0x10) == 0x10) {
            accessFlags.add("ACC_SYNTHETIC");
        }
        if((bytes[0] & 0x20) == 0x20) {
            accessFlags.add("ACC_ANNOTATION");
        }
        if ((bytes[0] & 0x40) == 0x40) {
            accessFlags.add("ACC_ENUM");
        }
    }

    @Override
    public String toString() {
        return String.join(",", accessFlags);
    }
}

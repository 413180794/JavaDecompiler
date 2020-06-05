package com.zhangfan.learn;

import com.zhangfan.learn.constant.ReadBytes;

import java.io.FileInputStream;

public class Version extends ReadBytes {
    // 版本信息
    private static final int length = 2;
    private int versionNum;
    public Version(FileInputStream fileInputStream) {
        super(fileInputStream,length);
        versionNum = bytes[0]*512 + bytes[1];
    }


    public int getVersionNum() {
        return versionNum;
    }

    @Override
    public String toString() {
        return ""+versionNum;
    }
}

package com.zhangfan.learn.classfile;

import com.zhangfan.learn.UKind;
import com.zhangfan.learn.classfile.constant.ReadBytes;
import com.zhangfan.learn.tools.HexUtils;

import java.io.FileInputStream;

public class Version extends ReadBytes {
    // 版本信息
    private static final int length = UKind.U2;
    private int versionNum;
    public Version(FileInputStream fileInputStream) {
        super(fileInputStream,length);
        versionNum = HexUtils.bytes2Int(bytes);
    }


    public int getVersionNum() {
        return versionNum;
    }

    @Override
    public String toString() {
        return ""+versionNum;
    }
}

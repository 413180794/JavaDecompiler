package com.zhangfan.learn.classfile.constant;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadBytes {
    public byte[] bytes;
    private FileInputStream fileInputStream;

    public ReadBytes(FileInputStream fileInputStream,int length){
        bytes = new byte[length];
        try {
            int readNum = fileInputStream.read(bytes);
            if (readNum == -1){
                System.out.println("字节读取失败");
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

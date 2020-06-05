package com.zhangfan.learn.constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.IntStream;

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

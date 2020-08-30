package com.zhangfan.learn;

import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {

        String filePath = "D:\\LinuxCode\\JavaProject\\JavaDecompiler\\out\\production\\JavaDecompiler\\com\\zhangfan\\learn\\test\\Demo.class";
        try (FileInputStream fi = new FileInputStream(filePath)) {
            ClassInfo classInfo = new ClassInfo(fi);
            System.out.println(classInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(0x000000ff << 8);
    }
}

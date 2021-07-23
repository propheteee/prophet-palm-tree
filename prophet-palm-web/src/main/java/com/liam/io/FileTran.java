package com.liam.io;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Description:
 * Created by prophet on 2020/3/5 13:59
 */
public class FileTran {


    public static void main(String[] args) {
        try {
            FileInputStream file1 = new FileInputStream("C://Users//ASUS//Desktop//a.txt");
            FileChannel channel = file1.getChannel();
            FileOutputStream file2 = new FileOutputStream("C://Users//ASUS//Desktop//b.txt");
            FileChannel channel2 = file2.getChannel();
            // 下边开始声明一个字节缓冲器
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) != -1) {//将物品从库存读入到缓冲器（大卡车）
                buffer.flip();
                channel2.write(buffer);//将缓冲器（大卡车）的物品，写出到目的地。
                buffer.clear();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

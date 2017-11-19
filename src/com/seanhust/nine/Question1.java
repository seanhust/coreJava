package com.seanhust.nine;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Question1 {
    public static void main(String[] args){
        try{
            //要查找的路径
            Path path = FileSystems.getDefault().getPath("/home/sean/code");
            Stream<Path> paths = Files.walk(path);
            Stream<Path> first = paths.parallel().filter(path1 -> {
                if(path1.toString().matches(".*.git.*")){
                    return true;
                }else {
                    return false;
                }
            });
            //first里面将含有所有满足的文件路径,将第一个返回即可
            System.out.print(first.findFirst());
//            System.out.print(first.count());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.ldg.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUtil {

    /**
     * 上传文件工具类
     * @param file 需要上传的文件
     * @param FILE_DIC 上传路径
     */
    public static void uploadFile(MultipartFile file,String FILE_DIC,String fileName){

        File fileDirectory = new File(FILE_DIC);
        //创建文件
        File destFile = new File(FILE_DIC + fileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            System.out.println("上传文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件工具类
     */
    public static Integer deleteFile(String FILE_DIC,String url){
        int lastIndexOf = url.lastIndexOf("/");
        String img_path = url.substring(lastIndexOf + 1);
        //拼接图片的绝对地址
        img_path = FILE_DIC + img_path;
        File file = new File(img_path);
        if (file.exists()){//文件是否存在
            if (file.delete()) {//存在就删了
                System.out.println("删除文件成功");
                return 1; // 成功
            } else {
                return 0; // 失败
            }
        }else {
            return -1; // 文件不存在
        }
    }

    public static String getFileName(){
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        return sdf.format(new Date()) + r.nextInt(100);
    }

}

package com.sky.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 懒得用阿里云 oss 自定义的文件上传工具类
 */
public class LocalFileUtil {

    private static final String PATH = "D:/sky/files/apache-tomcat-9.0.27/webapps/files/";

    private static final String RETURN_PATH = "http://localhost:9090/files/";

    public static String upload(byte[] bytes, String objectName) {
        File file = new File(PATH + objectName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return RETURN_PATH + objectName;
    }
}

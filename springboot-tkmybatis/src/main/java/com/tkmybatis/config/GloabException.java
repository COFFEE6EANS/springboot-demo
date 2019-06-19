package com.tkmybatis.config;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/27
 * @Description：
 */
public class GloabException   {
    public static void main(String[] args) {
        String str =  "\2019\0522";
        String replace = str.replace("\\", "/");
        System.out.println(str);
        System.out.println(replace);
    }
}

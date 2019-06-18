package com.chapter05_编码加密;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Assert;
import org.junit.Test;

public class CodeTest {
    /**
     * base64编码/解码操作
     */
    @Test
    public void encode() {
        String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        System.out.println(base64Encoded);

        String str2 = Base64.decodeToString(base64Encoded);
        Assert.assertEquals(str, str2);
    }

    /**
     * 16进制字符串编码/解码
     */
    @Test
    public void encode1() {
        String str = "hello";
        String base64Encoded = Hex.encodeToString(str.getBytes());
        System.out.println(base64Encoded);
        String str2 = new String(Hex.decode(base64Encoded.getBytes()));
        Assert.assertEquals(str, str2);
    }
    @Test
    public void codecSupportTest(){
        String hello = "hello";
        byte[] bytes = CodecSupport.toBytes(hello);
        String string = CodecSupport.toString(bytes);
        Assert.assertEquals(hello,string);
    }
    @Test
    public void toHashStr(){
        //另外散列时还可以指定散列次数，如2次表示：md5(md5(str))：“new Md5Hash(str, salt, 2).toString()”。
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();//还可以转换为 toBase64()/toHex()
        System.out.println(md5);
    }
}

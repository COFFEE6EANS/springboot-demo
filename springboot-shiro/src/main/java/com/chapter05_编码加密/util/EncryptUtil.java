package com.chapter05_编码加密.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class EncryptUtil {
    /**
     * base64 编码
     *
     * @param plaintext
     * @return
     */
    public static String encodedByBase64(String plaintext) {
        return Base64.encodeToString(plaintext.getBytes());
    }

    /**
     * base64解码
     *
     * @param ciphertext
     * @return
     */
    public static String decodedByBase64(String ciphertext) {
        return Base64.decodeToString(ciphertext);
    }

    /**
     * 16进制字符串编码
     *
     * @param plaintext
     * @return
     */
    public static String encodedByHex(String plaintext) {
        return Hex.encodeToString(plaintext.getBytes());
    }

    /**
     * 16进制字符串解码
     *
     * @param ciphertext
     * @return
     */
    public static String decodedByHex(String ciphertext) {
        return new String(Hex.decode(ciphertext.getBytes()));
    }

    /**
     * 散列
     *
     * @param plaintext
     * @return
     */
    public static String md5Hash(String plaintext, String salt) {
        return md5Hash(plaintext, salt, 1);
    }

    /**
     * 散列
     *
     * @param plaintext
     * @return
     */
    public static String md5Hash(String plaintext, String salt, int hashIterations) {
        return new Md5Hash(plaintext, salt, hashIterations).toHex().toString();
    }

    /**
     * SHA256算法生成相应的散列数据
     *
     * @param plaintext
     * @param salt
     * @return
     */
    public static String sha256Hash(String plaintext, String salt) {
        return new Sha256Hash(plaintext, salt, 1).toString();
    }

    /**
     * SHA256算法生成相应的散列数据
     *
     * @param plaintext
     * @param salt
     * @param hashIterations
     * @return
     */
    public static String sha256Hash(String plaintext, String salt, int hashIterations) {
        return new Sha256Hash(plaintext, salt, hashIterations).toString();
    }

    /**
     * simpleHash
     * 通过调用SimpleHash时指定散列算法，其内部使用了Java的MessageDigest实现。
     * @param plaintext
     * @param salt
     * @return
     */
    public static String simpleHash(String plaintext, String salt) {
        return new SimpleHash("SHA-1", plaintext, salt).toString();
    }
}

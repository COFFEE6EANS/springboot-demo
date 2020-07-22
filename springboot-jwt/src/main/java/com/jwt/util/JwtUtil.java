package com.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.jwt.constant.JwtConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
@Slf4j
public class JwtUtil {
    /**
     *  加final,基于JVM的优化
     *  生产token的方法
     * @param claims
     * @return
     */
    public final static String genericToken(final Map<String,String> claims){
        try {
            // 创建一个算法对象
            Algorithm algorithm = Algorithm.HMAC256(JwtConstant.SECRET_KEY);
            //  .withIssuer   .withExpiresAt:有效时间
            JWTCreator.Builder builder = JWT.create().withIssuer(JwtConstant.ISSUER).withExpiresAt(DateUtils.addDays(new Date(), 1));
            //信息体
            claims.forEach((k,v)->{ builder.withClaim(k,v); });
            //密签
            return builder.sign(algorithm);
        } catch (Exception e) {
            log.info("生产token出现异常，异常信息为：{}",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  验证token是否合法
     * @param token
     * @return
     */
    public final static boolean verifyToken(String token){
        boolean flag = true;
        try {
            // 创建一个算法对象
            Algorithm algorithm = Algorithm.HMAC256(JwtConstant.SECRET_KEY);
            JWTVerifier build = JWT.require(algorithm).withIssuer(JwtConstant.ISSUER).build();
            build.verify(token);
        } catch (TokenExpiredException e) {
            flag = false;
            log.info("token过期了，异常信息为：{}",e.getMessage());
            e.printStackTrace();
        } catch (JWTDecodeException e) {
            flag = false;
            log.info("token无效，异常信息为：{}",e.getMessage());
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            flag = false;
            log.info("token无效，异常信息为：{}",e.getMessage());
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            flag = false;
            log.info("token错误，异常信息为：{}",e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("gjf","xnd");
        String s = JwtUtil.genericToken(map);
        System.out.println(s);
        System.out.println("----------------------");
        boolean b = verifyToken(s);
        System.out.println(b?"通过":"失败");
    }
}

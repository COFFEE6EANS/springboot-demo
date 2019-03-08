package com.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 博客工具类
 * @author 小卖铺的老爷爷
 * @date 2018年4月13日
 * @website www.laoyeye.net
 */
public class WebUtils {

    public static String getIpAddress(HttpServletRequest request)
    {
      String ip;
      try
      {
              ip = request.getHeader("x-forwarded-for");
        if ((StringUtils.isEmpty(ip)) || ("unknown".equalsIgnoreCase(ip))) {
          ip = request.getHeader("Proxy-Client-IP");
        }
        if ((StringUtils.isEmpty(ip)) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
          ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((StringUtils.isEmpty(ip)) || ("unknown".equalsIgnoreCase(ip))) {
          ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if ((StringUtils.isEmpty(ip)) || ("unknown".equalsIgnoreCase(ip))) {
          ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if ((StringUtils.isEmpty(ip)) || ("unknown".equalsIgnoreCase(ip))) {
          ip = request.getRemoteAddr();
        }
      }
      catch (Exception e)
      {
        ip = request.getRemoteAddr();
      }
      return ip;
    }

}

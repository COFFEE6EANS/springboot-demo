package com.enable.demo.annotation;

import com.enable.demo.api.UserImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(UserImportSelector.class)
public @interface EnableUser {
}

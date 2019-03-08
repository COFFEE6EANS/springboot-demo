package com.enable.api;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
public class RedisLockImportSelector implements ImportSelector {

//    @Override
//    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//
//    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.enable.api.RedisLockAop"};
    }
}

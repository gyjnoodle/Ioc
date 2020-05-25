package com.gyj.ioc.annotations;

import java.lang.annotation.*;

/**
 * @Author noodle
 * @Description 自定义服务的依赖注入
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowired {

}
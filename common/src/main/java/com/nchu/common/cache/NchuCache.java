package com.nchu.common.cache;


import java.lang.annotation.*;

// 作用在方法
@Target(ElementType.METHOD)
// 运行时生效
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NchuCache {
    String prefix() default "";
}

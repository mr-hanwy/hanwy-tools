package cn.hanwy.hanwytools.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志输出注解
 *
 * @author hanwy
 * @date 2024/4/4
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /** 方法描述，不能为空 */
    String methodDescription();

    /** 方法名称，默认为空 */
    String methodName() default "";

    /** 是否包含审计日志，默认：false */
    boolean hasAuditLog() default false;
}
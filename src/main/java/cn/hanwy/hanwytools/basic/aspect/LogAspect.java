package cn.hanwy.hanwytools.basic.aspect;

import cn.hanwy.hanwytools.basic.annotation.Log;
import cn.hanwy.hanwytools.basic.utils.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 日志切面
 *
 * @author hanwy
 * @date 2024/4/4
 */
@Aspect
@Component
public class LogAspect {
    @Around("@annotation(logAnnotation)")
    public Object logAnnotationHandler(ProceedingJoinPoint point, Log logAnnotation) throws Throwable {
        Signature signature = point.getSignature();
        Class<?> type = signature.getDeclaringType();

        String methodDescription = logAnnotation.methodDescription();
        String methodName = logAnnotation.methodName();
        if (!StringUtils.hasText(methodName)) {
            methodName = signature.getName();
        }

        // 获取日志工具类实例对象
        LogUtil logUtil = LogUtil.getInstance(type);
        logUtil.start(methodName, methodDescription, point.getArgs());
        Object proceed = point.proceed();
        logUtil.end(methodName, methodDescription, proceed);

        return proceed;
    }
}
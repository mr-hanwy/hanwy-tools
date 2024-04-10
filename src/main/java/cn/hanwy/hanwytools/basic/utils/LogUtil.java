package cn.hanwy.hanwytools.basic.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * 日志工具类
 *
 * @author hanwy
 */
public class LogUtil {
    private static final String LOG_BASIC = "{}({})";
    private static final String LOG_START = String.format("******** %s Begin ********", LOG_BASIC);
    private static final String PARAM_IN = "接口入参：{}";
    private static final String PARAM_OUT = "接口出参：{}";
    private static final String LOG_END = String.format("******** %s End ********", LOG_BASIC);
    private static final ObjectMapper JSON = new ObjectMapper();

    private static Logger log;
    private static Class<?> clazz;

    private LogUtil(Class<?> clazz) {
        log = LoggerFactory.getLogger(clazz);
        LogUtil.clazz = clazz;
    }

    public static LogUtil getInstance(Class<?> clazz) {
        return new LogUtil(clazz);
    }

    /**
     * 打印开始日志
     *
     * @param methodName 方法名称
     * @param methodDescription 方法描述
     * @param args 需要打印的参数
     */
    public void start(String methodName, String methodDescription, Object... args) {
        log.info(LOG_START, methodDescription, getFullMethodName(methodName));
        if (!Objects.isNull(args)) {
            try {
                log.info(PARAM_IN, JSON.writeValueAsString(args));
            } catch (JsonProcessingException e) {
                log.error("将入参转换为 JSON 字符串时发生异常！", e);
            }
        }
    }

    /**
     * 打印结束日志
     *
     * @param methodName 方法名称
     * @param methodDescription 方法描述
     * @param args 需要打印的参数
     */
    public void end(String methodName, String methodDescription, Object... args) {
        log.info(LOG_END, methodDescription, getFullMethodName(methodName));
        if (!Objects.isNull(args)) {
            try {
                log.info(PARAM_OUT, JSON.writeValueAsString(args));
            } catch (JsonProcessingException e) {
                log.error("将出参转换为 JSON 字符串时发生异常！", e);
            }
        }
    }

    private String getFullMethodName(String methodName) {
        return clazz.getSimpleName().concat(".").concat(methodName);
    }
}
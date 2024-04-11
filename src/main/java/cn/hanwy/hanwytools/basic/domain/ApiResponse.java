package cn.hanwy.hanwytools.basic.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 接口响应对象
 *
 * @author hanwy
 * @date 2024/4/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    /** 响应码 */
    private int code;
    /** 响应消息 */
    private String msg;
    /** 响应数据 */
    private T data;
}
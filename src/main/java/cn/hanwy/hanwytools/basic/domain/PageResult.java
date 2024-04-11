package cn.hanwy.hanwytools.basic.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * 分页返回对象
 *
 * @author hanwy
 * @date 2024/4/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResult<T> {
    /** 分页参数 */
    private Pagination pagination;
    /** 返回元素集合 */
    private List<T> elements;
}
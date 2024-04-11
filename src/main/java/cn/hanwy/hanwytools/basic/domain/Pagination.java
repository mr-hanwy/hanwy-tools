package cn.hanwy.hanwytools.basic.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 分页参数对象
 *
 * @author hanwy
 * @date 2024/4/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagination {
    /** 每页大小 */
    private int pageSize = 20;
    /** 当前页码 */
    private int currentPage = 0;
    /** 总数量 */
    private long totalCount;
    /** 总页数 */
    private int totalPage;
}
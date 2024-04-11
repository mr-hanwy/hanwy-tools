package cn.hanwy.hanwytools.basic.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 基础实体类对象
 *
 * @author hanwy
 * @date 2024/4/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicObject {
    /** 主键 id */
    private String id;
    /** 数据版本号（乐观锁） */
    private String version;
    /** 数据创建时间（格式：yyyy-MM-dd HH:mm:ss） */
    private String createDateTime;
    /** 数据更新时间（格式：yyyy-MM-dd HH:mm:ss） */
    private String updateDateTime;
}
package com.funtl.hello.spring.transaction.domain;

import lombok.Data;

import java.util.Date;

/**
 * 分类管理
 */

@Data
public class TbContentCategory {
    private Long id;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
    private Date created;
    private Date updated;
    private TbContentCategory parent;
}
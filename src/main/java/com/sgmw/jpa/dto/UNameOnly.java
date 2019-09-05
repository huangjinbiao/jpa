package com.sgmw.jpa.dto;

/**
 * 投影 只取表中部分数据
 * 参考：https://docs.spring.io/spring-data/jpa/docs/2.1.10.RELEASE/reference/html/#projections
 * @author HJB
 */
public interface UNameOnly {
    /**
     * 用户id
     * @return
     */
    Long getId();

    /**
     * 用户名称
     * @return
     */
    String getName();
}

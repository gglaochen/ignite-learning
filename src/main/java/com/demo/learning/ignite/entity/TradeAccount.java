package com.demo.learning.ignite.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChenHanLin 2020/7/18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeAccount {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 账号
     */
    private String accountCode;
}

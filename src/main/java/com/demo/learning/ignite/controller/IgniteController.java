package com.demo.learning.ignite.controller;

import com.demo.learning.ignite.entity.TradeAccount;
import com.demo.learning.ignite.repository.TradeAccRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author ChenHanLin 2020/7/8
 */
@Slf4j
@RestController
@RequestMapping("ignite")
public class IgniteController {

    @Autowired
    private TradeAccRepository igniteRepository;

    @GetMapping("map")
    public TradeAccount map() {
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 1000; i++) {
            igniteRepository.save(123L, TradeAccount.builder()
                    .id(123L)
                    .accountCode("123")
                    .build());
        }
        log.info("存数据共计用时:{}", Duration.between(start, LocalDateTime.now()));

        LocalDateTime read = LocalDateTime.now();
        TradeAccount account = igniteRepository.findById(123L).orElse(null);
        log.info("读数据共计用时:{}", Duration.between(read, LocalDateTime.now()));
        return account;
    }
}

package com.demo.learning.ignite.repository;

import com.demo.learning.ignite.entity.TradeAccount;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

/**
 * @author ChenHanLin 2020/7/8
 */
@Repository
@RepositoryConfig(cacheName = "defaultCache")
public interface TradeAccRepository extends IgniteRepository<TradeAccount, Long> {

}

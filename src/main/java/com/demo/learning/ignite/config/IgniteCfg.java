package com.demo.learning.ignite.config;

import com.demo.learning.ignite.entity.TradeAccount;
import org.apache.ignite.Ignite;
import org.apache.ignite.configuration.*;
import org.apache.ignite.internal.IgnitionEx;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChenHanLin 2020/7/18
 */
@Configuration
public class IgniteCfg {
    /**
     * 初始化ignite节点信息
     *
     * @return Ignite
     */
    @Bean
    public Ignite igniteInstance() throws Exception {
        DataRegionConfiguration dataCfg = new DataRegionConfiguration();
        dataCfg.setName("order_offheap_memory");
        //约1w条订单数据
        dataCfg.setInitialSize(10 * 1024 * 1024);
        //约20w条订单数据
        dataCfg.setMaxSize(200 * 1024 * 1024);

        // 最近第二次访问最久 删除策略
        dataCfg.setPageEvictionMode(DataPageEvictionMode.RANDOM_2_LRU);
        DataStorageConfiguration memCfg = new DataStorageConfiguration();
        memCfg.setDataRegionConfigurations(dataCfg);

        // 配置一个节点的Configuration
        IgniteConfiguration cfg = new IgniteConfiguration();
        // 设置该节点名称
        cfg.setIgniteInstanceName("springDataNode");
        cfg.setDataStorageConfiguration(memCfg);
        // 启用Peer类加载器sun/misc
        cfg.setPeerClassLoadingEnabled(true);

        // 创建一个Cache的配置
        CacheConfiguration<Long, TradeAccount> cacheCfg = new CacheConfiguration<>("defaultCache");
        // 设置这个Cache的键值对模型
        cacheCfg.setIndexedTypes(Long.class, TradeAccount.class);
        // 是否启用堆内缓存
        cacheCfg.setOnheapCacheEnabled(false);
        // 把这个Cache放入springDataNode这个Node中
        cfg.setCacheConfiguration(cacheCfg);

        // 启动这个节点
        return IgnitionEx.start(cfg);
    }
}

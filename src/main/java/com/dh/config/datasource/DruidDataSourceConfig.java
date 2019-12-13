package com.dh.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Administrator
 */
@Configuration
public class DruidDataSourceConfig {

    /**
     * 使用druid数据库连接池
     *
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        return datasource;
    }
}

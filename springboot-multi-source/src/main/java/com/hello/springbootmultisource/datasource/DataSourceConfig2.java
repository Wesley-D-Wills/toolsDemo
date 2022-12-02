package com.hello.springbootmultisource.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hello.springbootmultisource.dao.demo2", sqlSessionFactoryRef = "demo2SqlSessionFactory")
public class DataSourceConfig2 {
    @Bean(name = "demo2DataSource")
    // @Primary // 表示该数据源为默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.demo2")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "demo2SqlSessionFactory")
    // @Primary
    public SqlSessionFactory demo2SqlSessionFactory(@Qualifier("demo2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/demo2/*.xml")
        );
        return factoryBean.getObject();
    }

    @Bean(name = "demo2TransactionManager")
    // @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("demo2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("demo2SqlSessionTemplate")
    // @Primary
    public SqlSessionTemplate demo1SqlSessionTemplate(@Qualifier("demo2SqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }
}

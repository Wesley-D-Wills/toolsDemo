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
@MapperScan(basePackages = "com.hello.springbootmultisource.dao.demo1", sqlSessionFactoryRef = "demo1SqlSessionFactory")
public class DataSourceConfig1 {
    @Bean(name = "demo1DataSource")
    @Primary // 表示该数据源为默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.demo1")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "demo1SqlSessionFactory")
    @Primary
    public SqlSessionFactory demo1SqlSessionFactory(@Qualifier("demo1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/demo1/*.xml")
        );
        return factoryBean.getObject();
    }

    @Bean(name = "demo1TransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("demo1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "demo1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate demo1SqlSessionTemplate(@Qualifier("demo1SqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }
}

package com.example.handsomeblog.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.handsomeblog.dal)", sqlSessionFactoryRef = "SqlSessionFactory")//basePackages:接口文件的包路径
public class DataSourceConfig {

    @Bean(name = "DataSource")
    // 表示这个数据源是默认数据源
    @ConfigurationProperties(prefix = "spring.datasource")//我们配置文件中的前缀
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("DataSource")
                                                              DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:dal/*/*.xml"));
        //开启sql转实体驼峰命名方式
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        // 设置mybatis的xml所在位置
        return bean.getObject();
    }



}

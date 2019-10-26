package io.datadynamics.template.boot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * MyBATIS Spring Boot Configuration
 */
@Configuration
public class MyBatisConfiguration {

    /**
     * JDBC DataSource
     */
    @Autowired
    DataSource dataSource;

    /**
     * Spring Framework Application Context
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * MyBATIS SQL Session Factory를 생성한다.
     *
     * @return MyBATIS SQL Session Factory
     * @throws Exception MyBATIS SQL Session Factory를 생성할 수 없는 경우(예; SQLMap XML 파일 오류, XML 파일 로딩 실패, XML 파일 파싱 에러 등)
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("io.datadynamics.template.boot.domain"); // TODO
        sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/**/*-mapper.xml"));
        return sessionFactoryBean.getObject();
    }

    /**
     * MyBATIS SQL Session Template을 생성한다.
     *
     * @return MyBATIS SQL Session Template
     * @throws Exception MyBATIS SQL Session Template을 생성할 수 없는 경우
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}
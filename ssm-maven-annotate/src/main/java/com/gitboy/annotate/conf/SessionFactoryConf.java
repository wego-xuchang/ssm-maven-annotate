package com.gitboy.annotate.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.gitboy.annotate.mapper")
@EnableTransactionManagement 
public class SessionFactoryConf {
	
	@Bean
	public DruidDataSource getDruidDataSource(@Value("${driver}") String driver, @Value("${url}") String url,
			@Value("${username}") String uname, @Value("${password}") String password) {
 
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(uname);
		dataSource.setPassword(password);
 
		return dataSource;
	}
	
	@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.gitboy.annotate.pojo");
        // 动态获取SqlMapper
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources("classpath:mybatis/*.xml"));

        return sqlSessionFactoryBean;
    }
	
	 @Bean
	    public PlatformTransactionManager transactionManager(DataSource dataSource) {
	        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
	        return dataSourceTransactionManager;

	    }
}

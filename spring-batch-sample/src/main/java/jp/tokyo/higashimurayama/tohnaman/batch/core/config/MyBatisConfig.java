package jp.tokyo.higashimurayama.tohnaman.batch.core.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "jp.tokyo.higashimurayama.tohnaman.batch.mybatis.mapper")
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("jp.tokyo.higashimurayama.tohnaman.batch.mybatis.model");
		return sqlSessionFactoryBean.getObject();
	}
}

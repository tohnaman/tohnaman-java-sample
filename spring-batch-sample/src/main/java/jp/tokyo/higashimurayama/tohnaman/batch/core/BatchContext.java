package jp.tokyo.higashimurayama.tohnaman.batch.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import jp.tokyo.higashimurayama.tohnaman.batch.core.config.DataSourceConfig;
import jp.tokyo.higashimurayama.tohnaman.batch.core.config.MyBatisConfig;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@PropertySource("classpath:/application.properties")
@Import({ DataSourceConfig.class, MyBatisConfig.class })
public class BatchContext {

}

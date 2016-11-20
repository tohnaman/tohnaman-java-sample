package jp.tokyo.higashimurayama.tohnaman.batch.core.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource repoDataSource(JdbcConfig jdbcConfig) throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(jdbcConfig.getDriver());
		dataSource.setUrl(jdbcConfig.getUrl());
		dataSource.setUsername(jdbcConfig.getUsername());
		dataSource.setPassword(jdbcConfig.getPassword());
		return dataSource;
	}

	@Bean
	@ConfigurationProperties(prefix = "batch.database")
	public JdbcConfig repoJdbcConfig() {
		return new JdbcConfig();
	}

	private static class JdbcConfig {
		private String driver = "driver";
		private String url = "url";
		private String username = "username";
		private String password = "password";

		public String getDriver() {
			return driver;
		}

		@SuppressWarnings("unused")
		public void setDriver(String driver) {
			this.driver = driver;
		}

		public String getUrl() {
			return url;
		}

		@SuppressWarnings("unused")
		public void setUrl(String url) {
			this.url = url;
		}

		public String getUsername() {
			return username;
		}

		@SuppressWarnings("unused")
		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		@SuppressWarnings("unused")
		public void setPassword(String password) {
			this.password = password;
		}
	}
}

package config;



import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库的配置
 * 	1.告诉配置信息的位置  @PropertySource
 * 	2.利用IOC功能注入配置信息 @value
 * @author s
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@MapperScan({"mapper"})
public class DBConfig {
	//配置信息
	@Value("${jdbc.driverClass}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${pool.maxActive}")
	private int maxActive;
	
	//--// MyBatis的配置
	@Value("${mybatis.config.path}")
	private String myBatisConfigPath;
	@Value("${mybatis.mapper.xml.config.path}")
	private String mapperXMLConfigPath;
	@Value("${mybatis.alias.package.path}")
	private String aliasPackagePath;
	
	//数据源的bean
	@Bean(name="dateSource")
	public DataSource createDateSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxActive(maxActive);
		return ds;
	}
	
	//jdbctemplate
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory createSqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageXMLConfigPath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperXMLConfigPath;
		// 设置MyBatis 配置文件的路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(myBatisConfigPath));
		//设置mapper对应的XML文件路径
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageXMLConfigPath));
		//设置数据源
		sqlSessionFactoryBean.setDataSource(ds);
		//设置实体别名包路径
		sqlSessionFactoryBean.setTypeAliasesPackage(aliasPackagePath);
		
		return sqlSessionFactoryBean.getObject();
	}
	
	//事务
	@Bean(name="transactionManager")
	public PlatformTransactionManager creatTransactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}

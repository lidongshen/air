package config;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 应用配置（spring配置）
 * 相当于xml的替代者
 * @author s
 *
 */
@Configuration
@ComponentScan({"dao","service","controller"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
//@EnableWebMvc
public class AppConfig extends WebMvcConfigurationSupport{
	
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");   //位置（受保护，不可以直接访问）
		resolver.setSuffix(".jsp");       //jsp文件的后缀，以后可以不写
		resolver.setViewClass(JstlView.class); 
		return resolver;
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}
	

}

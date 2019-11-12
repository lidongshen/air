package config;

import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * tomcat启动的时候会检测是否有WebApplicationInitializer这个接口的类，若检测到有，就会实例化，并调用onStartup方法
 * @author s
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//构造spring容器
		  AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//spring容器加载配置
		ctx.register(AppConfig.class);
		//spring容器接管servletcontext应用上下文对象
		ctx.setServletContext(servletContext);
		//添加servlet（至少添加一个servlet，springmvc框架实现的入口servlet）
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		//添加字符编码的过滤器
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForServletNames(null, false, "/*");
	}

}

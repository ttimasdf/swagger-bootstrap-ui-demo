package com.swagger.bootstrap.ui.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@SpringBootApplication
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
public class SwaggerBootstrapUiDemoApplication  implements WebMvcConfigurer{

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("doc.html").addResourceLocations("classpath*:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath*:/META-INF/resources/webjars/");
	}*/

	private static Logger logger= LoggerFactory.getLogger(SwaggerBootstrapUiDemoApplication.class);


	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application=SpringApplication.run(SwaggerBootstrapUiDemoApplication.class, args);
		Environment env = application.getEnvironment();
		logger.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:{}\n\t" +
						"External: \thttp://{}:{}\n\t"+
						"Doc: \thttp://{}:{}/doc.html\n"+
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));
	}


}

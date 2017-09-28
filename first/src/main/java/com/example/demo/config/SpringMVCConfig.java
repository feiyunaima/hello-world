package com.example.demo.config;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration //申明这是一个配置
public class SpringMVCConfig extends WebMvcConfigurerAdapter {
    

	//自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	HandlerInterceptor handlerInterceptor = new HandlerInterceptor(){

			@Override
			public boolean preHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler)
					throws Exception {
				// TODO Auto-generated method stub
				System.out.println("自定义拦截器");
				return true;
			}

			@Override
			public void postHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterCompletion(HttpServletRequest request,
					HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	
    	registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    	
    	
       
    }

	
    @Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
    	super.configureMessageConverters(converters);
    	StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
    	converters.add(converter);
		
	}

    
    
}

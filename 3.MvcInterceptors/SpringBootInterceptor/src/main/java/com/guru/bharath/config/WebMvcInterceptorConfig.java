package com.guru.bharath.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcInterceptorConfig implements WebMvcConfigurer {

	
	@Bean
	public Interceptor interceptor() {
		Interceptor i = new Interceptor();
			return i;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
	}

}

class Interceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Inside pre handle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.addHeader("bharath", "Bharath the Great");
		response.setHeader("bharath", "Bharath the Great");
		System.out.println("Inside post handle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		response.addHeader("bharath", "Bharath the Great");
		System.out.println("Inside after completion");
		response.setHeader("bharath", "Bharath the Great");
	}
}

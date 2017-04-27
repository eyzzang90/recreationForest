package com.example.mongo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 이거 지금 설정이 안먹혀서 context-main.xml에 별도로 PageableHandlerMethodAraumentResolver 설정함
 * @author eyzzang
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
    	
    	PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
    	resolver.setFallbackPageable(new PageRequest(0, 30));		
    	argumentResolvers.add(resolver);
    	
    	super.addArgumentResolvers(argumentResolvers);
    }
}

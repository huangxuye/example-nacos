package com.wxuy.example.nacos.nacosconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	/**
	 * Ribbon调用方式所需要配哦之
	 * Nacos Discovery Starter 默认集成了 Ribbon ，所以对于使用了 Ribbon 做负载均衡的组件，可以直接使用 Nacos 的服务发现。
	 * 添加 @LoadBlanced 注解，使得 RestTemplate 接入 Ribbon
	 * @return 工具类
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

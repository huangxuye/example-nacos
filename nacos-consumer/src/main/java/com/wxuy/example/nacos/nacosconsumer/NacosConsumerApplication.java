package com.wxuy.example.nacos.nacosconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.wxuy.example"})
public class NacosConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerApplication.class, args);
	}

}

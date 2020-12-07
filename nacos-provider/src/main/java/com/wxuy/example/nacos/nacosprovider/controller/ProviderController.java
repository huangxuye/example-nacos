package com.wxuy.example.nacos.nacosprovider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wxuy.example.nacos.api.pojo.Demo;
import com.wxuy.example.nacos.nacosprovider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController {

	@Autowired
	ProviderService providerService;

	@Value("${yml-source.name}")
	private String ymlSource;

	@PostMapping("/nacos/provider/add")
	public boolean add(Demo demo) {
		return providerService.add(demo);
	}

	@GetMapping("/nacos/provider/{id}")
	@SentinelResource(value = "/nacos/consumer/feign/{id}", fallback = "sentinelFallback")
	public Demo queryById(@PathVariable("id") Long id) {
		if(id ==10){
			throw new RuntimeException("id => " + id + ",不存在该用户，或者无法找到,");
		}
		return providerService.queryById(id);
	}

	@GetMapping("/nacos/provider/list")
	public List<Demo> queryAll() {
		return providerService.queryAll();
	}
	public Demo sentinelFallback(@PathVariable("id") Long id){
		return new Demo().setDemoID(id)
				.setDemoName("id => " + id + "没有对应的信息，null--@Sentinel配置文件来源:"+ymlSource)
				.setDb_source("no this database in mysql");
	}
}

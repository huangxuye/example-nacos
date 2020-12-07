package com.wxuy.example.nacos.nacosconsumer.service;


import com.wxuy.example.nacos.api.pojo.Demo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "nacos-provider", fallback = FeignServiceFallBackFactory.class)
@Component
public interface FeignService {

	@PostMapping("/nacos/provider/add")
	public boolean add(Demo demo);

	@GetMapping("/nacos/provider/{id}")
	public Demo queryById(@PathVariable("id") Long id);

	@GetMapping("/nacos/provider/list")
	public List<Demo> queryAll();
}

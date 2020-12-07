package com.wxuy.example.nacos.nacosconsumer.controller;

import com.wxuy.example.nacos.api.pojo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RequestMapping("/nacos/consumer")
@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public boolean add(Demo demo) {
		return restTemplate.getForObject("http://nacos-provider/nacos/provider/add",Boolean.class);
	}

	@GetMapping("/{id}")
	public Demo queryById(@PathVariable("id") Long id) {
		return restTemplate.getForObject("http://nacos-provider/nacos/provider/"+id,Demo.class);

	}

	@GetMapping("/list")
	public List<Demo> queryAll() {
		return restTemplate.getForObject("http://nacos-provider/nacos/provider/list",List.class);
	}
}

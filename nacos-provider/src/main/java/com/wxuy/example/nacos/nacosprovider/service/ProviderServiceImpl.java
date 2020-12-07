package com.wxuy.example.nacos.nacosprovider.service;


import com.wxuy.example.nacos.api.pojo.Demo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{
	public boolean add(Demo dept) {
		return true;
	}

	public Demo queryById(Long id) {
		return new Demo().setDemoID(id).setDemoName("nacos-service").setDb_source("dataBase");
	}

	public List<Demo> queryAll() {
		ArrayList<Demo> demos = new ArrayList<Demo>();
		demos.add(new Demo().setDemoID(1L).setDemoName("nacos-service").setDb_source("dataBase"));
		demos.add(new Demo().setDemoID(2L).setDemoName("nacos-service").setDb_source("dataBase"));
		demos.add(new Demo().setDemoID(3L).setDemoName("nacos-service").setDb_source("dataBase"));
		return demos;
	}
}

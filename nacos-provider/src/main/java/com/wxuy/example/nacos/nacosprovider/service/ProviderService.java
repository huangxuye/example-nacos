package com.wxuy.example.nacos.nacosprovider.service;



import com.wxuy.example.nacos.api.pojo.Demo;

import java.util.List;

public interface ProviderService {

	boolean add(Demo dept);

	Demo queryById(Long id);

	 List<Demo> queryAll();

}

package ds.ltl.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ds.ltl.springcloud.web.service.RestTemplateService;

/**
 * RestTemplate实现服务访问的端控制器
 * 
 * @author ltl
 * @date 2017年7月21日 下午6:25:10
 */
@RestController
@RequestMapping("/rest-tpl")
public class RestTemplateController {

	// @Autowired
	// private RestTemplate restTemplate; // 使用RestRemplate实现微服务访问,

	@Autowired
	private RestTemplateService restTemplateService;

	@RequestMapping(value = "/user/{name}")
	public Object getUserByName(@PathVariable String name) {
		return restTemplateService.getUserByName(name);
	}

	@RequestMapping(value = "/user/getUserById")
	public Object getUserById(String id) {
		return restTemplateService.getUserById(id);
	}
}

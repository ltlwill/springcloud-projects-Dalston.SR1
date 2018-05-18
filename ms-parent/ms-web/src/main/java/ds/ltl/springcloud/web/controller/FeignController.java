package ds.ltl.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ds.ltl.springcloud.web.client.UserFeignClient;

/**
 * 使用Feign来实现服务调用的前端控制器
 * 
 * @author ltl
 * @date 2017年7月24日 上午11:29:29
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
	
	@Autowired
	private UserFeignClient userFeignClient; // feign实现的服务访问接口
	
	@RequestMapping("/user/{name}")
	public String getUserByName(@PathVariable String name){
		// 使用feign提供的实现方式调用服务
		return userFeignClient.getUserByName(name);
	}
	
	@RequestMapping("/user/getUserById")
	public String getUserById(String id){
		// 使用feign提供的实现方式调用服务
		return userFeignClient.getUserById(id);
	}

}

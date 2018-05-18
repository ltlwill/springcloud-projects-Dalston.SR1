package ds.ltl.springcloud.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用Feign实现服务调用
 * @author ltl
 * @date 2017年7月24日 上午11:05:28
 */
// 使用@FeignClient注解来绑定对应eureka-client（服务名称，即服务提供者名称）服务,value:服务名，fallback：使用hystrix做断路器时指定的失败回调函数，可不选
@FeignClient(value = "eureka-client",fallback = UserFeignClientHystrixFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/user/{name}") // Spring MVC支持feign,这里@RequestMapping的意思是：将/user/{name}绑定到服务eureka-client中的/user/{name}请求URL上
	String getUserByName(@PathVariable("name") String name); // 这里@PathVariable的意思是：传递一个name参数，name来源于URL中
	
	@RequestMapping(value="/user/getUserById")
	String getUserById(@RequestParam("id") String id);

}








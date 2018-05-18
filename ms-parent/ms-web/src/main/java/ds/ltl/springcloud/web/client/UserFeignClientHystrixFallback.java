package ds.ltl.springcloud.web.client;

import org.springframework.stereotype.Component;

/**
 * feign中使用hystrix断路器（可不指定）
 * 
 * @author ltl
 * @date 2017年7月24日 下午5:00:56
 */
@Component
public class UserFeignClientHystrixFallback implements UserFeignClient {

	@Override
	public String getUserByName(String name) {
		return "Feign getUserByName error:" + name;
	}

	@Override
	public String getUserById(String id) {
		return "Feign getUserById error:" + id;
	}

}

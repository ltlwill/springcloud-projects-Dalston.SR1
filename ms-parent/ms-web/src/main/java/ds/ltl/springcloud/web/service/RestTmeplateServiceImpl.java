package ds.ltl.springcloud.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * RestTemplate实现微服务访问的业务接口实现类
 * 
 * @author ltl
 * @date 2017年7月24日 下午4:17:03
 */
@Service
public class RestTmeplateServiceImpl extends CommonServiceImpl implements
		RestTemplateService {

	private final static String SERVICE_NAME = "eureka-client";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	// hystrix断路器回调方法
	@HystrixCommand(fallbackMethod = "restTemplateServiceFallBack")
	public String getUserByName(String name) {
		// 在浏览器中输入localhost:8740/web/user/ltlwill，即可返回服务提供者中的相印接口数据
		// return restTemplate.getForEntity("http://eureka-client/user/" + name,
		// String.class).getBody();
		return restTemplate.getForEntity(
				createRestTemplateUrl(SERVICE_NAME, "/user/" + name),
				String.class).getBody();
	}

	@Override
	// hystrix断路器回调方法
	@HystrixCommand(fallbackMethod = "restTemplateServiceFallBack")
	public String getUserById(String id) {
		// return restTemplate.getForEntity(
		// "http://eureka-client/user/getUserById?id=" + id, String.class)
		// .getBody();
		return restTemplate.getForEntity(
				createRestTemplateUrl(SERVICE_NAME, "/user/getUserById?id="
						+ id), String.class).getBody();
	}
	
	/**
	 * hystrix断路器回调方法（注：如果这个方法的参数与原方法（如：getUserByName）的参数个数、类型不一致，则会出现：fallback method wasn't found）
	 * 
	 * @return
	 */
	public String restTemplateServiceFallBack(String ex) {
		return "RestTemplate Error:" + ex;
	}
}

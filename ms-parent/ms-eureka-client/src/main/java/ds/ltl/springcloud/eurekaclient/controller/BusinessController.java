package ds.ltl.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

/**
 * 业务控制器
 * 
 * @author ltl
 * @date 2017年7月19日 下午2:41:06
 */

@RestController
@RequestMapping("/business")
public class BusinessController extends BaseController {

	private final static String HOST_NAME = "eureka-client"; // 指spring.application.name
	
	@Autowired
	private EurekaClient eurekaClient;       // 使用原生方式

	@Autowired
	private DiscoveryClient discoveryClient; // 使用spring封装方式，不需要关注服务发现的实现（无论是eureka、consul、zookeeper），推荐

	@RequestMapping("/getEurekaService")
	public Object getEurekaServiceName() {
		return "Serivce Name(EurekaClient):"
				+ eurekaClient.getNextServerFromEureka(HOST_NAME, false)
				+ ";Serivce Name(DiscoveryClient):"
				+ discoveryClient.getServices();
	}

}
